package br.com.zup.controleVeiculos.feign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoVeiculo {
    @JsonProperty
    private String  Valor;
    @JsonProperty
    private String  Marca;
    @JsonProperty
    private String  Modelo;
    @JsonProperty
    private String  AnoModelo;
    @JsonProperty
    private String  Combustivel;
    @JsonProperty
    private String  CodigoFipe;
    @JsonProperty
    private String  MesReferencia;
    @JsonProperty
    private String  TipoVeiculo;
    @JsonProperty
    private String  SiglaCombustivel;

    public InfoVeiculo( String valor, String marca, String modelo, String anoModelo, String combustivel, String codigoFipe, String mesReferencia, String tipoVeiculo, String siglaCombustivel) {

        this.Valor = valor;
        this.Marca = marca;
        this.Modelo = modelo;
        this.AnoModelo = anoModelo;
        this.Combustivel = combustivel;
        this.CodigoFipe = codigoFipe;
        this.MesReferencia = mesReferencia;
        this.TipoVeiculo = tipoVeiculo;
        this.SiglaCombustivel = siglaCombustivel;
    }

    public String getValor() {
        return Valor;
    }
    public String getMarca() {
        return Marca;
    }
    public String getModelo() {
        return Modelo;
    }
    public String getAnoModelo() {
        return AnoModelo;
    }
    public String getCombustivel() {
        return Combustivel;
    }
    public String getCodigoFipe() {
        return CodigoFipe;
    }
    public String getMesReferencia() {
        return MesReferencia;
    }
    public String getTipoVeiculo() {
        return TipoVeiculo;
    }
    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }
}
