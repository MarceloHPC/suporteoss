package com.av2.domains;


import com.av2.domains.dtos.CompradorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;



@Entity
@Table(name = "comprador")
public class Comprador {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_comprador")
private Integer id;

@NotNull @NotBlank
private String nome;

@NotNull @NotBlank
private String rg;

private String email;

private String cpf;

private int telefone;

    public Comprador(Integer id, String nome, String rg, String email, String cpf, int telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Comprador(CompradorDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.email = dto.getEmail();
        this.cpf = dto.getCpf();
        this.telefone = dto.getTelefone();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public Comprador() {
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprador comprador = (Comprador) o;
        return id == comprador.id && telefone == comprador.telefone && Objects.equals(nome, comprador.nome) && Objects.equals(rg, comprador.rg) && Objects.equals(email, comprador.email) && Objects.equals(cpf, comprador.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, rg, email, cpf, telefone);
    }
}