package net.guides.springboot.crud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Producto")
public class Producto {
		
	 @Id
	  private int id;
	    private String name;
	    private List<Vehiculo> vehiculos;
	    private String imagen;
	    
		public Producto(int id, String name, List<Vehiculo> vehiculos, String imagen) {
			this.id = id;
			this.name = name;
			this.vehiculos = vehiculos;
			this.imagen = imagen;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Vehiculo> getVehiculos() {
			return vehiculos;
		}

		public void setVehiculos(List<Vehiculo> vehiculos) {
			this.vehiculos = vehiculos;
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
				return "Producto [id=" + id + ", name=" + name + ", vehiculos=" + vehiculos + ", imagen=" + imagen
						+ "]";
			}
		
	    
	    
}
