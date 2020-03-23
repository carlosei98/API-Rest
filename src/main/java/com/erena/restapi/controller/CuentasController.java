package com.erena.restapi.controller;

import com.erena.restapi.entities.Cuentas;
import com.erena.restapi.repositories.CuentasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentasController {
    private final CuentasRepository repository;

    public CuentasController(CuentasRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cuentas")
    public List<Cuentas> all() {
        return repository.findAll();
    }


    @PostMapping("/cuentas")
    public Cuentas newCuenta(@RequestBody Cuentas newCuenta) {
        return repository.save(newCuenta);
    }

    @GetMapping("/cuentas/{id}")
    Cuentas one(@PathVariable Long id) throws CuentaNotFoundException {
        return repository.findById(id).orElseThrow(() -> new CuentaNotFoundException(id));
    }

    @PutMapping("Cuentas/{id}")
    public Cuentas replaceCuenta(@RequestBody Cuentas newCuenta, @PathVariable Long id) {
        return repository.findById(id)
                .map(cuentas -> {
                    cuentas.setUsuario(newCuenta.getUsuario());
                    cuentas.setContraseña(newCuenta.getContraseña());
                    return repository.save(cuentas);
                })
                .orElseGet(() -> {
                    newCuenta.setId(id);
                    return repository.save(newCuenta);
                });
    }
}

class CuentaNotFoundException extends RuntimeException {
    public CuentaNotFoundException(Long id) {
        super("No existe la cuenta: " + id);
    }
}

@ControllerAdvice
class CuentaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CuentaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String cuentaNotFoundHandler(CuentaNotFoundException e) {
        return e.getMessage();
    }
}