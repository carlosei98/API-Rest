package com.erena.restapi.repositories;

import com.erena.restapi.entities.Alumno;
import com.erena.restapi.entities.Asignatura;
import com.erena.restapi.entities.ProfesorAsignatura;
import com.erena.restapi.entities.ProfesorAsignaturaID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorAsignaturaRepository extends JpaRepository<ProfesorAsignatura, ProfesorAsignaturaID> {

}
