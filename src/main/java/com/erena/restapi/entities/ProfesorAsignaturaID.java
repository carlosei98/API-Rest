package com.erena.restapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfesorAsignaturaID implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY) @MapsId("id_profesor") private Profesor profesor;
    @ManyToOne(fetch = FetchType.LAZY) @MapsId("id_asignatura") private Asignatura asignatura;
    @Column(name = "dia")
    private String dia;
    @Column(name = "hora")
    private String hora;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorAsignaturaID that = (ProfesorAsignaturaID) o;
        return Objects.equals(profesor, that.profesor) &&
                Objects.equals(asignatura, that.asignatura) &&
                Objects.equals(dia, that.dia) &&
                Objects.equals(hora, that.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profesor, asignatura, dia, hora);
    }
}
