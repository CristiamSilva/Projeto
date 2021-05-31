package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.usuarios.Usuario;

import javax.persistence.*;


@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String anoVeiculo;
    private String tipo;
    private String valorVeiculo;
    private String diaRodizio;
    private boolean rodizioAtivo;

    /**
     *  Somente para o Hibernate
     */
    public Veiculo() {
    }

    public Veiculo(Usuario usuario, String marcaVeiculo, String modeloVeiculo, String anoVeiculo, String tipo, String valorVeiculo, String diaRodizio, boolean rodizioAtivo){
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.usuario = usuario;
        this.tipo = tipo;
        this.valorVeiculo = valorVeiculo;
        this.diaRodizio =diaRodizio;
        this.rodizioAtivo = rodizioAtivo;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValorVeiculo() {
        return valorVeiculo;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public boolean isRodizioAtivo() { return rodizioAtivo; }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marcaVeiculo='" + marcaVeiculo + '\'' +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
