package com.persona.persona.mapper;

import com.persona.persona.dto.LibroBasicDTO;
import com.persona.persona.dto.LibroDTO;
import com.persona.persona.entity.Libro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LibroMapper {

    public Libro libroDTO2Libro(LibroDTO libroDTO){
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setFecha(libroDTO.getFecha());
        libro.setGenero(libroDTO.getGenero());
        libro.setNumPaginas(libroDTO.getNumPaginas());

        return libro;
    }

    public LibroDTO libro2DTO(Libro libro){
        LibroDTO dto = new LibroDTO();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setFecha(libro.getFecha());
        dto.setGenero(libro.getGenero());
        dto.setNumPaginas(libro.getNumPaginas());

        return dto;
    }

    public List<LibroDTO> libroList2LibroDTOList(List<Libro> libroList){
        List<LibroDTO> dto = new ArrayList<>();
        for (Libro libro : libroList) {
            dto.add(libro2DTO(libro));
        }
        return dto;
    }

    public void libroRefreshValue(Libro libro, LibroDTO libroDTO){
        libro.setTitulo(libroDTO.getTitulo());
        libro.setFecha(libroDTO.getFecha());
        libro.setGenero(libroDTO.getGenero());
        libro.setNumPaginas(libroDTO.getNumPaginas());
    }

    public List<LibroBasicDTO> libroList2BasicDTOList(List<Libro> libroList){
        List<LibroBasicDTO> dtos = new ArrayList<>();
        LibroBasicDTO basicDTO;
        for (Libro libro: libroList) {
            basicDTO = new LibroBasicDTO();
            basicDTO.setId(libro.getId());
            basicDTO.setTitulo(libro.getTitulo());
            basicDTO.setFecha(libro.getFecha());
            basicDTO.setGenero(libro.getGenero());
            basicDTO.setNumPaginas(libro.getNumPaginas());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}
