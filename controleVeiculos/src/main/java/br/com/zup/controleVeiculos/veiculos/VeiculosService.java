package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.feign.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VeiculosService {

    private FipeClient client;
    private String diaRodizio;
    private boolean rodizioAtivo = false;
    private LocalDate dia = LocalDate.now();

    public VeiculosService(FipeClient client) {
        this.client = client;
    }

    public String getDiaRodizio(String anoVeiculo) {
        String digitoAnoVeiculo = anoVeiculo.substring(anoVeiculo.length() - 3, anoVeiculo.length()-2);
        int diaSemana = dia.getDayOfWeek().ordinal();
        switch (digitoAnoVeiculo) {
            case "0":
            case "1":
                if (diaSemana == 0) {
                    return diaRodizio = "Hoje é segunda - feira e o rodízio está ativo";
                } else {
                    diaRodizio = "rodizio é na Segunda - Feira";
                }
                break;
            case "2":
            case "3":
                if (diaSemana == 1) {
                    return diaRodizio = "Hoje é Terça - feira e o rodízio está ativo";
                } else {
                    diaRodizio = "rodizio é na Segunda - Feira";
                }
                break;
            case "4":
            case "5":
                if (diaSemana == 2) {

                    return diaRodizio = "Hoje é quarta - feira e o rodízio está ativo";
                } else {
                    diaRodizio = "rodizio é na Quarta - Feira";
                }
                break;
            case "6":
            case "7":
                if (diaSemana == 3) {
                    return diaRodizio = "Hoje é quinta - feira e o rodízio está ativo";

                } else {
                    diaRodizio = "rodizio é na Quinta - Feira";
                }
                break;
            case "8":
            case "9":
                if (diaSemana == 4) {
                     diaRodizio = "Hoje é sexta - feira e o rodízio está ativo";
                } else {
                    diaRodizio = "rodizio é na Sexta - Feira";
                }
                break;
        }
        return diaRodizio;
    }

    public boolean ativaRodizio(String anoVeiculo){
        String digitoAnoVeiculo = anoVeiculo.substring(anoVeiculo.length() - 3, anoVeiculo.length()-2);
        int diaSemana = dia.getDayOfWeek().ordinal();
        int numnoVeiculo = Integer.parseInt(digitoAnoVeiculo);// Transforma digito em inteiro
        if(numnoVeiculo == diaSemana){
            return rodizioAtivo = true;
        }
        return rodizioAtivo =false;
    }

    public String getValorVeiculo(String tipo, String marcaVeiculo, String modeloVeiculo, String anoVeiculo) {
        String codigoMarca = null;
        List<Marca> marcas = client.buscarMarcas(tipo);
        for (Marca marca : marcas) {
            if (marcaVeiculo.equalsIgnoreCase(marca.getNome())) {
                codigoMarca = marca.getCodigo();
            }
        }
        ListaModeloEAno modeloAno = client.buscarModelosEAnos(tipo, codigoMarca);

        String codigoModelo = null;
        List<Modelo> modelos = modeloAno.getModelos();

        for (Modelo modelo : modelos) {
            if (modeloVeiculo.equalsIgnoreCase(modelo.getNome())) {
                codigoModelo = modelo.getCodigo();
            }
        }

        String codigoAno = null;
        List<Ano> anos = modeloAno.getAnos();

        for (Ano ano : anos) {
            if (anoVeiculo.equalsIgnoreCase(ano.getCodigo())) {
                codigoAno = ano.getCodigo();
            }
        }
        String valor = null;
        InfoVeiculo veiculo = client.buscarVeiculo(tipo, codigoMarca, codigoModelo, codigoAno);
        valor = veiculo.getValor();
        return valor;
    }
}
