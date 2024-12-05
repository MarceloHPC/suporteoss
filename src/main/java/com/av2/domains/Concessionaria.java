package com.av2.domains;


import com.av2.domains.dtos.ConcessionariaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "concessionaria")
public class Concessionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conce")
    private Integer id;

    @NotBlank
    @NotNull
    private String cnpj;

    private String razaoSocial;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "idCarro")
    private Carro carro;

    public Concessionaria() {

    }

    public Concessionaria(Integer id, String cnpj, String razaoSocial, String nome, Carro carro, Vendedor vendedor) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nome = nome;
        this.carro = carro;
        this.vendedor = vendedor;
    }

    public Concessionaria(ConcessionariaDTO dto) {
        this.id = dto.getId();
        this.cnpj = dto.getCnpj();
        this.razaoSocial = dto.getRazaoSocial();
        this.nome = dto.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concessionaria that = (Concessionaria) o;
        return id == that.id &&
                Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(razaoSocial, that.razaoSocial) &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, razaoSocial, nome);
    }
}