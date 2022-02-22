package com.persona.persona.controller;

import com.persona.persona.dto.PersonaBasicDTO;
import com.persona.persona.dto.PersonaDTO;
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
        PersonaDTO personaSaved = personaService.save(personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonaDTO>> getAll(){
        List<PersonaDTO> personaList = personaService.getAllPersona();
        return ResponseEntity.ok().body(personaList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePersona(@PathVariable Long id){
        personaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable Long id,@RequestBody PersonaDTO personaDTO){
        PersonaDTO personaUpdate = personaService.update(id,personaDTO);
        return ResponseEntity.ok().body(personaUpdate);
    }

    @GetMapping("/basic")
    public ResponseEntity<List<PersonaBasicDTO>> getBasicPersona(){
        List<PersonaBasicDTO> personaBasicDTO = personaService.getBasicPersona();
        return ResponseEntity.ok().body(personaBasicDTO);
    }

}
