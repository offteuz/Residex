package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Notificacao;
import br.com.fiap.residex.model.Recipiente;

public record NotificacaoCadastroDto(

        Long idNotificacao,

        String descricaoNotificacao,

        Morador morador,

        Recipiente recipiente
) {
}
