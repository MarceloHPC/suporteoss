package com.av2.domains.dtos;

import com.av2.domains.Concessionaria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConcessionariaDTO {


    private Integer id;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode estar vazio")
    private String cnpj;

    @NotNull(message = "O campo razão social não pode ser nulo")
    @NotBlank(message = "O campo razão social não pode estar vazio")
    private String razaoSocial;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    private VendedorDTO vendedor;

    private CarroDTO carro;

    public ConcessionariaDTO() {
    }

    public ConcessionariaDTO(Integer id, String cnpj, String razaoSocial, String nome, VendedorDTO vendedor, CarroDTO carro) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nome = nome;
        this.vendedor = vendedor;
        this.carro = carro;
    }

    public ConcessionariaDTO(Concessionaria obj) {
        this.id = obj.getId();
        this.cnpj = obj.getCnpj();
        this.razaoSocial = obj.getRazaoSocial();
        this.nome = obj.getNome();

        if (obj.getVendedor() != null) {
            this.vendedor = new VendedorDTO(obj.getVendedor());
        }

        if (obj.getCarro() != null) {
            this.carro = new CarroDTO(obj.getCarro());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public VendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDTO vendedor) {
        this.vendedor = vendedor;
    }

    public CarroDTO getCarro() {
        return carro;
    }

    public void setCarro(CarroDTO carro) {
        this.carro = carro;
    }
}