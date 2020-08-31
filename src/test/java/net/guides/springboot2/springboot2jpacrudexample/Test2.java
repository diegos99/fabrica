package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import net.guides.springboot.crud.model.Employee;
import net.guides.springboot.crud.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Test2 {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given
	    Employee alex = new Employee("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    Employee found = employeeRepository.findByFirstName(alex.getFirstName());
	 
	    // then
	    assertThat(found.getFirstName())
	      .isEqualTo(alex.getFirstName());
	}
}
