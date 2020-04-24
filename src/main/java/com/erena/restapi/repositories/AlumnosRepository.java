package com.erena.restapi.repositories;

import com.erena.restapi.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnosRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByIdCursoOrderByIdPersona(Long idCurso);
}
