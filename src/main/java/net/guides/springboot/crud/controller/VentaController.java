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
import net.guides.springboot.crud.model.Venta;
import net.guides.springboot.crud.repository.VentaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VentaController {
	@Autowired
	private VentaRepository repository;

	@PostMapping("/ventas")
	public String placeOrder(@RequestBody Venta venta) {
		repository.save(venta);
		return "Order placed successfully...";
	}

	@GetMapping("/ventas")
	public List<Venta> getAllProductos() {
		return repository.findAll();
	}
	
	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<Venta> getProductoById(@PathVariable(value = "id") Long ventaId)
			throws ResourceNotFoundException {
		Venta venta = repository.findById(ventaId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found for this id :: " + ventaId));
		return ResponseEntity.ok().body(venta);
	}
	
	@PutMapping("/ventas/{id}")
	public ResponseEntity<Venta> updateProducto(@PathVariable(value = "id") Long ventaId,

			@Valid @RequestBody Venta productoDetails) throws ResourceNotFoundException {
		Venta venta = repository.findById(ventaId)
				.orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + ventaId));

		venta.setCliente(productoDetails.getCliente());
		venta.setRepuesto(productoDetails.getRepuesto());
		venta.setCantidad(productoDetails.getCantidad());
		venta.setTotal(productoDetails.getTotal());
		final Venta updatedProducto = repository.save(venta);
		return ResponseEntity.ok(updatedProducto);
	}
	
	@DeleteMapping("/ventas/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long ventaId)
			throws ResourceNotFoundException {
		Venta venta = repository.findById(ventaId)
				.orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + ventaId));

		repository.delete(venta);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
