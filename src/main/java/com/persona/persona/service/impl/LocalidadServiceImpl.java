package com.persona.persona.service.impl;

import com.persona.persona.dto.LocalidadDTO;
import com.persona.persona.entity.Localidad;
import com.persona.persona.exception.ParamNotFound;
import com.persona.persona.mapper.LocalidadMapper;
import com.persona.persona.repository.ILocalidadRepository;
import com.persona.persona.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadServiceImpl implements LocalidadService {

    @Autowired
    private LocalidadMapper localidadMapper;
    @Autowired
    private ILocalidadRepository ILocalidadRepository;


    @Override
    @Transactional
    public LocalidadDTO save(LocalidadDTO localidadDTO) {
        Localidad localidad = localidadMapper.localidadDTO2Localidad(localidadDTO);
        Localidad localidadSaved = ILocalidadRepository.save(localidad);
        LocalidadDTO result = localidadMapper.localidad2DTO(localidadSaved);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocalidadDTO> getAllLocalidad() {
        List<Localidad> localidadList = ILocalidadRepository.findAll();
        List<LocalidadDTO> result = localidadMapper.localidadList2DTOList(localidadList);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (ILocalidadRepository.existsById(id)){
            ILocalidadRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public LocalidadDTO update(Long id, LocalidadDTO localidadDTO) {
        Optional<Localidad> respuesta = ILocalidadRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de localidad no válido");
        }
        localidadMapper.localidadRefreshValue(respuesta.get(),localidadDTO);
        Localidad localidadSaved = ILocalidadRepository.save(respuesta.get());
        LocalidadDTO result = localidadMapper.localidad2DTO(localidadSaved);
        return result;
    }
}
