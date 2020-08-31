package net.guides.springboot.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 
 * @author diego 
 */
/**
 * 
 * @Document (collection = "Employee") define que asi se llamara el documento
 *
 */
@Document(collection = "Carro")
public class Carro {
	private int id;
	private String marca;
	private String linea;
	private String anio;
	
	/**
	 * El metodo Carro() contiene los siguientes parametros:
	 * @param id
	 * @param marca
	 * @param linea
	 * @param anio
	 */
	public Carro(int id, String marca, String linea, String anio) {
		this.id = id;
		this.marca = marca;
		this.linea = linea;
		this.anio = anio;
	}
	/**
	 * Este método getter retorna esto:
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * método setter recibe como parámetro:
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Este método getter retorna esto:
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * método setter recibe como parámetro:
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * Este método getter retorna esto:
	 * @return linea
	 */
	public String getLinea() {
		return linea;
	}
	/**
	 * método setter recibe como parámetro:
	 * @param linea
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}
	/**
	 * Este método getter retorna esto:
	 * @return anio
	 */
	public String getAnio() {
		return anio;
	}
	/**
	 * método setter recibe como parámetro:
	 * @param anio
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * Este método convierte los campos a string:
	 * public String toString() {}
	 */
	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", linea=" + linea + ", anio=" + anio + "]";
	}
	
	
}
