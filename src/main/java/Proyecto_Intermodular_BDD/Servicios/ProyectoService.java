package Proyecto_Intermodular_BDD.Servicios;

import Proyecto_Intermodular_BDD.Dominos.Cliente;
import Proyecto_Intermodular_BDD.Dominos.Proyecto;
import Proyecto_Intermodular_BDD.Repositorios.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    //LISTAR
    public List<Proyecto> listar( ) {
        return proyectoRepository.findAll();
    }

    //LISTAR POR ID
    public Proyecto encontrarPorid( Long id ) {
        return proyectoRepository.findById(id).orElse(null);
    }

    //CREAR
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // ACTUALIZAR
    public Proyecto actualizar(Long id, Proyecto proyectoActualizar) {

        Proyecto proyectoAntiguo = proyectoRepository.findById(id).orElse(null);

        if (proyectoAntiguo != null) {


            if (proyectoActualizar.getNombre() != null) {
                proyectoAntiguo.setNombre(proyectoActualizar.getNombre());
            }


            if (proyectoActualizar.getEstado() != null) {
                proyectoAntiguo.setEstado(proyectoActualizar.getEstado());
            }


            if (proyectoActualizar.getCliente() != null) {
                proyectoAntiguo.setCliente(proyectoActualizar.getCliente());
            }

            // 2. Guardamos los cambios en la base de datos
            return proyectoRepository.save(proyectoAntiguo);
        }

        return null;
    }

    //BORRAR
    public void eliminar(Long id) {
        proyectoRepository.deleteById(id);
    }





}
