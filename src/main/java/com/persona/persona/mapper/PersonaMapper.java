package com.persona.persona.mapper;

import com.persona.persona.dto.LibroDTO;
import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
import com.persona.persona.dto.PersonaNombreDTO;
import com.persona.persona.entity.Libro;
import com.persona.persona.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaMapper {

    @Autowired
    LibroMapper libroMapper;

    public Persona personaDTO2Persona(PersonaDTO personaDTO){
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
        persona.setDomicilio(personaDTO.getDomicilio());

        List<Libro> libroList = libroMapper.libroDTOList2LibroList(personaDTO.getLibros());
        persona.setLibros(libroList);

        return persona;
    }

    public PersonaDTO persona2DTO(Persona persona){
        PersonaDTO dto = new PersonaDTO();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setDni(persona.getDni());
        dto.setDomicilio(persona.getDomicilio());

        List<LibroDTO> libroDTO = libroMapper.libroList2LibroDTOList(persona.getLibros(),true);
        dto.setLibros(libroDTO);

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

    public List<PersonaNombreDTO> personaList2NombreDTOList(List<Persona> personaList){
        List<PersonaNombreDTO> dtos = new ArrayList<>();
        PersonaNombreDTO nombreDTO;
        for (Persona persona: personaList) {
            nombreDTO = new PersonaNombreDTO();
            nombreDTO.setId(persona.getId());
            nombreDTO.setNombre(persona.getNombre());
            dtos.add(nombreDTO);
        }
        return dtos;
    }
}
