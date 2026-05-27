package Proyecto_Intermodular_BDD.Controladores;

import Proyecto_Intermodular_BDD.Dominos.Cliente;
import Proyecto_Intermodular_BDD.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empresa/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //CREAR
    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente ){
        System.out.println("EL ADMIN CREO UN NUEVO CLIENTE");
        return clienteService.guardar(cliente);
    }

    //LEER
    @GetMapping("/listar")
    public List<Cliente> listar(){
        System.out.println("EL ADMIN LISTO TODOS LOS CLIENTES");
        return clienteService.obtenerTodos();

    }
    //LEER POR ID
    @GetMapping("/buscar/{id}")
    public Cliente bucarPorID(@PathVariable Long id){
        System.out.println("EL ADMIN LISTO EL CLIENTE CON EL ID : " + id);
        return clienteService.encontrarPorId(id);
    }

    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public Cliente actualizar(@PathVariable Long id,@RequestBody Cliente cliente){
        System.out.println("EL ADMIN ACTUALIZO EL CLIENTE CON EL ID : " + id );
        return clienteService.actualizar(id,cliente);
    }

    //BORRAR
    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id){
        System.out.println("EL ADMIN ELIMINO EL CLIENTE CON EL ID : " + id );
        clienteService.borrar(id);
    }



}
