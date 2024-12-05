package com.av2.enums;







public enum Venda {

VENDIDO(0,"VENDIDO"),NAOVENDIDO(1,"NAOVENDIDO");

    private Integer id;
    private String StatusVenda;


    Venda(Integer id, String statusVenda) {
        this.id = id;
        this.StatusVenda = statusVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusVenda() {
        return StatusVenda;
    }

    public void setStatusVenda(String Statusvenda) {
        this.StatusVenda = Statusvenda;
    }

    public static Venda toEnum(Integer id){
        if(id==null) return null;
        for(Venda x : Venda.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status de venda invalido");
    }




}