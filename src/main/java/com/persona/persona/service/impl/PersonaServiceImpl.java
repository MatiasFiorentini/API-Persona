package com.persona.persona.service.impl;

import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
import com.persona.persona.entity.Persona;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.PersonaMapper;
import com.persona.persona.repository.PersonaRespository;
import com.persona.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRespository personaRespository;

    @Autowired
    private PersonaMapper personaMapper;


    @Override
    public PersonaDTO save(PersonaDTO personaDTO) {
        Persona persona = personaMapper.personaDTO2Persona(personaDTO);
        Persona personaSaved = personaRespository.save(persona);
        PersonaDTO result = personaMapper.persona2DTO(personaSaved);
        return result;
    }

    @Override
    public List<PersonaDTO> getAllPersona() {
        List<Persona> personaList = personaRespository.findAll();
        List<PersonaDTO> result = personaMapper.personaList2PersonaDTOList(personaList);
        return result;
    }

    @Override
    public boolean delete(Long id) {
        if (personaRespository.existsById(id)){
            personaRespository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public PersonaDTO update(Long id, PersonaDTO personaDTO) {
        Optional<Persona> respuesta = personaRespository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de persona no válido");
        }
        personaMapper.personaRefreshValues(respuesta.get(),personaDTO);
        Persona personaSaved = personaRespository.save(respuesta.get());
        PersonaDTO result = personaMapper.persona2DTO(personaSaved);
        return result;
    }

    @Override
    public List<PersonaBasicDTO> getBasicPersona() {
        List<Persona> personaList = personaRespository.findAll();
        List<PersonaBasicDTO> result = personaMapper.personaList2BasicDTOList(personaList);
        return result;
    }
}