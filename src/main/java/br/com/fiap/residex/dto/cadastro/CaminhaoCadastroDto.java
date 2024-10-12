package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Empresa;
import br.com.fiap.residex.model.Status;
import jakarta.validation.constraints.NotBlank;

public record CaminhaoCadastroDto(

        Long idCaminhao,

        @NotBlank
        String modelo,

        @NotBlank
        String placa,

        Coordenada coordenada,

        Status status,

        Empresa empresa
) {
}
