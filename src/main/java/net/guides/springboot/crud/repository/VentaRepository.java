package net.guides.springboot.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import net.guides.springboot.crud.model.Venta;

public interface VentaRepository extends MongoRepository<Venta, Long> {

}
