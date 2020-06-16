package com.erena.restapi.repositories;

import com.erena.restapi.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturasRepository extends JpaRepository<Asignatura, Long> {
}
