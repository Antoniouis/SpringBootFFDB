package Proyecto_Intermodular_BDD.Servicios;

import Proyecto_Intermodular_BDD.Dominos.Tarea;
import Proyecto_Intermodular_BDD.Repositorios.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    //LISTAR
    public List<Tarea> listar(){
        return tareaRepository.findAll();
    }

    //LISTAR POR ID
    public Tarea listarPorId(Long id){
        return tareaRepository.findById(id).orElse(null);
    }

    //CREAR
    public Tarea crear(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    //ACTUALIZAR
    public Tarea actualizar(Long id , Tarea tareaActualizar){
        Tarea tareaAntigua = tareaRepository.findById(id).orElse(null);
         if(tareaAntigua != null){
             if(tareaActualizar.getEmpleado() != null){
                 tareaAntigua.setEmpleado(tareaActualizar.getEmpleado());
             }

             if (tareaActualizar.getEstado() != null){
                 tareaAntigua.setEstado(tareaActualizar.getEstado());
             }

             if (tareaActualizar.getTitulo() != null){
                 tareaAntigua.setTitulo(tareaActualizar.getTitulo());
             }

             if (tareaActualizar.getProyecto() != null){
                 tareaAntigua.setProyecto(tareaActualizar.getProyecto());
             }

             return tareaRepository.save(tareaAntigua);
         }
         return null;
    }

    //ELIMINAR
    public void eliminar(Long id ){
        tareaRepository.deleteById(id);
    }
}
