package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.usuarios.Usuario;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String anoVeiculo;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String tipo;

    /**
     *  Somente para o Hibernate
     */
    public Veiculo() {

    }


    public Veiculo(String marcaVeiculo, String modeloVeiculo, String anoVeiculo, Usuario usuario, String tipo) {
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.usuario = usuario;
        this.tipo = tipo;
    }

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
