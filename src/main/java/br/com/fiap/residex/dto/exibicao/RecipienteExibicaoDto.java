package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.*;

import java.util.List;

public record RecipienteExibicaoDto(

        Long idRecipiente,

        Capacidade capacidade,

        Coordenada coordenada,

        Morador morador,

        Tipo tipo,

        List<Item> items
) {

    public RecipienteExibicaoDto(Recipiente recipiente) {
        this (
                recipiente.getIdRecipiente(),
                recipiente.getCapacidade(),
                recipiente.getCoordenada(),
                recipiente.getMorador(),
                recipiente.getTipo(),
                recipiente.getItems()
        );
    }
}
