package com.erena.restapi.repositories;

import com.erena.restapi.entities.Asistencia;
import com.erena.restapi.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface AsistenciasRepository extends JpaRepository<Asistencia,Long> {
    List<Asistencia> findAsistenciasByPersona(Persona p);

    @Query(value = "SELECT id_alumno FROM asignatura_alumno WHERE id_asignatura = (" +
            "SELECT id_asignatura FROM asignatura WHERE nombre = ?1) ", nativeQuery = true)
    List<Long> findAlumnosByAsignatura(String asignatura);


    List<Asistencia> findAsistenciasByDiaAndHora(Date dia, String hora);
}
