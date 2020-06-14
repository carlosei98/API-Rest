package com.erena.restapi.controller;

import com.erena.restapi.entities.Alumno;
import com.erena.restapi.entities.Asignatura;
import com.erena.restapi.entities.AsignaturaAlumno;
import com.erena.restapi.entities.AsignaturaAlumnoID;
import com.erena.restapi.repositories.AlumnosRepository;
import com.erena.restapi.repositories.AsignaturaAlumnoRepository;
import com.erena.restapi.repositories.AsignaturasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AsignaturaController {
    private final AsignaturasRepository repository;
    private final AsignaturaAlumnoRepository asignaturaAlumnoRepository;
    private final AlumnosRepository alumnosRepository;

    public AsignaturaController(AsignaturasRepository repository, AsignaturaAlumnoRepository asignaturaAlumnoRepository, AlumnosRepository alumnosRepository) {
        this.repository = repository;
        this.asignaturaAlumnoRepository = asignaturaAlumnoRepository;
        this.alumnosRepository = alumnosRepository;
    }

    @GetMapping("/asignaturas/all")
    List<Asignatura> getAsignaturas() {
        return repository.findAll();
    }

    @PutMapping("/asignaturas/matricular/{id}")
    ResponseEntity<?> matricularAlumno(@PathVariable long id, @RequestBody List<Asignatura> asignaturas) {
        Alumno alumno = alumnosRepository.findById(id).get();
        for (Asignatura a : asignaturas) {
            asignaturaAlumnoRepository.save(new AsignaturaAlumno(new AsignaturaAlumnoID(alumno,a)));
        }
        return ResponseEntity.ok(200);
    }
}
