package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Morador;

public record RecipienteCadastroDto(

        Long idRecipiente,

        String tipoResiduo,

        double capacidadeAtual,

        double capacidadeMaxima,

        Morador morador,

        Coordenada coordenada
) {
}
