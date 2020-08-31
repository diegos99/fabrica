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
import net.guides.springboot.crud.model.Carro;
import net.guides.springboot.crud.model.Producto;
import net.guides.springboot.crud.repository.VehiculoRepository;
import net.guides.springboot.crud.service.VehiculoSequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VehiculoController {

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@GetMapping("/vehiculos")
	public List<Carro> getAllVehiculos() {
		return vehiculoRepository.findAll();
	}

	@GetMapping("/vehiculos/{id}")
	public ResponseEntity<Carro> getVehiculoById(@PathVariable(value = "id") Long carroId)
			throws ResourceNotFoundException {
		Carro carro = vehiculoRepository.findById(carroId)
				.orElseThrow(() -> new ResourceNotFoundException("Carro not found for this id :: " + carroId));
		return ResponseEntity.ok().body(carro);
	}

	/*
	 * @PostMapping("/vehiculos") public Carro createVehiculo(@Valid @RequestBody
	 * Carro carro) {
	 * carro.setId(vehiculoSequenceGeneratorService.generateSequence(Carro.
	 * SEQUENCE_NAME)); return vehiculoRepository.save(carro); }
	 */

	@PostMapping("/vehiculos")
	public String placeVehiculo(@RequestBody Carro carro) {
		vehiculoRepository.save(carro);
		return "Order placed successfully...";
	}
	
	@PutMapping("/vehiculos/{id}")
	public ResponseEntity<Carro> updateVehiculo(@PathVariable(value = "id") Long carroId,

			@Valid @RequestBody Carro vehiculoDetails) throws ResourceNotFoundException {
		Carro carro = vehiculoRepository.findById(carroId)
				.orElseThrow(() -> new ResourceNotFoundException("Carro not found for this id :: " + carroId));

		carro.setId(vehiculoDetails.getId());
		carro.setMarca(vehiculoDetails.getMarca());
		carro.setLinea(vehiculoDetails.getLinea());
		carro.setAnio(vehiculoDetails.getAnio());
		final Carro updatedVehiculo = vehiculoRepository.save(carro);
		return ResponseEntity.ok(updatedVehiculo);
	}

	@DeleteMapping("/vehiculos/{id}")
	public Map<String, Boolean> deleteVehiculo(@PathVariable(value = "id") Long carroId)
			throws ResourceNotFoundException {
		Carro carro = vehiculoRepository.findById(carroId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found for this id :: " + carroId));

		vehiculoRepository.delete(carro);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
