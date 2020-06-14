package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "profesor_asignatura")
@AssociationOverrides({
        @AssociationOverride(name = "id.profesor",
                joinColumns = @JoinColumn(name = "id_profesor")),
        @AssociationOverride(name = "id.asignatura",
                joinColumns = @JoinColumn(name = "id_asignatura")) })
public class ProfesorAsignatura {
    @EmbeddedId private ProfesorAsignaturaID id;
}

