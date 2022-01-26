package com.example.consultandoapicorreios.models;

public class ModelConsult {

    private String cep;
    private String uf;
    private String localidade;
    private String bairro;

    public ModelConsult() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String toString() {
        return "CEP: " + getCep()
                + "\nBairro: " + getBairro()
                + "\nCidade:" + getLocalidade()
                + "\nEstado: " + getUf();
    }

}
