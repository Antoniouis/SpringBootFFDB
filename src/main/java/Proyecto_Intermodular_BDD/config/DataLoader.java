package Proyecto_Intermodular_BDD.config;

import Proyecto_Intermodular_BDD.Dominos.Cliente;
import Proyecto_Intermodular_BDD.Dominos.Empleado;
import Proyecto_Intermodular_BDD.Dominos.Proyecto;
import Proyecto_Intermodular_BDD.Dominos.Tarea;
import Proyecto_Intermodular_BDD.Repositorios.ClienteRepository;
import Proyecto_Intermodular_BDD.Repositorios.EmpleadoRepository;
import Proyecto_Intermodular_BDD.Repositorios.ProyectoRepository;
import Proyecto_Intermodular_BDD.Repositorios.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====== INICIANDO CARGA DE DATOS DESDE LA CARPETA CONFIG ======");

        // 1. CREAR CLIENTES
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("ACME Corp");
        cliente1.setEmail("contacto@acme.com");
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Industrias Stark");
        cliente2.setEmail("info@stark.com");
        clienteRepository.save(cliente2);


        // 2. CREAR PROYECTOS (Asociados a los clientes recién creados)
        Proyecto proyecto1 = new Proyecto();
        proyecto1.setNombre("Desarrollo Web E-Commerce");
        proyecto1.setEstado("EN_PROCESO");
        proyecto1.setCliente(cliente1);
        proyectoRepository.save(proyecto1);

        Proyecto proyecto2 = new Proyecto();
        proyecto2.setNombre("Sistema de Seguridad Inteligente");
        proyecto2.setEstado("PLANIFICADO");
        proyecto2.setCliente(cliente2);
        proyectoRepository.save(proyecto2);


        // 3. CREAR EMPLEADOS
        Empleado emp1 = new Empleado();
        emp1.setNombre("Alejandro Gómez");
        emp1.setRol("Desarrollador Backend");
        empleadoRepository.save(emp1);

        Empleado emp2 = new Empleado();
        emp2.setNombre("Sofía Rodríguez");
        emp2.setRol("Diseñadora UX/UI");
        empleadoRepository.save(emp2);


        // 4. CREAR TAREAS (Asociadas a un Proyecto y asignadas a un Empleado)
        Tarea tarea1 = new Tarea();
        tarea1.setTitulo("Diseñar Base de Datos");
        tarea1.setEstado("PENDIENTE");
        tarea1.setProyecto(proyecto1); // Pertenece al proyecto E-Commerce
        tarea1.setEmpleado(emp1);      // Asignada a Alejandro Gómez
        tareaRepository.save(tarea1);

        Tarea tarea2 = new Tarea();
        tarea2.setTitulo("Crear Wireframes del Home");
        tarea2.setEstado("EN_PROCESO");
        tarea2.setProyecto(proyecto1); // También pertenece al E-Commerce
        tarea2.setEmpleado(emp2);      // Asignada a Sofía Rodríguez
        tareaRepository.save(tarea2);

        System.out.println("====== CARGA DE DATOS DESDE CONFIG COMPLETADA CON ÉXITO ======");
    }
}
