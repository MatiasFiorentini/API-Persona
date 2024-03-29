package com.persona.persona.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class LibroDTO {

    private Long id;
    private String titulo;
    private LocalDate fecha;
    private String genero;
    private int numPaginas;
    private List<AutorDTO> autores;
}
