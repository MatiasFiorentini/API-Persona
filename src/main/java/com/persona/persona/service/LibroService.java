package com.persona.persona.service;

import com.persona.persona.dto.LibroBasicDTO;
import com.persona.persona.dto.LibroDTO;

import java.util.List;

public interface LibroService {

    LibroDTO save(LibroDTO libroDTO);

    List<LibroDTO> getAllLibro();

    List<LibroBasicDTO> getBasicLibro();

    boolean delete(Long id);

    LibroDTO update(Long id, LibroDTO libroDTO);
}
