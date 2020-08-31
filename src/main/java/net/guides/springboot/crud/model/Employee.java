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
 * @Document (collection = "Employee") define que asi se llamara el documento 
 */
@Document (collection = "Employee")
public class Employee {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String firstName;
	private String lastName;
	private String ruta;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String password;
	/**
	 * método constructor
	 */
	public Employee() {
		
	}
	/**
	 * El metodo Employee(){} recibe como parametros:
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param ruta
	 */
	public Employee(String firstName, String lastName, String password, String ruta) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.ruta = ruta;
	}
	/**
	 * Este método getter retorna esto:
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * Este método setter recibe como parametro esto:
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Este método getter retorna esto:
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Este método setter recibe como parametro esto:
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Este método getter retorna esto:
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Este método setter recibe como parametro esto:
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Este método getter retorna esto:
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Este método setter recibe como parametro esto:
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Este método getter retorna esto:
	 * @return ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * Este método setter recibe como parametro esto:
	 * @param ruta
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	/**
	 * Este método convierte los campos a string:
	 * public String toString() {}
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ruta=" + ruta
				+ ", password=" + password + "]";
	}
	
}
