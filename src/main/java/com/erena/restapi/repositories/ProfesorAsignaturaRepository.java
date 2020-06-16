package com.erena.restapi.repositories;

import com.erena.restapi.entities.ProfesorAsignatura;
import com.erena.restapi.entities.ProfesorAsignaturaID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorAsignaturaRepository extends JpaRepository<ProfesorAsignatura, ProfesorAsignaturaID> {

}
