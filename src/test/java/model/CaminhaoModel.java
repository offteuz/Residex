package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class CaminhaoModel {

    @Expose(serialize = false)
    private Long idCaminhao;

    @Expose
    private String modelo;

    @Expose
    private String placa;

    @Expose
    private CoordenadaModel coordenada;

    @Expose
    private StatusModel status;

    @Expose(serialize = false)
    private EmpresaModel empresa;
}
