package com.persona.persona.service.impl;

import com.persona.persona.dto.AutorBasicDTO;
import com.persona.persona.dto.AutorDTO;
import com.persona.persona.entity.Autor;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.AutorMapper;
import com.persona.persona.repository.IAutorRepository;
import com.persona.persona.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    IAutorRepository IAutorRepository;

    @Autowired
    AutorMapper autorMapper;

    @Override
    @Transactional
    public AutorDTO save(AutorDTO autorDTO){
        Autor autor = autorMapper.autorDTO2Autor(autorDTO);
        Autor autorSaved = IAutorRepository.save(autor);
        AutorDTO result = autorMapper.autor2DTO(autorSaved,false);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorDTO> getAllAutor(){
        List<Autor> autorList = IAutorRepository.findAll();
        List<AutorDTO> result = autorMapper.autorList2AutorDTOList(autorList,true);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id){
        if (IAutorRepository.existsById(id)){
            IAutorRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public AutorDTO update(Long id, AutorDTO autorDTO) {
        Optional<Autor> respuesta = IAutorRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de autor no válido");
        }
        autorMapper.autorRefreshValue(respuesta.get(),autorDTO);
        Autor autorSaved = IAutorRepository.save(respuesta.get());
        AutorDTO result = autorMapper.autor2DTO(autorSaved,false);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorBasicDTO> getBasicAutor(){
        List<Autor> autorList = IAutorRepository.findAll();
        List<AutorBasicDTO> result = autorMapper.autorList2BasicDTOList(autorList);
        return result;
    }
}
