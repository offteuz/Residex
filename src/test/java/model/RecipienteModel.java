package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class RecipienteModel {

    @Expose(serialize = false)
    private Long idRecipiente;

    @Expose
    private String tipoResiduo;

    @Expose
    private double capacidadeAtual;

    @Expose
    private double capacidadeMaxima;

    @Expose
    private Long idMorador;

    @Expose
    private CoordenadaModel coordenada;
}
