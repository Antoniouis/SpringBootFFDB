package Proyecto_Intermodular_BDD.Controladores;

import Proyecto_Intermodular_BDD.Dominos.Empleado;
import Proyecto_Intermodular_BDD.Servicios.EmpleadoService;
import Proyecto_Intermodular_BDD.Servicios.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/empleados")
public class EmpleadosController {
    @Autowired
    private EmpleadoService empleadoService;

    //LISTAR TODOS LOS EMPLEADOS
    @GetMapping("/listar")
    public List<Empleado> listar(){
        return empleadoService.listarEmpleados();
    }

    //BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public Empleado buscar(@PathVariable Long id){
        return empleadoService.buscarPorId(id);
    }


    //CREAR NUEVO EMPLEADO
    @PostMapping("/crear")
    public Empleado crear(@RequestBody Empleado empleado){
        return empleadoService.guardar(empleado);
    }

    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public Empleado actualizar(@PathVariable Long id ,@RequestBody Empleado empleado){
        return empleadoService.actualizar(id,empleado);
    }

    //ELIMINAR
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id ){
        empleadoService.eliminar(id);
    }

}
