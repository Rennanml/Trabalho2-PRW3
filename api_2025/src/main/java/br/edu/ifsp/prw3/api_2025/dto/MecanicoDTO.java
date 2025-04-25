package br.edu.ifsp.prw3.api_2025.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MecanicoDTO(
        String codigo,

        @NotBlank
        String nome,

        int anosExperiencia) {
}
