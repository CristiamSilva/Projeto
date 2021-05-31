package br.com.zup.controleVeiculos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "fipe-client", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeClient {

    @GetMapping("/{tipo}/marcas")
    List<Marca> buscarMarcas(@PathVariable String tipo);

    @GetMapping("/{tipo}/marcas/{codigoMarca}/modelos")
    ListaModeloEAno buscarModelosEAnos(@PathVariable("tipo") String tipo, @PathVariable("codigoMarca") String codigoMarca);

    @GetMapping("/{tipo}/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}")
    InfoVeiculo buscarVeiculo(@PathVariable("tipo") String tipo, @PathVariable("codigoMarca") String codigoMarca, @PathVariable("codigoModelo") String codigoModelo, @PathVariable("codigoAno") String codigoAno);
}