package net.guides.springboot.crud.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author diego
 *@deprecated
 */
@Document (collection = "Repuesto")
public class Repuesto {
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String nombre;
	private String descripcion;
	private String stock;
	private String no_parte;
	private String precio_venta;
	private String imagen;
	/**
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param stock
	 * @param no_parte
	 * @param precio_venta
	 */
	public Repuesto(String nombre, String descripcion, String stock, String no_parte,
			String precio_venta, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.no_parte = no_parte;
		this.precio_venta = precio_venta;
		this.imagen = imagen;
	}
/**
 * 
 * @return id
 */
	public long getId() {
		return id;
	}
/**
 * 
 * @param id
 */
	public void setId(long id) {
		this.id = id;
	}
/**
 * 
 * @return nombre
 */
	public String getNombre() {
		return nombre;
	}
/**
 * 
 * @param nombre
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * 
 * @return descripcion
 */
	public String getDescripcion() {
		return descripcion;
	}
/**
 * 
 * @param descripcion
 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/**
 * stock
 * @return
 */
	public String getStock() {
		return stock;
	}
/**
 * 
 * @param stock
 */
	public void setStock(String stock) {
		this.stock = stock;
	}
/**
 * 
 * @return no_parte
 */
	public String getNo_parte() {
		return no_parte;
	}
/**
 * 
 * @param no_parte
 */
	public void setNo_parte(String no_parte) {
		this.no_parte = no_parte;
	}
/**
 * 
 * @return precio_venta
 */
	public String getPrecio_venta() {
		return precio_venta;
	}
	
	/**
	 * 
	 * @param precio_venta
	 */
		public void setPrecio_venta(String precio_venta) {
			this.precio_venta = precio_venta;
		}
/**
 * 
 * @param imagen
 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * 
	 * @return imagen
	 */
		public String getImagen() {
			return imagen;
		}
	@Override
	public String toString() {
		return "Repuesto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", no_parte=" + no_parte + ", precio_venta=" + precio_venta + ", imagen=" + imagen + "]";
	}
	
	
	
	
}
