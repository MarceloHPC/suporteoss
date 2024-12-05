package com.av2.repositories;


import com.av2.domains.Carro;
import com.av2.enums.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {

    List<Carro> findByStatusVenda(Venda statusVenda);
}
