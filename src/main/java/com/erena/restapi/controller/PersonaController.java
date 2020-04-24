package com.erena.restapi.controller;

import com.erena.restapi.entities.Alumno;
import com.erena.restapi.entities.Persona;
import com.erena.restapi.repositories.AlumnosRepository;
import com.erena.restapi.repositories.PersonasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonaController {
    private final PersonasRepository repository;
    private final AlumnosRepository alumnosRepository;

    public PersonaController(PersonasRepository repository, AlumnosRepository alumnosRepository) {
        this.repository = repository;
        this.alumnosRepository = alumnosRepository;
    }

    @CrossOrigin
    @GetMapping("/personas/listPersonas")
    List<Persona> all() {
        return repository.findAll();
    }

    @CrossOrigin
    @GetMapping("/personas/findPersonaByID/{id}")
    Persona one(@PathVariable Long id) throws PersonaNotFoundException {
        return repository.findById(id).orElseThrow(() -> new PersonaNotFoundException(id));
    }

    @CrossOrigin
    @GetMapping("/alumnos/findAlumnoByCurso/{idCurso}")
    Map<String,Alumno> listAlumnoByCurso(@PathVariable Long idCurso) {
        List<Alumno> listaAlumnos = alumnosRepository.findByIdCursoOrderByIdPersona(idCurso);
        Map<String,Alumno> mapAlumnos = new HashMap<>();
        for (Alumno alumno: listaAlumnos) {
            mapAlumnos.put(repository.findById(alumno.getId()).get().getNombre(),alumno);
        }
        return mapAlumnos;
    }

    private class PersonaNotFoundException extends RuntimeException {
        public PersonaNotFoundException(Long id) {
            super("No existe la persona con ID " + id);
        }
    }

    @ControllerAdvice
    class PersonaNotFoundAdvice {

        @ResponseBody
        @ExceptionHandler(PersonaController.PersonaNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String PersonaNotFoundController(PersonaController.PersonaNotFoundException e) {
            return e.getMessage();
        }
    }
}
