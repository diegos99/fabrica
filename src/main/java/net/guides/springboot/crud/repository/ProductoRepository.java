package net.guides.springboot.crud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import net.guides.springboot.crud.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Long> {
	
}
