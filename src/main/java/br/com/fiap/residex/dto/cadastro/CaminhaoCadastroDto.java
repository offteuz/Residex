package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Capacidade;
import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Empresa;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record CaminhaoCadastroDto(

        Long idCaminhao,

        @NotBlank
        String modelo,

        @NotBlank
        String placa,

        @NotBlank
        char emRota,

        Coordenada coordenada,

        Capacidade capacidade,

        EmpresaCaminhaoDto empresa
) {
}
