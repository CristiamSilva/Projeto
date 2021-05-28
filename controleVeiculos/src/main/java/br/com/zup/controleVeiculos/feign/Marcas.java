package br.com.zup.controleVeiculos.feign;


public class Marcas {

    private String nome;
    private String codigo;

    public Marcas(String nome, String codigo) {
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
