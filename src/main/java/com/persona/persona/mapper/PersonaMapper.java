package com.persona.persona.mapper;

import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
import com.persona.persona.entity.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaMapper {

    public Persona personaDTO2Persona(PersonaDTO personaDTO){
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
        persona.setDomicilio(personaDTO.getDomicilio());

        return persona;
    }

    public PersonaDTO persona2DTO(Persona persona){
        PersonaDTO dto = new PersonaDTO();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setDni(persona.getDni());
        dto.setDomicilio(persona.getDomicilio());

        return dto;
    }

    public List<PersonaDTO> personaList2PersonaDTOList(List<Persona> personaList){
        List<PersonaDTO> dto = new ArrayList<>();
        for (Persona persona : personaList) {
            dto.add(persona2DTO(persona));
        }
        return dto;
    }

    public void personaRefreshValues(Persona persona,PersonaDTO personaDTO){
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
    }

    public List<PersonaBasicDTO> personaList2BasicDTOList(List<Persona> personaList){
        List<PersonaBasicDTO> dtos = new ArrayList<>();
        PersonaBasicDTO basicDTO;
        for (Persona persona : personaList) {
            basicDTO = new PersonaBasicDTO();
            basicDTO.setId(persona.getId());
            basicDTO.setNombre(persona.getNombre());
            basicDTO.setApellido(persona.getApellido());
            basicDTO.setDni(persona.getDni());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}
