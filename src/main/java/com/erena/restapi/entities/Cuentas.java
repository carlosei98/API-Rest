package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Cuentas {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String usuario;
    private String contraseña;

    public Cuentas(){};

    public Cuentas(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
}