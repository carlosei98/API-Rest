package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id long id_persona;
    @OneToOne @JoinColumn(name = "id_persona") Persona persona;
    @OneToMany(mappedBy = "id.profesor")
    private List<ProfesorAsignatura> profesorAsignaturas;

}
