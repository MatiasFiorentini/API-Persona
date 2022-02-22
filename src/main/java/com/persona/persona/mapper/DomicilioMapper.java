package com.persona.persona.mapper;

import com.persona.persona.dto.DomicilioBasicDTO;
import com.persona.persona.dto.DomicilioDTO;
import com.persona.persona.entity.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DomicilioMapper {

    @Autowired
    private LocalidadMapper localidadMapper;

    public Domicilio domicilioDTO2Domicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setNumero(domicilioDTO.getNumero());
        domicilio.setLocalidad(domicilioDTO.getLocalidad());
        return domicilio;
    }

    public DomicilioDTO domicilio2DTO(Domicilio domicilio){
        DomicilioDTO dto = new DomicilioDTO();
        dto.setId(domicilio.getId());
        dto.setCalle(domicilio.getCalle());
        dto.setNumero(domicilio.getNumero());
        dto.setLocalidad(domicilio.getLocalidad());
        return dto;
    }

    public List<DomicilioDTO> domicilioList2DTOList(List<Domicilio> domicilioList){
        List<DomicilioDTO> dtos = new ArrayList<>();
        for (Domicilio domicilio: domicilioList) {
            dtos.add(domicilio2DTO(domicilio));
        }
        return dtos;
    }

    public void domicilioRefreshValues(Domicilio domicilio,DomicilioDTO domicilioDTO){
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setNumero(domicilioDTO.getNumero());
    }

    //Basic Domicilio
    public List<DomicilioBasicDTO> domicilioList2BasicDTOList(List<Domicilio> domicilioList){
        List<DomicilioBasicDTO> dtos = new ArrayList<>();
        DomicilioBasicDTO basicDTO;
        for (Domicilio domicilio : domicilioList) {
            basicDTO = new DomicilioBasicDTO();
            basicDTO.setId(domicilio.getId());
            basicDTO.setCalle(domicilio.getCalle());
            basicDTO.setNumero(domicilio.getNumero());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}
