package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Recipiente;

import java.util.List;

public record MoradorExibicaoDto(

        Long idMorador,

        String nomeMorador,

        String email,

        String telefone,

        String logradouro,

        Coordenada coordenada
) {

    public MoradorExibicaoDto (Morador morador) {
        this(
                morador.getIdMorador(),
                morador.getNomeMorador(),
                morador.getEmail(),
                morador.getTelefone(),
                morador.getLogradouro(),
                morador.getCoordenada()
        );
    }
}
