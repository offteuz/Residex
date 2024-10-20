package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Capacidade;
import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Tipo;

public record RecipienteCadastroDto(

        Long idRecipiente,

        Capacidade capacidade,

        Coordenada coordenada,

        Morador morador,

        Tipo tipo
) {
}
