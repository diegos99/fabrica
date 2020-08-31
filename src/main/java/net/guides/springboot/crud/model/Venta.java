package net.guides.springboot.crud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author diego
 *
 */
@Document(collection = "Venta")
public class Venta {
	@Id
	private int id;
	private String cliente;
	private String repuesto;
	private String cantidad;
	private String total;
/**
 * 
 * @param id
 * @param cliente
 * @param repuesto
 * @param cantidad
 * @param total
 */
	public Venta(int id, String cliente, String repuesto, String cantidad, String total) {
		this.id = id;
		this.cliente = cliente;
		this.repuesto = repuesto;
		this.cantidad = cantidad;
		this.total = total;
	}
/**
 * 
 * @return id
 */
	public int getId() {
		return id;
	}
/**
 * 
 * @param id
 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * 
 * @return cliente
 */
	public String getCliente() {
		return cliente;
	}
/**
 * 
 * @param cliente
 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
/**
 * 
 * @return repuesto
 */
	public String getRepuesto() {
		return repuesto;
	}
/**
 * 
 * @param repuesto
 */
	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}
/**
 * 
 * @return cantidad
 */
	public String getCantidad() {
		return cantidad;
	}
/**
 * 
 * @param cantidad
 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
/**
 * 
 * @return total
 */
	public String getTotal() {
		return total;
	}
/**
 * 
 * @param total
 */
	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", cliente=" + cliente + ", repuesto=" + repuesto + ", cantidad=" + cantidad
				+ ", total=" + total + "]";
	}


}
