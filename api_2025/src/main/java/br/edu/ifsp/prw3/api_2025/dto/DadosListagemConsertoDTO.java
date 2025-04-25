package br.edu.ifsp.prw3.api_2025.dto;

import br.edu.ifsp.prw3.api_2025.domain.Conserto;

public record DadosListagemConsertoDTO(
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String modeloVeiculo,
        String marcaVeiculo,
        Long id
) {
    public DadosListagemConsertoDTO(Conserto conserto) {

        this(   conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getVeiculo().getModelo(),
                conserto.getVeiculo().getMarca(),
                conserto.getId()
        );

    }
}
