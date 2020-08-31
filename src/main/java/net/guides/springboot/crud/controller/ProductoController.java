package net.guides.springboot.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Producto;
import net.guides.springboot.crud.repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductoController {
	@Autowired
	private ProductoRepository repository;

	@PostMapping("/productos")
	public String placeOrder(@RequestBody Producto producto) {
		repository.save(producto);
		return "Order placed successfully...";
	}

	@GetMapping("/productos")
	public List<Producto> getAllProductos() {
		return repository.findAll();
	}
	
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") Long productoId)
			throws ResourceNotFoundException {
		Producto producto = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found for this id :: " + productoId));
		return ResponseEntity.ok().body(producto);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Long productoId,

			@Valid @RequestBody Producto productoDetails) throws ResourceNotFoundException {
		Producto producto = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + productoId));

		producto.setName(productoDetails.getName());
		producto.setVehiculos(productoDetails.getVehiculos());
		producto.setImagen(productoDetails.getImagen());
		final Producto updatedProducto = repository.save(producto);
		return ResponseEntity.ok(updatedProducto);
	}
	
	@DeleteMapping("/productos/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long productoId)
			throws ResourceNotFoundException {
		Producto producto = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + productoId));

		repository.delete(producto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
