package com.persona.persona.service;

import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
import com.persona.persona.dto.PersonaNombreDTO;

import java.util.List;

public interface PersonaService {

    PersonaDTO save(PersonaDTO personaDTO);

    List<PersonaDTO> getAllPersona();

    List<PersonaBasicDTO> getBasicPersona();

    boolean delete(Long id);

    PersonaDTO update(Long id,PersonaDTO personaDTO);

    List<PersonaNombreDTO> search(String nombre);

    List<PersonaNombreDTO> search2(String nombre);

}
