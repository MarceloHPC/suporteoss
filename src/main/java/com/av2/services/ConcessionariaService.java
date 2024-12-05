package com.av2.services;

import com.av2.enums.Venda;
import com.av2.domains.Carro;
import com.av2.domains.Comprador;
import com.av2.domains.Concessionaria;
import com.av2.domains.Vendedor;
import com.av2.domains.dtos.CompradorDTO;
import com.av2.domains.dtos.ConcessionariaDTO;
import com.av2.repositories.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConcessionariaService {

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    public List<ConcessionariaDTO> findAll() {
        return concessionariaRepository.findAll().stream()
                .map(ConcessionariaDTO::new)
                .collect(Collectors.toList());
    }

    public Concessionaria findById(Integer id) {
        Optional<Concessionaria> obj = concessionariaRepository.findById(id);
        return obj.orElse(null);
    }

    public Concessionaria create(ConcessionariaDTO dto) {
        Concessionaria concessionaria = new Concessionaria(dto);
        return concessionariaRepository.save(concessionaria);
    }

    public Concessionaria update(Integer id, ConcessionariaDTO objDto) {
        Concessionaria oldObj = findById(id);
        if (oldObj == null) {
            throw new RuntimeException("Concessionaria not found with id: " + id);
        }
        return concessionariaRepository.save(oldObj);
    }

    public void delete(Integer id) {

        Concessionaria concessionaria = findById(id);


        if (concessionaria.getCarro() != null
                && Venda.NAOVENDIDO.equals(concessionaria.getCarro().getStatusVenda())) {
            throw new RuntimeException("Não é possível deletar a concessionária porque o carro associado está com status DISPONIVEL.");
        }


        concessionariaRepository.delete(concessionaria);
    }
}