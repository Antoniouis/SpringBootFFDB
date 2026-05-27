package Proyecto_Intermodular_BDD.Repositorios;

import Proyecto_Intermodular_BDD.Dominos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
