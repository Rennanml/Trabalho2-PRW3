package br.edu.ifsp.prw3.api_2025.domain;

import br.edu.ifsp.prw3.api_2025.dto.VeiculoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    String placa;
    String marca;
    String modelo;
    String ano;

    public Veiculo(VeiculoDTO dto){
        this.placa = dto.placa();
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.ano = dto.ano();
    }
}
