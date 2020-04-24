package com.erena.restapi.repositories;

import com.erena.restapi.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<Curso,Long> {}
