package com.persona.persona.controller;

import com.persona.persona.dto.AutorBasicDTO;
import com.persona.persona.dto.AutorDTO;
import com.persona.persona.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorDTO> save(@RequestBody AutorDTO autorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.save(autorDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AutorDTO>> getAll(){
        return ResponseEntity.ok().body(autorService.getAllAutor());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        autorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> update(@PathVariable Long id,@RequestBody AutorDTO autorDTO){
        return ResponseEntity.ok().body(autorService.update(id,autorDTO));
    }

    @GetMapping("/basic")
    public ResponseEntity<List<AutorBasicDTO>> getBasicAutor(){
        return ResponseEntity.ok().body(autorService.getBasicAutor());
    }

}
