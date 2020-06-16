package com.erena.restapi.controller;

import com.erena.restapi.entities.Persona;
import com.erena.restapi.repositories.AlumnosRepository;
import com.erena.restapi.repositories.PersonasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class PersonaController {
    private final PersonasRepository repository;

    public PersonaController(PersonasRepository repository, AlumnosRepository alumnosRepository) {
        this.repository = repository;
    }


    @PostMapping("/logueo/{usuario}&{contraseña}")
    Persona findByUsuarioAndContraseña(@PathVariable String usuario, @PathVariable String contraseña) {
        return repository.findByUsuarioAndContraseña(usuario, contraseña);
    }

    //Create
    @PutMapping(value = "/registro/")
    Persona insertarPersona(@RequestBody Persona persona) {
        return repository.save(persona);
    }

    //Read
    @GetMapping("/personas/listPersonas")
    List<Persona> all() {
        return repository.findAll();
    }

    //Update
    @PutMapping(value = "/persona/modificar/{id}")
    Persona modificarPersona(@PathVariable long id, @RequestBody Persona persona) {
        Persona p = repository.findById(id).orElseThrow(() -> new PersonaNotFoundException(id));
        p.setApellidos(persona.getApellidos());
        p.setCalle(persona.getCalle());
        p.setContraseña(persona.getContraseña());
        p.setDni(persona.getDni());
        p.setLocalidad(persona.getLocalidad());
        p.setNombre(persona.getNombre());
        p.setRol(persona.getRol());
        p.setUsuario(persona.getUsuario());

        return repository.save(p);
    }


    //Delete
    @DeleteMapping(value = "/persona/borrar/{id}")
    ResponseEntity<?> borrarPersona(@PathVariable long id) {
        Persona p = repository.findById(id).orElseThrow(() -> new PersonaNotFoundException(id));
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    /*
    Esta clase embebida es una clase excepción para crear una excepción personalizada cuando la persona no se encuentre;
    @param id es el ID de la persona de la cual se va a consultar los datos.
     */
    private class PersonaNotFoundException extends RuntimeException {
        public PersonaNotFoundException(Long id) {
            super("No existe la persona con ID " + id);
        }
    }

    /*
    Esta clase embebida es la clase que consume la excepción y la lanza.
     */
    @ControllerAdvice
    class PersonaNotFoundAdvice {

        @ResponseBody
        @ExceptionHandler(PersonaNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String PersonaNotFoundController(PersonaNotFoundException e) {
            return e.getMessage();
        }
    }
}
