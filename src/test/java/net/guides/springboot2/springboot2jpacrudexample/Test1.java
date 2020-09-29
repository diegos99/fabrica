package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import net.guides.springboot.crud.Application;
import net.guides.springboot.crud.model.Pedido;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {

	@Test
	public void testSuma() {
		int resultado = net.guides.springboot.crud.model.Calculadora.suma(2, 3);
		int esperado = 5;
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testResta() {
		int resultado = net.guides.springboot.crud.model.Calculadora.resta(3, 2);
		int esperado = 1;
		assertEquals(esperado, resultado);
		
	}
	
	
	@Test
	public void contextLoads() {
		System.out.println("Aca no hay nada");
	}


}
