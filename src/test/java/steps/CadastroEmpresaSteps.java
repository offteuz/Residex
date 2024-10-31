package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroEmpresaService;

import java.util.List;
import java.util.Map;

public class CadastroEmpresaSteps {

    CadastroEmpresaService cadastroEmpresaService = new CadastroEmpresaService();

    @Dado("que eu tenha os seguintes dados da empresa:")
    public void queEuTenhaOsSeguintesDadosDaEmpresa(List<Map<String,String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroEmpresaService.setFields(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de empresas")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeEmpresas(String endPoint) {
        cadastroEmpresaService.createEmpresa(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode){
        Assert.assertEquals(statusCode, cadastroEmpresaService.response.statusCode());
    }

    @Então("o status da resposta de  consulta deve ser {int}")
    public void oStatusDaRespostaDeConsultaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroEmpresaService.response.statusCode());
    }

    @Quando("eu envar a requisição GET para o endpoint {string} da consulta de empresa")
    public void euEnvarARequisiçãoGETParaOEndpointDaConsultaDeEmpresa(String endPoint) {
        cadastroEmpresaService.getEmpresas(endPoint);
    }

    @E("o corpo de resposta de erro da api deve retornar {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornar(String message) {
        ErrorMessageModel errorMessageModel = cadastroEmpresaService.gson.fromJson(cadastroEmpresaService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @Dado("que eu recupera o id da empresa")
    public void queEuRecuperaOIdDaEmpresa() {
        cadastroEmpresaService.retrieveIdEmpresa();
    }

    @Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de empresa")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeEmpresa(String endPoint) {
        cadastroEmpresaService.deleteEmpresa(endPoint);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoSelecionado() {

    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contract) {
    }
}
