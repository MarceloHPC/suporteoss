package com.av2.services;

import com.av2.domains.Carro;
import com.av2.domains.Comprador;
import com.av2.domains.dtos.CarroDTO;
import com.av2.domains.dtos.CompradorDTO;
import com.av2.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    public List<CompradorDTO> findAll() {
        return compradorRepository.findAll().stream()
                .map(CompradorDTO::new)
                .collect(Collectors.toList());
    }

    public Comprador findById(Integer id) {
        Optional<Comprador> obj = compradorRepository.findById(id);
        return obj.orElse(null);
    }

    public Comprador create(CompradorDTO dto) {
        Comprador comprador = new Comprador(dto);
        return compradorRepository.save(comprador);
    }

    public Comprador update(Integer id, CompradorDTO objDto){
        objDto.setId(id);
        Comprador oldObj = findById(id);
        oldObj = new Comprador(objDto);
        return compradorRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Comprador comprador = findById(id);
        compradorRepository.delete(comprador);
    }

}