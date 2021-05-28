package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.usuarios.Usuario;
import br.com.zup.controleVeiculos.usuarios.UsuarioRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class VeiculoRequest {

    @NotBlank
    private String marcaVeiculo;
    @NotBlank
    private String modeloVeiculo;
    @NotBlank
    private String anoVeiculo;
    @NotNull
    private Long idUsuario;
    @NotNull
    private String tipo;




    //Construtor


    public VeiculoRequest(String marcaVeiculo, String modeloVeiculo, String anoVeiculo, Long idUsuario, String tipo) {
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.idUsuario = idUsuario;
        this.tipo = tipo;


    }

    public Veiculo toVeiculo(UsuarioRepository repository) {

        Optional<Usuario> usuario = repository.findById(idUsuario);
        if (usuario.isPresent()) {
            return new Veiculo(marcaVeiculo, modeloVeiculo, anoVeiculo, usuario.get(), tipo);
        }
        return null;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String getTipo() {
        return tipo;
    }


}
