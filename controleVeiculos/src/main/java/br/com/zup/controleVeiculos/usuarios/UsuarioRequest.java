package br.com.zup.controleVeiculos.usuarios;

import br.com.zup.controleVeiculos.veiculos.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


public class UsuarioRequest {
    @NotBlank
    private String nome;
    @Email
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
    @NotBlank
    private String cpf;
    @OneToMany(mappedBy = "usuario")
    private List<Veiculo> veiculos;




    public UsuarioRequest(String nome, String email, String cpf, List<Veiculo> veiculos) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.veiculos = veiculos;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Usuario toUsuario() {
        return new Usuario(nome, email, dataNascimento, cpf, veiculos);
    }
}
