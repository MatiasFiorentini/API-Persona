package com.persona.persona.service;

import com.persona.persona.dto.LocalidadDTO;

import java.util.List;

public interface LocalidadService {

    LocalidadDTO save(LocalidadDTO localidadDTO);

    List<LocalidadDTO> getAllLocalidad();

    boolean delete(Long id);

    LocalidadDTO update(Long id, LocalidadDTO localidadDTO);
}
