package net.guides.springboot.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import net.guides.springboot.crud.model.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, Long> {
	List<Pedido> findById(int id);

	@Query("{'Employee.id':?0}")
	List<Pedido> findByCity(Long id);
}
