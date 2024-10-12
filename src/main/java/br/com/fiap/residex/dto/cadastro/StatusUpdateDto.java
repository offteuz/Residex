package br.com.fiap.residex.dto.cadastro;

import jakarta.validation.constraints.NotBlank;

public record StatusUpdateDto(

        @NotBlank
        String descricaoStatus
) {
}
