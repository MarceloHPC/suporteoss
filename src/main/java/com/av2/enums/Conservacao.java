package com.av2.enums;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;

public enum Conservacao {

NOVO (0,"NOVO"), SEMINOVO(1,"SEMINOVO");

private Integer id;
private String conservacao;


    Conservacao(Integer id, String conservacao) {
        this.id = id;
        this.conservacao = conservacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

public static Conservacao toEnum(Integer id){
    if(id==null) return null;
    for(Conservacao x : Conservacao.values()){
       if(id.equals(x.getId())){
           return x;
       }
    }
     throw new IllegalArgumentException("Status invalido");
    }
}