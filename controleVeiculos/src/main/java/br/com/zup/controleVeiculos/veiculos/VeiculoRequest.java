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
    @NotNull
    private String valorVeiculo;
    private String diaSemana;
    @NotNull
    private String diaRodizio;
    private boolean rodizioAtivo;



    //Construtor

    public VeiculoRequest(Usuario usuario, String marcaVeiculo, String modeloVeiculo, String anoVeiculo, String tipo, String valorVeiculo, String diaSemana, String diaRodizio, boolean rodizioAtivo) {
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.valorVeiculo = valorVeiculo;
        this.diaSemana = diaSemana;
        this.diaRodizio = diaRodizio;
        this.rodizioAtivo = rodizioAtivo;
    }

    public Veiculo toVeiculo(UsuarioRepository repository, String valorVeiculo, String diaRodizio, boolean rodizioAtivo) {

        Optional<Usuario> usuario = repository.findById(idUsuario);
        if (usuario.isPresent()) {
            return new Veiculo(usuario.get(), marcaVeiculo, modeloVeiculo, anoVeiculo, tipo, valorVeiculo, diaRodizio, rodizioAtivo);
        }
        return null;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public Long getIdUsuario() { return idUsuario; }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }
}
