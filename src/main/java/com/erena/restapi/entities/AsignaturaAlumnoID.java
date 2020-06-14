package com.erena.restapi.entities;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Objects;

@Embeddable
public class AsignaturaAlumnoID implements java.io.Serializable{
    @ManyToOne(fetch = FetchType.LAZY) @MapsId("id_persona") private Alumno alumno;
    @ManyToOne(fetch = FetchType.LAZY) @MapsId("id_asignatura") private Asignatura asignatura;

    public AsignaturaAlumnoID() {
    }

    public AsignaturaAlumnoID(Alumno alumno, Asignatura asignatura) {
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaAlumnoID that = (AsignaturaAlumnoID) o;
        return Objects.equals(alumno, that.alumno) &&
                Objects.equals(asignatura, that.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumno, asignatura);
    }
}
