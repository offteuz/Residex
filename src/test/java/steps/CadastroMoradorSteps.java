package steps;

import io.cucumber.java.pt.*;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroMoradorService;

import java.util.List;
import java.util.Map;

public class CadastroMoradorSteps {
    CadastroMoradorService cadastroMoradorService = new CadastroMoradorService();
    Long idMorador;

    @Dado("que eu tenha os seguintes dados do morador:")
    public void queEuTenhaOsSeguintesDadosDoMorador(List<Map<String,String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroMoradorService.setFields(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro do morador")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDoMorador(String endPoint) {
        cadastroMoradorService.createMorador(endPoint);
    }

    @Então("o status da resposta de cadastro deve ser {int}")
    public void oStatusDaRespostaDeCadastroDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroMoradorService.response.statusCode());
    }

}
