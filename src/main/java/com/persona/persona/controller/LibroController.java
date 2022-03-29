package com.persona.persona.controller;

import com.persona.persona.dto.LibroBasicDTO;
import com.persona.persona.dto.LibroDTO;
import com.persona.persona.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping
    public ResponseEntity<LibroDTO> save(@RequestBody LibroDTO libroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.save(libroDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LibroDTO>> getAll(){
        return ResponseEntity.ok().body(libroService.getAllLibro());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        libroService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> update(@PathVariable Long id,@RequestBody LibroDTO libroDTO){
        return ResponseEntity.ok().body(libroService.update(id,libroDTO));
    }

    @GetMapping("/basic")
    public ResponseEntity<List<LibroBasicDTO>> getBasicLibro(){
        return ResponseEntity.ok().body(libroService.getBasicLibro());
    }

}
