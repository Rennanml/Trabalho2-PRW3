package br.edu.ifsp.prw3.api_2025.domain;

import br.edu.ifsp.prw3.api_2025.dto.MecanicoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String codigo;
    @Setter
    private String nome;
    @Setter
    private int anosExperiencia;

    public Mecanico(MecanicoDTO dto){
        this.codigo = dto.codigo();
        this.nome = dto.nome();
        this.anosExperiencia = dto.anosExperiencia();
    }
}
