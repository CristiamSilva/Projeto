package br.com.zup.controleVeiculos.feign;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Modelos {

    private Modelo modelos;

    @JsonCreator
    public Modelos(@JsonProperty Modelo modelos) {
        this.modelos = modelos;
    }

    public Modelo getModelos() {
        return modelos;
    }
}
