package com.persona.persona.service;

import com.persona.persona.dto.DomicilioBasicDTO;
import com.persona.persona.dto.DomicilioDTO;


import java.util.List;

public interface DomicilioService {

    DomicilioDTO save(DomicilioDTO domicilioDTO);

    List<DomicilioDTO> getAllDomicilio();

    List<DomicilioBasicDTO> getBasicDomicilio();

    boolean delete(Long id);

    DomicilioDTO update(Long id,DomicilioDTO domicilioDTO);
}
