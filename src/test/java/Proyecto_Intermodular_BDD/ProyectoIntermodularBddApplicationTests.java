package Proyecto_Intermodular_BDD;

import Proyecto_Intermodular_BDD.Dominos.Cliente;
import Proyecto_Intermodular_BDD.Servicios.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProyectoIntermodularBddApplicationTests {

	@Autowired
	ClienteService clienteService;

	@Test
	void contextLoads() {
	}

	// PRUEBAS UNITARIAS

	// 1. PRUEBA GUARDAR CLIENTE
	@Test
	void pruebaUno() {
		Cliente cliente = new Cliente(null, "Pepe", "pepe@mail.com", null);

		Cliente guardado = clienteService.guardar(cliente);

		assertNotNull(guardado);
		assertEquals("Pepe", guardado.getNombre());
	}

	// 2. PRUEBA LISTAR TODOS
	@Test
	void pruebaDos() {
		List<Cliente> lista = clienteService.obtenerTodos();
		assertNotNull(lista);
	}

	// 3. BUSCAR POR ID
	@Test
	void pruebaTres() {
		Cliente c = clienteService.encontrarPorId(67L);
		assertNull(c); // como no existe da null
	}

	// PRUEBA DE INTEGRACION

	@Test
	void pruebaIntegracion() {
		// pongo null al id porque la base de datos ya se lo pone solo
		Cliente cliente = new Cliente(null, "Maria", "maria@mail.com", null);

		// Guardamos el cliente
		Cliente cGuardado = clienteService.guardar(cliente);

		//La buscamos por su id
		Cliente cBuscado = clienteService.encontrarPorId(cGuardado.getId());


		//comprobamos si se llama maria
		assertNotNull(cBuscado);
		assertEquals("Maria", cBuscado.getNombre());
	}
}