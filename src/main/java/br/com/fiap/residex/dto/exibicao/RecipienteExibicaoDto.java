package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Recipiente;

public record RecipienteExibicaoDto(

        Long idRecipiente,

        String tipoResiduo,

        double capacidadeAtual,

        double capacidadeMaxima,

        Morador morador,

        Coordenada coordenada
) {

    public RecipienteExibicaoDto(Recipiente recipiente) {
        this (
                recipiente.getIdRecipiente(),
                recipiente.getTipoResiduo(),
                recipiente.getCapacidadeAtual(),
                recipiente.getCapacidadeMaxima(),
                recipiente.getMorador(),
                recipiente.getCoordenada()
        );
    }
}
