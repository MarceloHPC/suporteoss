package com.av2.services;

import com.av2.enums.Conservacao;
import com.av2.domains.Carro;
import com.av2.domains.Comprador;
import com.av2.domains.Concessionaria;
import com.av2.domains.Vendedor;
import com.av2.enums.Venda;
import com.av2.repositories.CarroRepository;
import com.av2.repositories.CompradorRepository;
import com.av2.repositories.ConcessionariaRepository;
import com.av2.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DBService {

@Autowired
private CarroRepository carroRepository;

@Autowired
private CompradorRepository compradorRepository;

@Autowired
private VendedorRepository vendedorRepository;

@Autowired
private ConcessionariaRepository concessionariaRepository;

    public void initDB() {
        // Criando Vendedores
        Vendedor vendedor1 = new Vendedor(null, "Carlos Silva", "12345678900", 10);
        Vendedor vendedor2 = new Vendedor(null, "Ana Oliveira", "98765432100", 15);



        // Criando Carros
        Carro carro1 = new Carro(null, new BigDecimal("150000.50"), "CHASSI001", 12345, LocalDate.of(2023, 1, 1), 0, Conservacao.NOVO, Venda.VENDIDO);
        Carro carro2 = new Carro(null, new BigDecimal("120000.75"), "CHASSI002", 67890, LocalDate.of(2022, 5, 20), 1000, Conservacao.SEMINOVO,Venda.NAOVENDIDO);



        // Criando Compradores
        Comprador comprador1 = new Comprador(null, "João Almeida", "12345678", "joao@gmail.com", "12345678900", 999999999);
        Comprador comprador2 = new Comprador(null, "Maria Santos", "87654321", "maria@gmail.com", "98765432100", 888888888);



        // Criando Concessionárias
        Concessionaria concessionaria1 = new Concessionaria(null, "12.345.678/0001-99", "AutoCar LTDA", "AutoCar",carro1,vendedor1);
        Concessionaria concessionaria2 = new Concessionaria(null ,"98.765.432/0001-88", "SuperCar LTDA", "SuperCar",carro2,vendedor2);



      vendedorRepository.save(vendedor1);
      vendedorRepository.save(vendedor2);
      carroRepository.save(carro1);
      carroRepository.save(carro2);
      compradorRepository.save(comprador1);
      compradorRepository.save(comprador2);
      concessionariaRepository.save(concessionaria1);
      concessionariaRepository.save(concessionaria2);
    }





}