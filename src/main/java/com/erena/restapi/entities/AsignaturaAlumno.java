package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asignatura_alumno")
@AssociationOverrides({
        @AssociationOverride(name = "id.alumno",
                joinColumns = @JoinColumn(name = "id_alumno")),
        @AssociationOverride(name = "id.asignatura",
                joinColumns = @JoinColumn(name = "id_asignatura")) })
public class AsignaturaAlumno {
    @EmbeddedId private AsignaturaAlumnoID id;

    public AsignaturaAlumno() {
    }

    public AsignaturaAlumno(AsignaturaAlumnoID id) {
        this.id = id;
    }
}
