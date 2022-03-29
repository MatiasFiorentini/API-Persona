package com.persona.persona.dto;

import com.persona.persona.entity.Localidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {

    private Long id;
    private String calle;
    private int numero;
    private Localidad localidad;


}
