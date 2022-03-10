package com.persona.persona.repository;

import com.persona.persona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRespository extends JpaRepository<Persona,Long> {

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:nombre%")
    public List<Persona> search(@Param("nombre") String nombre);
}
