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

    //LISTAR
    @GetMapping("/listar")
    public List<Tarea> listar(){
        return tareaService.listar();
    }

    //BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public Tarea buscar(@PathVariable Long id){
        return tareaService.listarPorId(id);
    }

    //CREAR TAREA
    @PostMapping("/crear")
    public Tarea crear(@RequestBody Tarea tarea){
        return tareaService.crear(tarea);
    }

    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public Tarea actualizar(@PathVariable Long id , @RequestBody Tarea tarea){
        return tareaService.actualizar(id, tarea);
    }

    //BORRAR
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id){
        tareaService.eliminar(id);
    }




}
