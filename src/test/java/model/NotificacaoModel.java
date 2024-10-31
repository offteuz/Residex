package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class NotificacaoModel {

    @Expose(serialize = false)
    private Long idNotificacao;

    @Expose
    private String descricaoNotificacao;

    @Expose
    private Long idMorador;

    @Expose
    private Long idRecipiente;
}
