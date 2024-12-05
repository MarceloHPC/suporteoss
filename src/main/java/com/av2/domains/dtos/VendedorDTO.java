package com.av2.domains.dtos;

import com.av2.domains.Vendedor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendedorDTO {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo CPF não pode ser nulo")
    @NotBlank(message = "O campo CPF não pode estar vazio")
    private String cpf;

    @NotNull(message = "O campo número de vendas não pode ser nulo")
    private int numVendas;

    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.cpf = vendedor.getCpf();
        this.numVendas = vendedor.getNumVendas();
    }
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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
}