package com.erena.restapi.repositories;

import com.erena.restapi.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlumnosRepository extends JpaRepository<Alumno, Long> {
    @Query(value = "SELECT id_alumno FROM asignatura_alumno WHERE id_asignatura = ( " +
            "SELECT id_asignatura FROM profesor_asignatura WHERE dia = ?1 AND hora = ?2)" , nativeQuery = true)
    List<Long> findAllById_DiaAndId_Hora(String dia, String hora);

    @Query(value = "SELECT id_persona from Alumno WHERE id_persona = (" +
            "SELECT id from Persona WHERE nombre = ?1 and apellidos = ?2)", nativeQuery = true)
    Long findAlumnoByPersona(String nombre, String apellidos);
}
