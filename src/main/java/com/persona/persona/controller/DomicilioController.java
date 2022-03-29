package com.persona.persona.controller;

import com.persona.persona.dto.DomicilioBasicDTO;
import com.persona.persona.dto.DomicilioDTO;
import com.persona.persona.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<DomicilioDTO> save(@RequestBody DomicilioDTO domicilioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(domicilioService.save(domicilioDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DomicilioDTO>> getAll(){
        return ResponseEntity.ok().body(domicilioService.getAllDomicilio());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDomicilio(@PathVariable Long id){
        domicilioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomicilioDTO> update(@PathVariable Long id,@RequestBody DomicilioDTO domicilioDTO){
        return ResponseEntity.ok().body(domicilioService.update(id,domicilioDTO));
    }

    @GetMapping("/basic")
    public ResponseEntity<List<DomicilioBasicDTO>> getBasicDomicilio(){
        return ResponseEntity.ok().body(domicilioService.getBasicDomicilio());
    }

}
