package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.feign.FipeClient;
import br.com.zup.controleVeiculos.feign.Marcas;
import br.com.zup.controleVeiculos.feign.Modelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    @Autowired
    private FipeClient client;

    public VeiculosService(FipeClient client) {
        this.client = client;
    }

    public void getValorVeiculo(String tipo, String marcaVeiculo, String modeloVeiculo){
        String codigoMarca = null;
        List<Marcas> marcas = client.getMarcas(tipo);
        for(Marcas marca: marcas){

            if(marcaVeiculo.equalsIgnoreCase(marca.getNome())){
                codigoMarca = marca.getCodigo();
            }
        }
        System.out.println("codigoMarca: " + codigoMarca);

        String codigoModelo = null;
        List<Modelos> modelos = client.getModelos(tipo, codigoMarca);
        for(Modelos modelo: modelos){

            if(modeloVeiculo.equalsIgnoreCase(modelo.getModelos().getNome())){

                codigoModelo = modelo.getModelos().getCodigo();

                System.out.println("codigoModelo: " + codigoModelo);
            }
        }
    }
}
