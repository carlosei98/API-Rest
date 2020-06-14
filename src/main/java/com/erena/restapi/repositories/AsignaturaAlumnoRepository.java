package com.erena.restapi.repositories;

import com.erena.restapi.entities.AsignaturaAlumno;
import com.erena.restapi.entities.AsignaturaAlumnoID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaAlumnoRepository extends JpaRepository<AsignaturaAlumno, AsignaturaAlumnoID> {
}
