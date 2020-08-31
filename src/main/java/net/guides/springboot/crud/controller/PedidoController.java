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
import net.guides.springboot.crud.model.Pedido;
import net.guides.springboot.crud.repository.PedidoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PedidoController {
	@Autowired
	private PedidoRepository repository;

	@PostMapping("/pedidos")
	public String placeOrder(@RequestBody Pedido pedido) {
		repository.save(pedido);
		return "Order placed successfully...";
	}

	@GetMapping("/pedidos")
	public List<Pedido> getAllProductos() {
		return repository.findAll();
	}

	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> getProductoById(@PathVariable(value = "id") Long productoId)
			throws ResourceNotFoundException {
		Pedido pedido = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found for this id :: " + productoId));
		return ResponseEntity.ok().body(pedido);
	}

	@PutMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> updateProducto(@PathVariable(value = "id") Long productoId,

			@Valid @RequestBody Pedido productoDetails) throws ResourceNotFoundException {
		Pedido pedido = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + productoId));

		pedido.setFechaRecibido(productoDetails.getFechaRecibido());
		pedido.setFechaEntrega(productoDetails.getFechaEntrega());
		pedido.setEstado(productoDetails.getEstado());
		pedido.setProductos(productoDetails.getProductos());
		pedido.setEmployee(productoDetails.getEmployee());
		pedido.setPrecioFinal(productoDetails.getPrecioFinal());
		final Pedido updatedProducto = repository.save(pedido);
		return ResponseEntity.ok(updatedProducto);
	}

	@DeleteMapping("/pedidos/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long productoId)
			throws ResourceNotFoundException {
		Pedido pedido = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + productoId));

		repository.delete(pedido);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
