package com.persona.persona.service.impl;

import com.persona.persona.dto.DomicilioBasicDTO;
import com.persona.persona.dto.DomicilioDTO;
import com.persona.persona.entity.Domicilio;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.DomicilioMapper;
import com.persona.persona.repository.DomicilioRepository;
import com.persona.persona.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private DomicilioMapper domicilioMapper;


    @Override
    @Transactional
    public DomicilioDTO save(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = domicilioMapper.domicilioDTO2Domicilio(domicilioDTO);
        Domicilio domicilioSaved = domicilioRepository.save(domicilio);
        DomicilioDTO result = domicilioMapper.domicilio2DTO(domicilioSaved);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DomicilioDTO> getAllDomicilio() {
        List<Domicilio> domicilioList = domicilioRepository.findAll();
        List<DomicilioDTO> result = domicilioMapper.domicilioList2DTOList(domicilioList);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (domicilioRepository.existsById(id)){
            domicilioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public DomicilioDTO update(Long id, DomicilioDTO domicilioDTO) {
        Optional<Domicilio> respuesta = domicilioRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de domicilio no válido");
        }
        domicilioMapper.domicilioRefreshValues(respuesta.get(),domicilioDTO);
        Domicilio domicilioSaved = domicilioRepository.save(respuesta.get());
        DomicilioDTO result = domicilioMapper.domicilio2DTO(domicilioSaved);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DomicilioBasicDTO> getBasicDomicilio() {
        List<Domicilio> domicilioList = domicilioRepository.findAll();
        List<DomicilioBasicDTO> result = domicilioMapper.domicilioList2BasicDTOList(domicilioList);
        return result;
    }
}
