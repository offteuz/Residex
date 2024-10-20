package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Recipiente;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record NotificacaoCadastroDto(

        Long idNotificacao,

        String descricaoNotificacao,

        Morador morador,

        Recipiente recipiente
) {
}
