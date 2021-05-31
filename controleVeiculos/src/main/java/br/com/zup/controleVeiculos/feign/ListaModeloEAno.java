package br.com.zup.controleVeiculos.feign;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class ListaModeloEAno {

    @JsonProperty
    List<Modelo> modelos= new ArrayList<>();
    @JsonProperty
    List<Ano> anos= new ArrayList<>();

    public ListaModeloEAno(List<Modelo> modelos, List<Ano> anos) {
        this.modelos = modelos;
        this.anos = anos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public List<Ano> getAnos() {
        return anos;
    }

}
