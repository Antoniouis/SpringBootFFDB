package Proyecto_Intermodular_BDD.Controladores;

import Proyecto_Intermodular_BDD.Dominos.Tarea;
import Proyecto_Intermodular_BDD.Servicios.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    //CREAR
    @PostMapping("/crear")
    public Tarea crearTarea(@RequestBody Tarea tarea){
        System.out.println("EL ADMIN CREO UN NUEVO TAREA");
        return tareaService.crear(tarea);
    }

    //LEER
    @GetMapping("/listar")
    public List<Tarea> listar(){
        System.out.println("EL ADMIN LISTO TODOS LOS TAREAS");
        return tareaService.listar();
    }

    //LEER POR ID
    @GetMapping("/buscar/{id}")
    public Tarea bucarPorID(@PathVariable Long id){
        System.out.println("EL ADMIN LISTO EL TAREA CON EL ID : " + id);
        return tareaService.listarPorId(id);
    }

    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea){
        System.out.println("EL ADMIN ACTUALIZO EL TAREA CON EL ID : " + id );
        return tareaService.actualizar(id, tarea);
    }

    //BORRAR
    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id){
        System.out.println("EL ADMIN ELIMINO EL TAREA CON EL ID : " + id );
        tareaService.eliminar(id);
    }

}