package Proyecto_Intermodular_BDD.Dominos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "tareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String estado;

    // Muchas tareas corresponden a un proyecto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id", nullable = false) // FK de Proyecto
    @JsonIgnoreProperties("tareas")
    private Proyecto proyecto;

    // Muchas tareas son realizadas por un empleado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id") // FK de Empleado
    @JsonIgnoreProperties("tareas")
    private Empleado empleado;

    
}