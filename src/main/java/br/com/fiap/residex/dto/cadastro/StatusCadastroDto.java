package br.com.fiap.residex.dto.cadastro;

import jakarta.validation.constraints.NotBlank;

public record StatusCadastroDto(

        Long idStatus,

        @NotBlank
        String descricaoStatus
) {
}
