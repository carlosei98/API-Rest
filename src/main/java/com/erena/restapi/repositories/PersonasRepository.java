package com.erena.restapi.repositories;

import com.erena.restapi.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonasRepository extends JpaRepository<Persona,Long> {
    Persona findByUsuarioAndContraseña(String usuario, String contraseña);
   }
