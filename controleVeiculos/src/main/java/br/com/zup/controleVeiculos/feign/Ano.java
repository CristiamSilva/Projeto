package br.com.zup.controleVeiculos.feign;


public class Ano {
    private String nome;
    private String codigo;

    public Ano(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
