package com.persona.persona.service.impl;

import com.persona.persona.dto.AutorBasicDTO;
import com.persona.persona.dto.AutorDTO;
import com.persona.persona.entity.Autor;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.AutorMapper;
import com.persona.persona.repository.AutorRepository;
import com.persona.persona.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    AutorMapper autorMapper;

    @Override
    @Transactional
    public AutorDTO save(AutorDTO autorDTO){
        Autor autor = autorMapper.autorDTO2Autor(autorDTO);
        Autor autorSaved = autorRepository.save(autor);
        AutorDTO result = autorMapper.autor2DTO(autorSaved,false);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorDTO> getAllAutor(){
        List<Autor> autorList = autorRepository.findAll();
        List<AutorDTO> result = autorMapper.autorList2AutorDTOList(autorList,true);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id){
        if (autorRepository.existsById(id)){
            autorRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public AutorDTO update(Long id, AutorDTO autorDTO) {
        Optional<Autor> respuesta = autorRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de autor no válido");
        }
        autorMapper.autorRefreshValue(respuesta.get(),autorDTO);
        Autor autorSaved = autorRepository.save(respuesta.get());
        AutorDTO result = autorMapper.autor2DTO(autorSaved,false);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorBasicDTO> getBasicAutor(){
        List<Autor> autorList = autorRepository.findAll();
        List<AutorBasicDTO> result = autorMapper.autorList2BasicDTOList(autorList);
        return result;
    }
}
