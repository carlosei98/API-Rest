package com.erena.restapi.repositories;

import com.erena.restapi.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CuentasRepository  extends JpaRepository <Cuenta,Long> {
    Cuenta findByUsuarioAndContraseña(String usuario, String contraseña);
}
