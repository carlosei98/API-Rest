package com.erena.restapi.repositories;

import com.erena.restapi.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonasRepository extends JpaRepository<Persona,Long> {}
