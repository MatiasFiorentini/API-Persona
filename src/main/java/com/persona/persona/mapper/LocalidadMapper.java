package com.persona.persona.mapper;

import com.persona.persona.dto.LocalidadDTO;
import com.persona.persona.entity.Localidad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocalidadMapper {

    public Localidad localidadDTO2Localidad(LocalidadDTO localidadDTO){
        Localidad localidad = new Localidad();
        localidad.setDenominación(localidadDTO.getDenominacion());
        return localidad;
    }

    public LocalidadDTO localidad2DTO(Localidad localidad){
        LocalidadDTO dto = new LocalidadDTO();
        dto.setId(localidad.getId());
        dto.setDenominacion(localidad.getDenominación());
        return dto;
    }

    public List<LocalidadDTO> localidadList2DTOList(List<Localidad> localidadList){
        List<LocalidadDTO> dtos = new ArrayList<>();
        for (Localidad localidad : localidadList ) {
            dtos.add(localidad2DTO(localidad));
        }
        return dtos;
    }

    public void localidadRefreshValue(Localidad localidad, LocalidadDTO localidadDTO){
        localidad.setDenominación(localidadDTO.getDenominacion());
    }

    public List<Localidad> localidadDTOList2Localidad(List<LocalidadDTO> localidadDTO){
        List<Localidad> localidadList = new ArrayList<>();
        for (LocalidadDTO dto: localidadDTO) {
            localidadList.add(localidadDTO2Localidad(dto));
        }
        return localidadList;
    }
}
