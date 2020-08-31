package net.guides.springboot.crud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author diego
 * 
 */
@Document(collection = "Pedido")
public class Pedido {

	@Id
	private int id;
	private String fechaRecibido;
	private String fechaEntrega;
	private String estado;
	private List<Producto> productos;
	private Employee employee;
	private String precioFinal;

	public Pedido() {
		
	}
/**
 * @deprecated
 * @param id
 * @param fechaRecibido
 * @param fechaEntrega
 * @param estado
 * @param productos
 * @param employee
 * @param precioFinal
 */
	public Pedido(int id, String fechaRecibido, String fechaEntrega, String estado, List<Producto> productos,
			Employee employee, String precioFinal) {
		this.id = id;
		this.fechaRecibido = fechaRecibido;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.productos = productos;
		this.employee = employee;
		this.precioFinal = precioFinal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(String fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaRecibido=" + fechaRecibido + ", fechaEntrega=" + fechaEntrega + ", estado="
				+ estado + ", productos=" + productos + ", employee=" + employee + ", precioFinal=" + precioFinal + "]";
	}

}
