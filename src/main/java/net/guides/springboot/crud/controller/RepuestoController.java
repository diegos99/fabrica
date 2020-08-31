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
import net.guides.springboot.crud.model.Repuesto;
import net.guides.springboot.crud.repository.RepuestoRepository;
import net.guides.springboot.crud.service.RepuestoSequenceGeneratorService;
/**
 * 
 * @author diego
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RepuestoController {
	@Autowired
	private RepuestoRepository repuestoRepository;
	
	@Autowired
	private RepuestoSequenceGeneratorService repuestoSequenceGeneratorService;

	@GetMapping("/repuestos")
	public List<Repuesto> getAllRepuestos() {
		return repuestoRepository.findAll();
	}

	@GetMapping("/repuestos/{id}")
	public ResponseEntity<Repuesto> getRepuestoById(@PathVariable(value = "id") Long repuestoId)
			throws ResourceNotFoundException {
		Repuesto repuesto = repuestoRepository.findById(repuestoId)
				.orElseThrow(() -> new ResourceNotFoundException("Repuesto not found for this id :: " + repuestoId));
		return ResponseEntity.ok().body(repuesto);
	}

	@PostMapping("/repuestos")
	public Repuesto createRepuesto(@Valid @RequestBody Repuesto repuesto) {
		repuesto.setId(repuestoSequenceGeneratorService.generateSequence(Repuesto.SEQUENCE_NAME));
		return repuestoRepository.save(repuesto);
	}

	@PutMapping("/repuestos/{id}")
	public ResponseEntity<Repuesto> updateRepuesto(@PathVariable(value = "id") Long repuestoId,
			@Valid @RequestBody Repuesto repuestoDetails) throws ResourceNotFoundException {
		Repuesto repuesto = repuestoRepository.findById(repuestoId)
				.orElseThrow(() -> new ResourceNotFoundException("Repuesto not found for this id :: " + repuestoId));

		repuesto.setNombre(repuestoDetails.getNombre());
		repuesto.setDescripcion(repuestoDetails.getDescripcion());
		repuesto.setStock(repuestoDetails.getStock());
		repuesto.setNo_parte(repuestoDetails.getNo_parte());
		repuesto.setPrecio_venta(repuestoDetails.getPrecio_venta());
		final Repuesto updatedRepuesto = repuestoRepository.save(repuesto);
		return ResponseEntity.ok(updatedRepuesto);
	}

	@DeleteMapping("/repuestos/{id}")
	public Map<String, Boolean> deleteRepuesto(@PathVariable(value = "id") Long repuestoId)
			throws ResourceNotFoundException {
		Repuesto repuesto = repuestoRepository.findById(repuestoId)
				.orElseThrow(() -> new ResourceNotFoundException("Repuesto not found for this id :: " + repuestoId));

		repuestoRepository.delete(repuesto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
