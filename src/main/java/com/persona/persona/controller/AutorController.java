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
        AutorDTO autorSaved = autorService.save(autorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AutorDTO>> getAll(){
        List<AutorDTO> autorList = autorService.getAllAutor();
        return ResponseEntity.ok().body(autorList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        autorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> update(@PathVariable Long id,@RequestBody AutorDTO autorDTO){
        AutorDTO autorUpdate = autorService.update(id,autorDTO);
        return ResponseEntity.ok().body(autorUpdate);
    }

    @GetMapping("/basic")
    public ResponseEntity<List<AutorBasicDTO>> getBasicAutor(){
        List<AutorBasicDTO> autorBasicDTO = autorService.getBasicAutor();
        return ResponseEntity.ok().body(autorBasicDTO);
    }

}
