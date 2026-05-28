package Proyecto_Intermodular_BDD.Controladores;

import Proyecto_Intermodular_BDD.Dominos.Proyecto;
import Proyecto_Intermodular_BDD.Servicios.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    //CREAR
    @PostMapping("/crear")
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto){
        System.out.println("EL ADMIN CREO UN NUEVO PROYECTO");
        return proyectoService.guardar(proyecto);
    }

    //LEER
    @GetMapping("/listar")
    public List<Proyecto> listar(){
        System.out.println("EL ADMIN LISTO TODOS LOS PROYECTOS");
        return proyectoService.listar();
    }

    //LEER POR ID
    @GetMapping("/buscar/{id}")
    public Proyecto bucarPorID(@PathVariable Long id){
        System.out.println("EL ADMIN LISTO EL PROYECTO CON EL ID : " + id);
        return proyectoService.encontrarPorid(id);
    }

    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public Proyecto actualizar(@PathVariable Long id, @RequestBody Proyecto proyecto){
        System.out.println("EL ADMIN ACTUALIZO EL PROYECTO CON EL ID : " + id);
        return proyectoService.actualizar(id, proyecto);
    }

    //BORRAR
    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id){
        System.out.println("EL ADMIN ELIMINO EL PROYECTO CON EL ID : " + id);
        proyectoService.eliminar(id);
    }

}