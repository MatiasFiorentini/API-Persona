package com.persona.persona.mapper;

import com.persona.persona.dto.AutorBasicDTO;
import com.persona.persona.dto.AutorDTO;
import com.persona.persona.entity.Autor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutorMapper {

    public Autor autorDTO2Autor(AutorDTO autorDTO){
        Autor autor = new Autor();
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        autor.setBiografia(autorDTO.getBiografia());

        return autor;
    }

    public AutorDTO autor2DTO(Autor autor){
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNombre(autor.getNombre());
        dto.setApellido(autor.getApellido());
        dto.setBiografia(autor.getBiografia());

        return dto;
    }

    public List<AutorDTO> autorList2AutorDTOList(List<Autor> autorList){
        List<AutorDTO> dto = new ArrayList<>();
        for (Autor autor: autorList){
            dto.add(autor2DTO(autor));
        }
        return dto;
    }

    public void autorRefreshValue(Autor autor, AutorDTO autorDTO){
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        autor.setBiografia(autorDTO.getBiografia());
    }

    public List<AutorBasicDTO> autorList2BasicDTOList(List<Autor> autorList){
        List<AutorBasicDTO> dtos = new ArrayList<>();
        AutorBasicDTO basicDTO;
        for (Autor autor: autorList){
            basicDTO = new AutorBasicDTO();
            basicDTO.setId(autor.getId());
            basicDTO.setNombre(autor.getNombre());
            basicDTO.setApellido(autor.getApellido());
            basicDTO.setBiografia(autor.getBiografia());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}
