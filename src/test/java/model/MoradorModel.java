package model;


import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class MoradorModel {

    @Expose(serialize = false)
    private Long idMorador;

    @Expose
    private String nomeMorador;

    @Expose
    private String email;

    @Expose
    private String telefone;

    @Expose
    private String logradouro;

    @Expose
    private CoordenadaModel coordenada;

    @Expose
    private List<RecipienteModel> recipientes;

    @Expose
    private List<NotificacaoModel> notificacoes;

    public MoradorModel() {
        this.coordenada = new CoordenadaModel();
    }
}
