package com.persona.persona.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LibroBasicDTO {

    private Long id;
    private String titulo;
    private LocalDate fecha;
    private String genero;
    private int numPaginas;
}
