package com.persona.persona.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutorDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String biografia;
    private List<LibroDTO> libros;
}
