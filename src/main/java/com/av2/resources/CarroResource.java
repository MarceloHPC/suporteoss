package com.av2.resources;

import com.av2.domains.Carro;
import com.av2.domains.dtos.CarroDTO;
import com.av2.services.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        return ResponseEntity.ok().body(carroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Integer id) {
        Carro obj = this.carroService.findById(id);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

@PostMapping
public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO dto) {

  Carro carro = carroService.create(dto);

  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
          .buildAndExpand(carro.getId()).toUri();

    return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Integer id, @Valid @RequestBody CarroDTO objDto) {
        Carro obj = carroService.update(id, objDto);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }



}