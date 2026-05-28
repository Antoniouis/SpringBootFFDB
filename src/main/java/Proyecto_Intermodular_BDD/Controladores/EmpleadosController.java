package Proyecto_Intermodular_BDD.Controladores;

import Proyecto_Intermodular_BDD.Dominos.Empleado;
import Proyecto_Intermodular_BDD.Servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadoService empleadoService;

    //CREAR
    @PostMapping("/crear")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        System.out.println("EL ADMIN CREO UN NUEVO EMPLEADO");
        return empleadoService.guardar(empleado);
    }

    //LEER
    @GetMapping("/listar")
    public List<Empleado> listar(){
        System.out.println("EL ADMIN LISTO TODOS LOS EMPLEADOS");
        return empleadoService.listarEmpleados();
    }

    //LEER POR ID
    @GetMapping("/buscar/{id}")
    public Empleado bucarPorID(@PathVariable Long id){
        System.out.println("EL ADMIN LISTO EL EMPLEADO CON EL ID : " + id);
        return empleadoService.buscarPorId(id);
    }

    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado){
        System.out.println("EL ADMIN ACTUALIZO EL EMPLEADO CON EL ID : " + id);
        return empleadoService.actualizar(id, empleado);
    }

    //BORRAR
    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id){
        System.out.println("EL ADMIN ELIMINO EL EMPLEADO CON EL ID : " + id);
        empleadoService.eliminar(id);
    }

}