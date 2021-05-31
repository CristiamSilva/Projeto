package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.Exceptions.Excessoes;
import br.com.zup.controleVeiculos.usuarios.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario/veiculos")
public class VeiculoController {

    private VeiculoRepository veiculoRepository;
    private UsuarioRepository usuarioRepository;
    private VeiculosService service;

    public VeiculoController(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository, VeiculosService service) {
        this.veiculoRepository = veiculoRepository;
        this.usuarioRepository = usuarioRepository;
        this.service = service;
    }

    @PostMapping                                    //Recebe dados no corpo Através da classe VeiculosRequest
    public ResponseEntity<?> cadastraVeiculoUsuario(@RequestBody VeiculoRequest request){
        String valorVeiculo = service.getValorVeiculo(request.getTipo(), request.getMarcaVeiculo(), request.getModeloVeiculo(), request.getAnoVeiculo());
        String verificaDiaRodizio = service.getDiaRodizio(request.getAnoVeiculo());
        boolean ativaRodizio = service.ativaRodizio(request.getAnoVeiculo());
        Veiculo veiculo = request.toVeiculo(usuarioRepository, valorVeiculo, verificaDiaRodizio, ativaRodizio);
        if(veiculo.getModeloVeiculo() == null || veiculo.getModeloVeiculo() == null || veiculo.getMarcaVeiculo() == null
         || veiculo.getAnoVeiculo() == null){
            throw new Excessoes  ("Dados do veiculo incorretos");
        }
        veiculoRepository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping( "/{usuarioId}" )
    public List<VeiculoResponse> findAll () {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return VeiculoResponse.listarveiculos(veiculos);
    }
}


