package com.persona.persona.dto;

import com.persona.persona.entity.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Domicilio domicilio;
    private List<LibroDTO> libros;
}
