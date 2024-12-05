package com.av2.resources;

import com.av2.domains.Carro;
import com.av2.domains.Comprador;
import com.av2.domains.dtos.CarroDTO;
import com.av2.domains.dtos.CompradorDTO;
import com.av2.services.CompradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/compradores")
public class CompradorResource {

    @Autowired
    private CompradorService compradorService;

    @GetMapping
    public ResponseEntity<List<CompradorDTO>> findAll() {
        return ResponseEntity.ok().body(compradorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompradorDTO> findById(@PathVariable Integer id) {
        Comprador obj = this.compradorService.findById(id);
        return ResponseEntity.ok().body(new CompradorDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CompradorDTO> create(@Valid @RequestBody CompradorDTO dto) {

        Comprador comprador = compradorService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(comprador.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CompradorDTO> update(@PathVariable Integer id, @Valid @RequestBody CompradorDTO objDto) {
        Comprador obj = compradorService.update(id, objDto);
        return ResponseEntity.ok().body(new CompradorDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        compradorService.delete(id);
        return ResponseEntity.noContent().build();
    }


}