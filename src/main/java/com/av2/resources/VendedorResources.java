package com.av2.resources;

import com.av2.domains.Comprador;
import com.av2.domains.Vendedor;
import com.av2.domains.dtos.CompradorDTO;
import com.av2.domains.dtos.VendedorDTO;
import com.av2.services.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorResources {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> findAll() {
        return ResponseEntity.ok().body(vendedorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendedorDTO> findById(@PathVariable Integer id) {
        Vendedor obj = this.vendedorService.findById(id);
        return ResponseEntity.ok().body(new VendedorDTO(obj));
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> create(@Valid @RequestBody VendedorDTO dto) {

        Vendedor vendedor = vendedorService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(vendedor.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendedorDTO> update(@PathVariable Integer id, @Valid @RequestBody VendedorDTO objDto) {
        Vendedor obj = vendedorService.update(id, objDto);
        return ResponseEntity.ok().body(new VendedorDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vendedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}