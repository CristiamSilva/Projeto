package br.com.zup.controleVeiculos.feign;


public class Marca {

    private String nome;
    private String codigo;

    public Marca(String nome, String codigo) {
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