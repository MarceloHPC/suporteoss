package com.av2.services;


import com.av2.domains.Comprador;
import com.av2.domains.Vendedor;
import com.av2.domains.dtos.CompradorDTO;
import com.av2.domains.dtos.VendedorDTO;
import com.av2.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<VendedorDTO> findAll() {
        return vendedorRepository.findAll().stream()
                .map(VendedorDTO::new)
                .collect(Collectors.toList());
    }

    public Vendedor findById(Integer id) {
        Optional<Vendedor> obj = vendedorRepository.findById(id);
        return obj.orElse(null);
    }

    public Vendedor create(VendedorDTO dto) {
        Vendedor vendedor = new Vendedor(dto);
        return vendedorRepository.save(vendedor);
    }

    public Vendedor update(Integer id, VendedorDTO objDto){
        objDto.setId(id);
        Vendedor oldObj = findById(id);
        oldObj = new Vendedor(objDto);
        return vendedorRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Vendedor vendedor = findById(id);
        vendedorRepository.delete(vendedor);
    }
}