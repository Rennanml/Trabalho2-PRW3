package br.edu.ifsp.prw3.api_2025.domain;

import br.edu.ifsp.prw3.api_2025.dto.ConsertoDTO;
import br.edu.ifsp.prw3.api_2025.dto.DadosPatchConsertoDTO;
import br.edu.ifsp.prw3.api_2025.dto.MecanicoDTO;
import br.edu.ifsp.prw3.api_2025.dto.VeiculoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanicoResponsavel;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(ConsertoDTO dto){
        this.ativo = true;
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.mecanicoResponsavel = new Mecanico(dto.mecanicoResponsavel());
        this.veiculo = new Veiculo(dto.veiculo());
    }

    public ConsertoDTO toDTO() {
        return new ConsertoDTO(
                        this.dataEntrada,
                        this.dataSaida,
                new MecanicoDTO(
                                this.mecanicoResponsavel.getCodigo(),
                                this.mecanicoResponsavel.getNome(),
                                this.mecanicoResponsavel.getAnosExperiencia()
                        ),
                new VeiculoDTO(
                                this.veiculo.getPlaca(),
                                this.veiculo.getMarca(),
                                this.veiculo.getModelo(),
                                this.veiculo.getAno(),
                                this.veiculo.getCor()
                        ),
                this.ativo
                );
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizar(DadosPatchConsertoDTO dto) {
        this.dataSaida = dto.dataSaida();
        this.mecanicoResponsavel.setNome(dto.mecanico().nome());
        this.mecanicoResponsavel.setAnosExperiencia(dto.mecanico().anosExperiencia());
    }
}
