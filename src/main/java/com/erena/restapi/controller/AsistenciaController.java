package com.erena.restapi.controller;

import com.erena.restapi.entities.Asistencia;
import com.erena.restapi.entities.Persona;
import com.erena.restapi.repositories.AsistenciasRepository;
import com.erena.restapi.repositories.PersonasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AsistenciaController {
    private AsistenciasRepository asistenciasRepository;
    private PersonasRepository personasRepository;

    public AsistenciaController(AsistenciasRepository repository, PersonasRepository personasRepository) {
        this.asistenciasRepository = repository;
        this.personasRepository = personasRepository;
    }

    @PostMapping(value ="/asistencia/listar")
    List<Asistencia> listarAsistencias(@RequestBody Persona p) {
        return asistenciasRepository.findAsistenciasByPersona(p);
    }

    @PutMapping(value = "/asistencia/guardar")
    ResponseEntity<?> guardarAsistencias(@RequestBody List<Asistencia> asistenciaList) {
        asistenciasRepository.saveAll(asistenciaList);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/asitencia/listar/{asignatura}")
    List<Asistencia> listarAsistenciasAsignatura(@PathVariable String asignatura) {
        List<Long> ids = asistenciasRepository.findAlumnosByAsignatura(asignatura);
        List<Asistencia> asistencias = new ArrayList<>();
        for (Long id: ids) {
            Persona p = personasRepository.findById(id).get();
            List<Asistencia> asistenciaList = asistenciasRepository.findAsistenciasByPersona(p);
            for (Asistencia a : asistenciaList) {
                asistencias.add(a);
            }
        }
        return asistencias;
    }

    @PostMapping("/asistencia/listar/{dia}&{hora}")
    List<Asistencia> getByDiaAndHora(@PathVariable Date dia, @PathVariable String hora) {
        return asistenciasRepository.findAsistenciasByDiaAndHora(dia, hora);
    }
}
