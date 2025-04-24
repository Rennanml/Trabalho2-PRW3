package br.edu.ifsp.prw3.api_2025.dto;

import br.edu.ifsp.prw3.api_2025.domain.Mecanico;
import br.edu.ifsp.prw3.api_2025.domain.Veiculo;

public record ConcertoDTO(String dataEntrada, String dataSaida, MecanicoDTO mecanicoResponsavel, VeiculoDTO veiculo) {
}
