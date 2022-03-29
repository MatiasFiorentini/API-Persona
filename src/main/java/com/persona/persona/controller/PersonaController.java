package com.persona.persona.controller;

import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
import com.persona.persona.dto.PersonaNombreDTO;
import com.persona.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaDTO> save(@RequestBody PersonaDTO personaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(personaDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonaDTO>> getAll(){
        return ResponseEntity.ok().body(personaService.getAllPersona());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePersona(@PathVariable Long id){
        personaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable Long id,@RequestBody PersonaDTO personaDTO){
        return ResponseEntity.ok().body(personaService.update(id,personaDTO));
    }

    @GetMapping("/basic")
    public ResponseEntity<List<PersonaBasicDTO>> getBasicPersona(){
        return ResponseEntity.ok().body(personaService.getBasicPersona());
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonaNombreDTO>> search(String nombre){
        return ResponseEntity.ok().body(personaService.search(nombre));
    }

    @GetMapping("/search2")
    public ResponseEntity<List<PersonaNombreDTO>> search2(String nombre){
        return ResponseEntity.ok().body(personaService.search(nombre));
    }

}
