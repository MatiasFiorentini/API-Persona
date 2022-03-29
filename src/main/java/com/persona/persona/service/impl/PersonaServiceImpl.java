package com.persona.persona.service.impl;

import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
import com.persona.persona.dto.PersonaNombreDTO;
import com.persona.persona.entity.Persona;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.PersonaMapper;
import com.persona.persona.repository.IPersonaRepository;
import com.persona.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private IPersonaRepository IPersonaRespository;

    @Autowired
    private PersonaMapper personaMapper;


    @Override
    @Transactional
    public PersonaDTO save(PersonaDTO personaDTO) {
        Persona persona = personaMapper.personaDTO2Persona(personaDTO);
        Persona personaSaved = IPersonaRespository.save(persona);
        PersonaDTO result = personaMapper.persona2DTO(personaSaved);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaDTO> getAllPersona() {
        List<Persona> personaList = IPersonaRespository.findAll();
        List<PersonaDTO> result = personaMapper.personaList2PersonaDTOList(personaList);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (IPersonaRespository.existsById(id)){
            IPersonaRespository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public PersonaDTO update(Long id, PersonaDTO personaDTO) {
        Optional<Persona> respuesta = IPersonaRespository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de persona no válido");
        }
        personaMapper.personaRefreshValues(respuesta.get(),personaDTO);
        Persona personaSaved = IPersonaRespository.save(respuesta.get());
        PersonaDTO result = personaMapper.persona2DTO(personaSaved);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaBasicDTO> getBasicPersona() {
        List<Persona> personaList = IPersonaRespository.findAll();
        List<PersonaBasicDTO> result = personaMapper.personaList2BasicDTOList(personaList);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaNombreDTO> search(String nombre) {
        List<Persona> personaList = IPersonaRespository.search(nombre);
        List<PersonaNombreDTO> result = personaMapper.personaList2NombreDTOList(personaList);
        return result;
    }

    @Override
    public List<PersonaNombreDTO> search2(String nombre) {
        List<Persona> personaList = IPersonaRespository.findByNombre(nombre);
        List<PersonaNombreDTO> result = personaMapper.personaList2NombreDTOList(personaList);
        return result;
    }
}
