package com.persona.persona.controller;

import com.persona.persona.dto.LocalidadDTO;
import com.persona.persona.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {

    @Autowired
    private LocalidadService localidadService;

    @PostMapping
    public ResponseEntity<LocalidadDTO> save(@RequestBody LocalidadDTO localidadDTO){
        LocalidadDTO localidadSaved = localidadService.save(localidadDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(localidadSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LocalidadDTO>> getAll(){
        List<LocalidadDTO> localidadList = localidadService.getAllLocalidad();
        return ResponseEntity.ok().body(localidadList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeLocalidad(@PathVariable Long id){
        localidadService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalidadDTO> update(@PathVariable Long id,@RequestBody LocalidadDTO localidadDTO){
        LocalidadDTO localidadUpdate = localidadService.update(id,localidadDTO);
        return ResponseEntity.ok().body(localidadUpdate);
    }

}
