package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@IdClass(ImparteClaseId.class)
public class ImparteClase implements Serializable {

    public @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProfesor;
    public @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCurso;

}

class ImparteClaseId implements Serializable {

    private String idProfesor;
    private String idCurso;

    public ImparteClaseId() {
    }

    public ImparteClaseId(String idProfesor, String idCurso) {
        this.idProfesor = idProfesor;
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImparteClaseId that = (ImparteClaseId) o;
        return Objects.equals(idProfesor, that.idProfesor) &&
                Objects.equals(idCurso, that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesor, idCurso);
    }
}
