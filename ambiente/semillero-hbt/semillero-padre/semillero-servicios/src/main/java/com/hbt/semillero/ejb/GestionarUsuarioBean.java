/**
 * GestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entities.EstadoUsuarioEnum;
import com.hbt.semillero.entities.Persona;
import com.hbt.semillero.entities.Usuario;

/**
 * <b>Descripción:<b> Clase que implementa la interfaz que define los metodos de logica de negocio para la entidad Usuario
 * <b>Caso de Uso:<b> 
 * @author Gabriel Huertas
 * @version 
 */
@Stateless
public class GestionarUsuarioBean implements IGestionarUsuarioLocal{
	
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)//Crea una transaccion nueva
	public void crearUsuario(UsuarioDTO usuarioNuevo) throws Exception {
		String nombreGenerado = generateUserName();
		if(consultarUsuarioPorNombreUsuario(nombreGenerado).isEmpty()) {
			usuarioNuevo.setNombre(nombreGenerado);
			Usuario usuario = usuarioDTOToUsuario(usuarioNuevo);
			em.persist(usuario);
		}else {
			throw new Exception("Nombre de usuario "+nombreGenerado+" ya está asignado");
		}
		
	}

	/** 
	 * @throws Exception 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#modificarNombreUsuario(java.lang.Long, java.lang.String, com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UsuarioDTO modificarNombreUsuario(Long id, String nombre, UsuarioDTO usuarioDTONuevo) throws Exception {
		Usuario usuarioModificar;
		if (usuarioDTONuevo == null) {
			usuarioModificar = em.find(Usuario.class, id);
		} else {
			usuarioModificar = usuarioDTOToUsuario(usuarioDTONuevo);
		}
		
		if(isValidUserName(nombre)) {
			usuarioModificar.setNombre(nombre);
		}else {
			throw new Exception("Nombre es inválido");
		}
		em.merge(usuarioModificar);
		return usuarioToUsuarioDTO(usuarioModificar);
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#inactivarUsuario(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public UsuarioDTO inactivarUsuario(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		if(usuario.getEstadoEnum().equals(EstadoUsuarioEnum.ACTIVO)) {
			usuario.setEstadoEnum(EstadoUsuarioEnum.INACTIVO);
			em.merge(usuario);
		}
		return usuarioToUsuarioDTO(usuario);
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuario(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);
		return usuarioDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de consultar si existe uno o más usuarios con el mismo nombre
	 * <b>Caso de Uso</b>
	 * @author Lenovo
	 * 
	 * @param nombreUsuario
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarioPorNombreUsuario(String nombreUsuario) {
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select u from Usuario u where u.nombre=:nombre")
				.setParameter("nombre", nombreUsuario)
				.getResultList();
		for (Usuario usuario : resultados) {
			resultadosUsuarioDTO.add(usuarioToUsuarioDTO(usuario));
		}
		
		return resultadosUsuarioDTO;
	}
	

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuarios()
	 */
	@Override
	public List<UsuarioDTO> consultarUsuarios() {
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select u from Usuario u").getResultList();
		for (Usuario usuario : resultados) {
			resultadosUsuarioDTO.add(usuarioToUsuarioDTO(usuario));
		}
		return resultadosUsuarioDTO;
	}
	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarPersonas()
	 */
	@Override
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosUsuarioDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from Persona p").getResultList();
		for (Persona persona : resultados) {
			resultadosUsuarioDTO.add(personaToPersonaDTO(persona));
		}
		return resultadosUsuarioDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un UsuarioDTO a una entidad Usuario
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setEstadoEnum(usuarioDTO.getEstadoEnum());
		usuario.setPersona(personaDTOToPersona(usuarioDTO.getPersona()));

		return usuario;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un Usuario a UsuarioDTO
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param usuario Entidad de tipo Usuario a convertir
	 * @return
	 */
	private UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.getId() != null) {
			usuarioDTO.setId(usuario.getId());
		}
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setEstadoEnum(usuario.getEstadoEnum());
		usuarioDTO.setPersona(personaToPersonaDTO(usuario.getPersona()));
		return usuarioDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir una Persona a PersonaDTO
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param persona Entidad de tipo Persona a convertir
	 * @return
	 */
	private PersonaDTO personaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();

		if (persona.getId() != null) {
			personaDTO.setId(persona.getId());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumIdentificacion(persona.getNumIdentificacion());
		return personaDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir una PersonaDTO a Persona
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Persona personaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setId(personaDTO.getId());
		persona.setNombre(personaDTO.getNombre());
		persona.setNumIdentificación(personaDTO.getNumIdentificacion());

		return persona;
	}
	
	
	/**
	 * 
	 * Metodo encargado de validar que un nombre sea valido. Esto cumpliendo las siguientes condiciones
	 * 
	 * 1. no debe ser mayor de 7 caracteres
	 * 2. El primer caracter debe ser una letra en mayúsculas 
	 * 3. El segundo caracter debe ser un numero de 0 a 9
	 * 4. Los restantes caracteres solo pueden ser letras en minúsculas
	 * 
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param name
	 * @return true si el nombre cumple con todas las condiciones, de lo contrario false
	 */
	private boolean isValidUserName(String name) {
		return name.length()<=7 
				&& Character.isUpperCase(name.charAt(0)) 
				&& Character.isDigit(name.charAt(1))
				&& name.substring(2, name.length()-1).chars().allMatch(Character::isLowerCase);
	}
	
	/**
	 * 
	 * Metodo encargado de generar un nombre de usuario
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @return nombre generado aleatoriamente
	 */
	private String generateUserName() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		
		//Primer caracter en mayuscula
		int charPos = random.nextInt(CHAR_UPPER.length());
        builder.append(CHAR_UPPER.charAt(charPos));
        
        //Segundo caracter número
        charPos = random.nextInt(NUMBER.length());
        builder.append(NUMBER.charAt(charPos));
        
        //Hasta 5 caracteres en minúscula
        for (int i = 0; i <= random.nextInt(6); i++) {
        	 charPos = random.nextInt(CHAR_LOWER.length());
             builder.append(CHAR_LOWER.charAt(charPos));
		}
        
        return builder.toString();
	}
	
	/**
	 * 
	 * Metodo encargado de verificar si un usuario tiene la cuenta expirada
	 * 
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean isAccountExpired(Usuario usuario) {
		long yearsBetween = ChronoUnit.YEARS.between(usuario.getFechaCreacion(), LocalDate.now());
		return yearsBetween > 0;
	}
	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearPersona(com.hbt.semillero.dto.PersonaDTO)
	 */
	@Override
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = personaDTOToPersona(personaDTO);
		em.persist(persona);
	}

}
