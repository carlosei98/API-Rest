package com.erena.restapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "asignatura")
public class Asignatura {
    @Id private long id_asignatura;
    private String nombre;
    @JsonIgnore @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_curso") Curso curso;
    @JsonIgnore @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_profesor") Profesor profesor;


    @JsonIgnore @ManyToMany(mappedBy = "asignaturas")
    Set<Alumno> alumnos = new HashSet<>();

    @JsonIgnore @OneToMany(mappedBy = "id.asignatura")
    Set<ProfesorAsignatura> profesorAsignaturas = new HashSet<>();

}
