package com.erena.restapi.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Asistencia {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private java.sql.Date dia;
    private String hora;

}
