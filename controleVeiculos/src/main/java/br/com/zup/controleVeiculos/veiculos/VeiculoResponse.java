package br.com.zup.controleVeiculos.veiculos;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoResponse {

    private Long idVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String anoVeiculo;
    private String tipo;
    private String valorVeiculo;
    private String diaRodizio;
    private boolean rodizioAtivo;


    public VeiculoResponse(Veiculo veiculo) {
        this.idVeiculo = veiculo.getId();
        this.marcaVeiculo = veiculo.getMarcaVeiculo();
        this.modeloVeiculo = veiculo.getModeloVeiculo();
        this.anoVeiculo = veiculo.getAnoVeiculo();
        this.tipo = veiculo.getTipo();
        this.valorVeiculo = veiculo.getValorVeiculo();
        this.diaRodizio = veiculo.getDiaRodizio();
        this.rodizioAtivo = veiculo.isRodizioAtivo();

    }

    public Long getId() {
        return idVeiculo;
    }

    public String getMarcaVeiculo() { return marcaVeiculo; }

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

    public String getDiaRodizio() { return diaRodizio; }

    public boolean isRodizioAtivo() {
        return rodizioAtivo;
    }

    public static List<VeiculoResponse> listarveiculos(List<Veiculo> veiculos) {
        return veiculos.stream().map(VeiculoResponse::new).collect(Collectors.toList());
    }
}
