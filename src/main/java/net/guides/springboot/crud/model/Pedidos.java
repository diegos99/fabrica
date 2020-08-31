package net.guides.springboot.crud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author diego
 * 
 * @Document(collection = "Pedidos") es para indicar que la clase es un
 *                      documento de mongodb
 * 
 */
@Document(collection = "Pedidos")
public class Pedidos {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	/**
	 * @Id indica que es un atributo identificador unico
	 */
	@Id
	private long id;
	/**Estos son los campos que contiene el documento:
	 * private String fechaEnvio;
	private String producto;
	private String descripcion;
	private String cantidad;
	 */
	private String fechaEnvio;
	private String producto;
	private String descripcion;
	private String cantidad;
/**
 * public Pedidos() {} metodo constructor con todos los campos respectivos.
 */
	public Pedidos() {

	}
/**
 * El método Pedidos() contiene los siguientes parámetros:
 * @param fechaEnvio
 * @param producto
 * @param descripcion
 * @param cantidad
 */
	public Pedidos(String fechaEnvio, String producto, String descripcion, String cantidad) {
		this.fechaEnvio = fechaEnvio;
		this.producto = producto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
/**
 * Este método getter retorna esto:
 * @return id
 */
	public long getId() {
		return id;
	}
/**
 * método setter recibe como parámetro:
 * @param id
 */
	public void setId(long id) {
		this.id = id;
	}
/**
 * Este método getter retorna esto:
 * @return fechaEnvio
 */
	public String getFechaEnvio() {
		return fechaEnvio;
	}
/**
 * método setter recibe como parámetro:
 * @param fechaEnvio
 */
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
/**
 * Este método getter retorna esto:
 * @return producto
 */
	public String getProducto() {
		return producto;
	}
/**
 * método setter recibe como parámetro:
 * @param producto
 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
/**
 * Este método getter retorna esto:
 * @return descripcion
 */

	public String getDescripcion() {
		return descripcion;
	}
/**
 * método setter recibe como parámetro:
 * @param descripcion
 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/**
 * Este método getter retorna esto:
 * @return cantidad
 */
	public String getCantidad() {
		return cantidad;
	}
/**
 * método setter recibe como parámetro:
 * @param cantidad
 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * Este método convierte los campos a string:
	 * public String toString() {}
	 */
	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", fechaEnvio=" + fechaEnvio + ", producto=" + producto + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + "]";
	}

}
