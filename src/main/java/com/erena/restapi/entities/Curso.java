package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Curso {
    @Id long id;
    String nombre;
}
