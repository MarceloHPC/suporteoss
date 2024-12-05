package com.av2.domains.dtos;

import com.av2.domains.Carro;
import com.av2.enums.Conservacao;
import com.av2.enums.Venda;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarroDTO {

    private Integer id;

    @NotNull(message = "O campo valor de compra não pode ser nulo")
    @Digits(integer = 15, fraction = 3, message = "Valor de compra inválido")
    private BigDecimal valorCompra;

    @NotNull(message = "O campo número do chassi não pode ser nulo")
    @NotBlank(message = "O campo número do chassi não pode estar vazio")
    private String numChassi;

    @NotNull(message = "O campo número do documento não pode ser nulo")
    private Integer numDocumento;

    @NotNull(message = "O campo data de compra não pode ser nulo")
    private LocalDate dataCompra;

    @NotNull(message = "O campo quilometragem não pode ser nulo")
    private Integer kmRodados;

    @NotNull(message = "O campo conservação não pode ser nulo")
    private Conservacao conservacao;

    @NotNull(message = "O campo Status Venda não pode ser nulo")
    private Venda venda;

    public CarroDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public Integer getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Integer numDocumento) {
        this.numDocumento = numDocumento;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(Integer kmRodados) {
        this.kmRodados = kmRodados;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    public void setVenda(Venda venda){this.venda = venda;}

    public Venda getVenda(){return venda;}

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.valorCompra = carro.getValorCompra();
        this.numChassi = carro.getNumChassi();
        this.numDocumento = carro.getNumDocumento();
        this.dataCompra = carro.getDataCompra();
        this.kmRodados = carro.getKmRodados();
        this.conservacao = carro.getConservacao();
        this.venda = carro.getStatusVenda();
    }
}