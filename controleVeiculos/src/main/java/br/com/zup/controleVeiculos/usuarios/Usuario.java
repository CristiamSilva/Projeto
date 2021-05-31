package br.com.zup.controleVeiculos.usuarios;

import br.com.zup.controleVeiculos.veiculos.Veiculo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;
    private  String email;
    private  LocalDate dataNascimento;
    private  String cpf;
    @OneToMany(mappedBy = "usuario")
    private List<Veiculo> veiculos = new ArrayList<>();

    /**
     *  Somente para o Hibernate
     */
    public Usuario() {
    }

    public Usuario(String nome, String email, LocalDate dataNascimento, String cpf, List<Veiculo> veiculos) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
