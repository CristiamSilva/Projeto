package br.com.zup.controleVeiculos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "fipe-client", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeClient {

    @GetMapping("/{tipo}/marcas")
    List<Marcas> getMarcas(@PathVariable String tipo);

    @GetMapping("/{tipo}/marcas/{codigoMarca}/modelos")
    List<Modelos>  getModelos(@PathVariable String tipo, @PathVariable String codigoMarca);

}
