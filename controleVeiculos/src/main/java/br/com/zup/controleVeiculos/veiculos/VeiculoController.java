package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    private UsuarioRepository usuarioRepository;
    private VeiculosService service;

    public VeiculoController(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository, VeiculosService service) {
        this.veiculoRepository = veiculoRepository;
        this.usuarioRepository = usuarioRepository;
        this.service = service;
    }

    @PostMapping                                    //Recebe dados no corpo Atravé da classe VeiculosRequest
    public ResponseEntity<?> cadastraVeiculoUsuario(@RequestBody VeiculoRequest request){
        service.getValorVeiculo(request.getTipo(), request.getMarcaVeiculo(), request.getModeloVeiculo());
        Veiculo veiculo = request.toVeiculo(usuarioRepository);
        veiculoRepository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
