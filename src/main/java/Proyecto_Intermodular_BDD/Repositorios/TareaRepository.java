package Proyecto_Intermodular_BDD.Repositorios;

import Proyecto_Intermodular_BDD.Dominos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
