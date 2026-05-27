package Proyecto_Intermodular_BDD.Controladores;

import Proyecto_Intermodular_BDD.Dominos.Proyecto;
import Proyecto_Intermodular_BDD.Repositorios.ProyectoRepository;
import Proyecto_Intermodular_BDD.Servicios.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    //LISTAR
    @GetMapping("/listar")
    public List<Proyecto> listar(){
        return proyectoService.listar();
    }

    //BUSCAR POR ID
    @GetMapping("buscar/{id}")
    public Proyecto buscar(@PathVariable Long id){
        return proyectoService.encontrarPorid(id);
    }

    //ACTUALIZAR
    @PutMapping ("/actualizar/{id}")
    public Proyecto actualizar(@RequestBody Proyecto proyecto, @PathVariable Long id){
        return proyectoService.actualizar(id, proyecto);
    }


    // CREAR
    @PostMapping("/crear")
    public Proyecto guardar(@RequestBody Proyecto proyecto){
        return proyectoService.guardar(proyecto);
    }
    //BORRAR
    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id){
        proyectoService.eliminar(id);
    }
}
