package com.erena.restapi.controller;

import com.erena.restapi.entities.Alumno;
import com.erena.restapi.entities.Asistencia;
import com.erena.restapi.entities.Persona;
import com.erena.restapi.repositories.AlumnosRepository;
import com.erena.restapi.repositories.PersonasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
public class AlumnosController {
    private final AlumnosRepository repository;
    private final PersonasRepository personasRepository;
    public AlumnosController(AlumnosRepository repository, PersonasRepository personasRepository) {
        this.repository = repository;
        this.personasRepository = personasRepository;
    }

    @GetMapping("/alumnos/all")
    List<Alumno> getAll() {
        return repository.findAll();
    }

    @PostMapping("/alumnos/getID/{nombre}&{apellidos}")
    Long getIDOne(@PathVariable String nombre, @PathVariable String apellidos) {
        return repository.findAlumnoByPersona(nombre, apellidos);
    }


    @PostMapping("/alumnos/{dia}&{hora}")
    List<Persona> getByDiaAndHora(@PathVariable String dia, @PathVariable String hora) {
        List<Long> alumnosID = repository.findAllById_DiaAndId_Hora(dia,hora);
        List<Persona> personaList = new ArrayList<>();
        for (Long id : alumnosID) {
            personaList.add(personasRepository.findById(id).get());
        }
        return personaList;
    }


}
