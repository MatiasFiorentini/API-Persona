package com.persona.persona.service.impl;

import com.persona.persona.dto.LibroBasicDTO;
import com.persona.persona.dto.LibroDTO;
import com.persona.persona.entity.Libro;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.LibroMapper;
import com.persona.persona.repository.LibroRepository;
import com.persona.persona.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    LibroMapper libroMapper;


    @Override
    @Transactional
    public LibroDTO save(LibroDTO libroDTO) {
        Libro libro = libroMapper.libroDTO2Libro(libroDTO);
        Libro libroSaved = libroRepository.save(libro);
        LibroDTO result = libroMapper.libro2DTO(libroSaved,true);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroDTO> getAllLibro() {
        List<Libro> libroList = libroRepository.findAll();
        List<LibroDTO> result = libroMapper.libroList2LibroDTOList(libroList,true);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (libroRepository.existsById(id)){
            libroRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public LibroDTO update(Long id, LibroDTO libroDTO) {
        Optional<Libro> respuesta = libroRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de libro no válido");
        }
        libroMapper.libroRefreshValue(respuesta.get(),libroDTO);
        Libro libroSaved = libroRepository.save(respuesta.get());
        LibroDTO result = libroMapper.libro2DTO(libroSaved,false);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroBasicDTO> getBasicLibro() {
        List<Libro> libroList = libroRepository.findAll();
        List<LibroBasicDTO> result = libroMapper.libroList2BasicDTOList(libroList);
        return result;
    }
}
