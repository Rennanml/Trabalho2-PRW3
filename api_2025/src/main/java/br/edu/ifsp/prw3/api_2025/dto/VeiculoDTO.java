package br.edu.ifsp.prw3.api_2025.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        String placa,

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        @Pattern(regexp = "^\\d{4}$")
        String ano,

        String cor) {
}
