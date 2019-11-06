/**
 * @description Clase ComicDTO que contiene la informacion del objeto tipo Comic
 * 
 * @author Gabriel Ricardo Amaya Huertas <gabriel970826@gmail.com>
 */
export class MiComicDTO {

    /**
    * Identificador del comic
    */
    public id: number;

    /**
    * nombre del comic
    */
    public nombre: string;

    /**
    * editorial del comic.
    */
    public editorial: string;

    /**
    * tematica del comic
    */
    public tematica: string;

    /**
     * numero de paginas del comic
     */
    public numeroPaginas: number;

    /**
    * Iprecio del comic
    */
    public precio: number;

    /**
     * autores del comic
     */
    public autores: string;

    /**
    * define si el comic es a color o no
    */
    public aColor: boolean;

    /**
    * fecha de venta del comic
    */
    public fechaVenta: Date;

    /**
    * Estado del comic
    */
    public estado: string;

    constructor(id: number, nombre: string, editorial: string, tematica: string, numeroPaginas: number,
        precio: number, autores: string, aColor: boolean, fechaVenta: Date, estado: string) {

            this.id = id;
            this.nombre = nombre;
            this.editorial = editorial;
            this.tematica = tematica;
            this.numeroPaginas = numeroPaginas;
            this.precio = precio;
            this.autores = autores;
            this.aColor = aColor;
            this.fechaVenta = fechaVenta;
            this.estado = estado;
    }
} 