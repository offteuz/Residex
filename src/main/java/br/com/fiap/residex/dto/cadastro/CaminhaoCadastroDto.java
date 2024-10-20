package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Capacidade;
import br.com.fiap.residex.model.Coordenada;

public record CaminhaoCadastroDto(

        Long idCaminhao,

        String modelo,

        String placa,

        String emRota,

        Capacidade capacidade,

        EmpresaCaminhaoDto empresa
) {
}
