package com.persona.persona.service;

import com.persona.persona.dto.AutorBasicDTO;
import com.persona.persona.dto.AutorDTO;

import java.util.List;

public interface AutorService {

    AutorDTO save(AutorDTO autorDTO);

    List<AutorDTO> getAllAutor();

    List<AutorBasicDTO> getBasicAutor();

    boolean delete(Long id);

    AutorDTO update(Long id, AutorDTO autorDTO);
}
