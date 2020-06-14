package com.erena.restapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id ;
    @JsonFormat(pattern="MM/dd/yy")
    java.sql.Date dia;
    String hora, tipo;
    int justificada;
    @JoinColumn(name = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    Persona persona;
}
