package br.edu.ifsp.prw3.api_2025.domain;

import br.edu.ifsp.prw3.api_2025.dto.ConcertoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "concertos")
@Entity(name = "Concerto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Concerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String dataEntrada;
    String dataSaida;
    @Embedded
    Mecanico mecanicoResponsavel;
    @Embedded
    Veiculo veiculo;

    public Concerto(ConcertoDTO dto){
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.mecanicoResponsavel = new Mecanico(dto.mecanicoResponsavel());
        this.veiculo = new Veiculo(dto.veiculo());
    }
}
