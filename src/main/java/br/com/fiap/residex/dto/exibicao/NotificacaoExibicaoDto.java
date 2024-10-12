package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Notificacao;
import br.com.fiap.residex.model.Recipiente;

public record NotificacaoExibicaoDto(

        Long idNotificacao,

        String descricaoNotificacao,

        Morador morador,

        Recipiente recipiente
) {

    public NotificacaoExibicaoDto(Notificacao notificacao) {
        this(
                notificacao.getIdNotificacao(),
                notificacao.getDescricaoNotificacao(),
                notificacao.getMorador(),
                notificacao.getRecipiente()
        );
    }
}
