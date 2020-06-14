package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "persona")
public class Persona {
    @Id long id;
    String nombre, apellidos, dni, calle, localidad, usuario, contraseña, rol;
}
