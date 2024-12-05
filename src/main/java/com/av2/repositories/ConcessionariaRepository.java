package com.av2.repositories;


import com.av2.domains.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionaria,Integer> {
}
