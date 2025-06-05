package br.edu.ifsp.prw3.api_2025.dto;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        String codigo,

        @NotBlank
        String nome,

        int anosExperiencia) {
}
