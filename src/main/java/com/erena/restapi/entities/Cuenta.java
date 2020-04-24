package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cuenta {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String usuario;
    private String contraseña;
    private long idProfesor;

    public Cuenta(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
}
