package model;

import br.com.fiap.residex.model.Caminhao;
import com.google.gson.annotations.Expose;
import lombok.Data;
import java.util.List;

@Data
public class EmpresaModel {

    @Expose(serialize = false)
    private Long idEmpresa;

    @Expose
    private String cnpj;

    @Expose
    private String razaoSocial;

    @Expose
    private CoordenadaModel coordenada;

    @Expose
    private List<Caminhao> caminhoes;

    public EmpresaModel() {
        this.coordenada = new CoordenadaModel();
    }
}

