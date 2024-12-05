package com.av2.domains.dtos;

import com.av2.domains.Comprador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompradorDTO {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo RG não pode ser nulo")
    @NotBlank(message = "O campo RG não pode estar vazio")
    private String rg;

    @NotNull(message = "O campo email não pode ser nulo")
    @NotBlank(message = "O campo email não pode estar vazio")
    private String email;

    @NotNull(message = "O campo CPF não pode ser nulo")
    @NotBlank(message = "O campo CPF não pode estar vazio")
    private String cpf;

    @NotNull(message = "O campo telefone não pode ser nulo")
    private Integer telefone;

    public CompradorDTO() {
    }

    public CompradorDTO(Comprador comprador) {
        this.id = comprador.getId();
        this.nome = comprador.getNome();
        this.rg = comprador.getRg();
        this.email = comprador.getEmail();
        this.cpf = comprador.getCpf();
        this.telefone = comprador.getTelefone();
    }

    public CompradorDTO(Integer id, String nome, String rg, String email, String cpf, Integer telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }









}