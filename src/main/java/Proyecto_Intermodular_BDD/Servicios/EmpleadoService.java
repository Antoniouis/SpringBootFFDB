package Proyecto_Intermodular_BDD.Servicios;

import java.util.List;
import java.util.Optional;

import Proyecto_Intermodular_BDD.Dominos.Empleado;
import Proyecto_Intermodular_BDD.Repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    //LISTAR
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    //BUSCAR POR ID
    public Empleado buscarPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    //GUADADAR
    public Empleado guardar (Empleado empleado) {
    return empleadoRepository.save(empleado);
    }

    //ACTUALIZAR
    public Empleado actualizar(Long id, Empleado empleadoActualizar) {
        Empleado empleadoViejo = empleadoRepository.findById(id).orElse(null);
        if (empleadoViejo != null) {
            if(empleadoActualizar.getNombre()!=null) {
                empleadoViejo.setNombre(empleadoActualizar.getNombre());
            }
            if (empleadoActualizar.getRol() != null) {
                empleadoViejo.setRol(empleadoActualizar.getRol());
            }

            return empleadoRepository.save(empleadoViejo);
        }


        return null;
    }
    //ELIMINAR
    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}
















