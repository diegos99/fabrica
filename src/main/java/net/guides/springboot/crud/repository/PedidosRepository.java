package net.guides.springboot.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import net.guides.springboot.crud.model.Pedidos;
/**
 * 
 * @author diego
 *
 */
@Repository
public interface PedidosRepository extends MongoRepository<Pedidos, Long>{
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Pedidos> findById(int id);
}
