package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Persona {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String nombre;
    private String dni;

}
