package com.av2.domains;


import com.av2.domains.dtos.VendedorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name= "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_vend")
    private Integer id;
    @NotNull @NotBlank
    private String nome;
    @NotBlank @NotNull
    private String cpf;

    private int numVendas;

    public Vendedor() {
    }



    public Vendedor(Integer id, String nome, String cpf, int numVendas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.numVendas = numVendas;
    }

    public Vendedor(VendedorDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.numVendas = dto.getNumVendas();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @NotNull String cpf) {
        this.cpf = cpf;
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return id == vendedor.id && numVendas == vendedor.numVendas && Objects.equals(nome, vendedor.nome) && Objects.equals(cpf, vendedor.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, numVendas);
    }
}
