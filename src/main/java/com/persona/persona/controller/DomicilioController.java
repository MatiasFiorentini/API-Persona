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
        DomicilioDTO domicilioSaved = domicilioService.save(domicilioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(domicilioSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DomicilioDTO>> getAll(){
        List<DomicilioDTO> domicilioList = domicilioService.getAllDomicilio();
        return ResponseEntity.ok().body(domicilioList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDomicilio(@PathVariable Long id){
        domicilioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomicilioDTO> update(@PathVariable Long id,@RequestBody DomicilioDTO domicilioDTO){
        DomicilioDTO domicilioUpdate = domicilioService.update(id,domicilioDTO);
        return ResponseEntity.ok().body(domicilioUpdate);
    }

    @GetMapping("/basic")
    public ResponseEntity<List<DomicilioBasicDTO>> getBasicDomicilio(){
        List<DomicilioBasicDTO> domicilioBasicDTO = domicilioService.getBasicDomicilio();
        return ResponseEntity.ok().body(domicilioBasicDTO);
    }

}
