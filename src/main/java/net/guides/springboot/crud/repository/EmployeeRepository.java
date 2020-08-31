package net.guides.springboot.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot.crud.model.Employee;
/**
 * 
 * @author diego
 *
 */
@Repository
/**
 * interface EmployeeRepository Esta interfaz recibe como parámetro:
 * @Params Employee
 * @Params Long
 */
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

}
