package com.erena.restapi.repositories;

import com.erena.restapi.entities.Alumno;
import com.erena.restapi.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesoresRepository extends JpaRepository<Profesor,Long> {}
