package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Coordenada;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MoradorCadastroDto(

        Long idMorador,

        @NotBlank
        String nomeMorador,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String logradouro,

        Coordenada coordenada
) {
}
