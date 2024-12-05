package com.av2.domains;

import com.av2.enums.Venda;
import com.av2.domains.dtos.CarroDTO;
import com.av2.enums.Conservacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "carro")
public class Carro {


@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_carro")
private Integer id;

@NotNull
@Digits(integer = 15,fraction = 3)
private BigDecimal valorCompra;
@NotNull @NotBlank
private String numChassi;

private int numDocumento;

@JsonFormat(pattern = "dd/MM/yyyy")
private LocalDate dataCompra;

private

int kmRodados;

@Enumerated(EnumType.ORDINAL)
@JoinColumn(name ="conservacao")
private Conservacao conservacao;


@Enumerated
@JoinColumn(name = "statusVenda")
private Venda statusVenda;


     public Carro(){
         this.conservacao = Conservacao.NOVO;
         this.statusVenda = statusVenda.NAOVENDIDO;
     }



    public Carro(Integer id, BigDecimal valorCompra, String numChassi, int numDocumento, LocalDate dataCompra, int kmRodados, Conservacao conservacao, Venda statusVenda) {
        this.id = id;
        //this.valorCompra = valorCompra;
        this.numChassi = numChassi;
        this.numDocumento = numDocumento;
        this.dataCompra = dataCompra;
        this.kmRodados = kmRodados;
        this.conservacao = conservacao;
        this.statusVenda = statusVenda;
     this.valorCompra = valorCompra != null ? valorCompra : BigDecimal.ZERO;

     }

    public Carro(CarroDTO dto) {
        this.id = dto.getId();
        this.valorCompra = dto.getValorCompra();
        this.numChassi = dto.getNumChassi();
        this.numDocumento = dto.getNumDocumento();
        this.dataCompra = dto.getDataCompra();
        this.kmRodados = dto.getKmRodados();
        this.conservacao = dto.getConservacao();
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(int kmRodados) {
        this.kmRodados = kmRodados;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    public Venda getStatusVenda() {return statusVenda;}

    public void setStatusVenda(Venda statusVenda) {this.statusVenda = statusVenda;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return id == carro.id && numDocumento == carro.numDocumento && kmRodados == carro.kmRodados && Objects.equals(valorCompra, carro.valorCompra) && Objects.equals(numChassi, carro.numChassi) && Objects.equals(dataCompra, carro.dataCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valorCompra, numChassi, numDocumento, dataCompra, kmRodados);
    }
}