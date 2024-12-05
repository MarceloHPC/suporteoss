package com.av2.resources;

import com.av2.domains.Comprador;
import com.av2.domains.Concessionaria;
import com.av2.domains.dtos.CompradorDTO;
import com.av2.domains.dtos.ConcessionariaDTO;
import com.av2.services.ConcessionariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/concessionarias")
public class ConcessionariaResource {

    @Autowired
    private ConcessionariaService concessionariaService;

    @GetMapping
    public ResponseEntity<List<ConcessionariaDTO>> findAll() {
        return ResponseEntity.ok().body(concessionariaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConcessionariaDTO> findById(@PathVariable Integer id) {
        Concessionaria obj = this.concessionariaService.findById(id);
        return ResponseEntity.ok().body(new ConcessionariaDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ConcessionariaDTO> create(@Valid @RequestBody ConcessionariaDTO dto) {

        Concessionaria concessionaria = concessionariaService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(concessionaria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ConcessionariaDTO> update(@PathVariable Integer id, @Valid @RequestBody ConcessionariaDTO objDto) {
        Concessionaria obj = concessionariaService.update(id, objDto);
        return ResponseEntity.ok().body(new ConcessionariaDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        concessionariaService.delete(id);
        return ResponseEntity.noContent().build();
    }




}