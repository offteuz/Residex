package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.CadastroStatusService;

import java.util.List;
import java.util.Map;

public class CadastroStatusSteps {
    CadastroStatusService cadastroStatusService = new CadastroStatusService();
    @Dado("que eu tenha os seguintes dados do status:")
    public void queEuTenhaOsSeguintesDadosDoStatus(List<Map<String,String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroStatusService.setFields(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro do status")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDoStatus(String endPoint) {
        cadastroStatusService.createStatus(endPoint);
    }

    @Então("o status da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroStatusService.response.statusCode());
    }

    @Quando("eu enviar uma requisição GET para o endpoint {string} de consulta do status")
    public void euEnviarUmaRequisiçãoGETParaOEndpointDeConsultaDoStatus(String endPoint) {
        cadastroStatusService.getStatus(endPoint);
    }

    @Então("o status da resposta de consulta deve ser {int}")
    public void oStatusDaRespostaDeConsultaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroStatusService.response.statusCode());
    }
}
