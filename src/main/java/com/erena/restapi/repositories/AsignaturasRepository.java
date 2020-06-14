package com.erena.restapi.repositories;

import com.erena.restapi.entities.Alumno;
import com.erena.restapi.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AsignaturasRepository extends JpaRepository<Asignatura, Long> {
}
