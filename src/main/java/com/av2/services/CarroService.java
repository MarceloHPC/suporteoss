package com.av2.services;


import com.av2.enums.Venda;
import com.av2.domains.Carro;
import com.av2.domains.dtos.CarroDTO;
import com.av2.repositories.CarroRepository;
import com.av2.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroDTO> findAll() {
        return carroRepository.findAll().stream()
                .map(CarroDTO::new)
                .collect(Collectors.toList());
    }

    public Carro findById(Integer id) {
        Optional<Carro> obj = carroRepository.findById(id);
        return obj.orElse(null);
    }

    public List<Carro> findByVenda(Venda statusVenda) {
        return carroRepository.findByStatusVenda(statusVenda);
    }

    public Carro create(CarroDTO dto) {
        dto.setId(null);
        Carro carro = new Carro(dto);
        return carroRepository.save(carro);
    }

    public Carro update(Integer id,CarroDTO objDto){
    objDto.setId(id);
    Carro oldObj = findById(id);
    oldObj = new Carro(objDto);
    return carroRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Carro carro = findById(id);
        carroRepository.deleteById(id);
        }





}