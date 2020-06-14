package com.erena.restapi.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id long id_persona;
    @OneToOne @JoinColumn(name = "id_persona") Persona persona;

    @ManyToMany @JoinTable(
            name = "asignatura_alumno",
            joinColumns = {@JoinColumn(name = "id_asignatura")},
            inverseJoinColumns = {@JoinColumn(name = "id_alumno")}
    )
    Set<Asignatura> asignaturas = new HashSet<>();
}
