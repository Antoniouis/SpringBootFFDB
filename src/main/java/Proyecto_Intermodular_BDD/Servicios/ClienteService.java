package Proyecto_Intermodular_BDD.Servicios;

import Proyecto_Intermodular_BDD.Dominos.Cliente;
import Proyecto_Intermodular_BDD.Repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos(){
        return clienteRepository.findAll();
    }

    public Cliente encontrarPorId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente_actualizar){
        Cliente clienteAntiguo = clienteRepository.findById(id).orElse(null);
        if(clienteAntiguo != null){
            if(cliente_actualizar.getNombre() != null){
                clienteAntiguo.setNombre(cliente_actualizar.getNombre());
            }
            if (cliente_actualizar.getEmail() != null) {
                clienteAntiguo.setEmail(cliente_actualizar.getEmail());
            }
            return clienteRepository.save(clienteAntiguo);
        }
        return null;
    }

    public void borrar(Long id){
        clienteRepository.deleteById(id);
    }
}