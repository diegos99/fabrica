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
import net.guides.springboot.crud.model.Employee;
import net.guides.springboot.crud.model.Pedidos;
import net.guides.springboot.crud.repository.PedidosRepository;
import net.guides.springboot.crud.service.PedidosSequenceGeneratorService;

/**
 * 
 * @author diego
 * @CrossOrigin(origins = "http://localhost:4200") es la url donde se mostrará
 *                      la vista
 * @RestController especifica que esta clase funcionara como un
 *                 controller @RequestMapping("/api/v1") esta es la url del api
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PedidosController {
	@Autowired
	/**
	 * private PedidosRepository repository; este es el repositorio que sirve como
	 * puente con la BD
	 */
	private PedidosRepository repository;
	/**
	 * private PedidosSequenceGeneratorService sequenceGeneratorService; es para
	 * generar id autoincrementable
	 */
	@Autowired
	private PedidosSequenceGeneratorService sequenceGeneratorService;

	/**
	 * El método public Pedidos createPedidos() recibe como parámetro:
	 * 
	 * @param pedidos y retorna:
	 * @return repository.save(pedidos);
	 */
	@PostMapping("/pedido")
	public Pedidos createPedidos(@Valid @RequestBody Pedidos pedidos) {
//		repository.save(pedidos);
//		return "Pedido placed successfully...";
		pedidos.setId(sequenceGeneratorService.generateSequence(Pedidos.SEQUENCE_NAME));
		return repository.save(pedidos);
	}

	/**
	 * esta lista de pedidos retorna todos los pedidos existentes:
	 * 
	 * @return repository.findAll();
	 */
	@GetMapping("/pedido")
	public List<Pedidos> getAllProductos() {
		return repository.findAll();
	}

	/**
	 * Este metodo recibe como parámetro:
	 * 
	 * @param productoId y retorna un cliente en especifico:
	 * @return ResponseEntity.ok().body(pedidos); Si no se encontro el cliente,
	 *         retorna una excepcion:
	 * 
	 */
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedidos> getProductoById(@PathVariable(value = "id") Long productoId)
			throws ResourceNotFoundException {
		Pedidos pedidos = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("PEdido not found for this id : " + productoId));
		return ResponseEntity.ok().body(pedidos);
	}

	/**
	 * Este metodo recibe como parámetros:
	 * 
	 * @param productoId
	 * @param productoDetails y retorna un mensaje de ok:
	 * @return ResponseEntity.ok(updatedProducto); Si no se pudo actualizar, retorna
	 *         una excepcion:
	 * 
	 */
	@PutMapping("/pedido/{id}")
	public ResponseEntity<Pedidos> updateProducto(@PathVariable(value = "id") Long productoId,

			@Valid @RequestBody Pedidos productoDetails) throws ResourceNotFoundException {
		Pedidos pedidos = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id : " + productoId));

		pedidos.setFechaEnvio(productoDetails.getFechaEnvio());
		pedidos.setProducto(productoDetails.getProducto());
		pedidos.setDescripcion(productoDetails.getDescripcion());
		pedidos.setCantidad(productoDetails.getCantidad());
		final Pedidos updatedProducto = repository.save(pedidos);
		return ResponseEntity.ok(updatedProducto);
	}

	/**
	 * Este metodo recibe como parámetros:
	 * 
	 * @param productoId y retorna un mensaje de ok:
	 * @return response de lo contrario retorna una excepcion:
	 * 
	 */
	@DeleteMapping("/pedido/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long productoId)
			throws ResourceNotFoundException {
		Pedidos pedidos = repository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + productoId));

		repository.delete(pedidos);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
