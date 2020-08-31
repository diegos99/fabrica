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

//	@Test
//	public void testSuma() {
//		int resultado = net.guides.springboot.crud.model.Calculadora.suma(2, 3);
//		int esperado = 5;
//		assertEquals(esperado, resultado);
//		
//	}
//	
//	@Test
//	public void testResta() {
//		int resultado = net.guides.springboot.crud.model.Calculadora.resta(3, 2);
//		int esperado = 1;
//		assertEquals(esperado, resultado);
//		
//	}
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}

//	@Test
//	public void contextLoads() {
//		System.out.println("Aca no hay nada");
//	}

	@Test
	public void testGetAllPedidos() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/pedidos",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}
	
	
	@Test
	public void testGetPedidoById() {
		Pedido pedido = restTemplate.getForObject(getRootUrl() + "/pedidos/1", Pedido.class);
		System.out.println("este imprime pedido:" + restTemplate.getForObject(getRootUrl() + "/pedidos/1", Pedido.class));
		assertNotNull(pedido);
	}

	@Test
	public void testCreatePedido() {
		Pedido pedido = new Pedido();
		pedido.setId(1);
		pedido.setFechaRecibido("30/04/2020");
		pedido.setFechaEntrega("15/05/2020");
		pedido.setEstado("Pendiente");

		ResponseEntity<Pedido> postResponse = restTemplate.postForEntity(getRootUrl() + "/pedidos", pedido, Pedido.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		System.out.println("este es porst resp:" + pedido);
	}

	@Test
	public void testUpdatePedido() {
		int id = 1;
		Pedido pedido = restTemplate.getForObject(getRootUrl() + "/pedidos/" + id, Pedido.class);
		pedido.setFechaRecibido("20/04/2020");
		pedido.setFechaEntrega("01/05/2020");
		pedido.setEstado("Entregado");

		restTemplate.put(getRootUrl() + "/pedidos/" + id, pedido);

		Pedido updatedPedido = restTemplate.getForObject(getRootUrl() + "/pedidos/" + id, Pedido.class);
		
		assertNotNull(updatedPedido);
	}

	@Test
	public void testDeletePedido() {
		int id = 2;
		Pedido pedido = restTemplate.getForObject(getRootUrl() + "/pedidos/" + id, Pedido.class);
		assertNotNull(pedido);

		restTemplate.delete(getRootUrl() + "/pedidos/" + id);

		try {
			pedido = restTemplate.getForObject(getRootUrl() + "/pedidos/" + id, Pedido.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
