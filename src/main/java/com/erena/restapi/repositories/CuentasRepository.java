package com.erena.restapi.repositories;

import com.erena.restapi.entities.Cuentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasRepository  extends JpaRepository <Cuentas,Long> {
    Cuentas findByUsuarioAndContraseña(String usuario, String contraseña);
}
