package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CoordenadaModel;
import model.EmpresaModel;

import static io.restassured.RestAssured.given;

public class CadastroEmpresaService {

    final EmpresaModel empresa = new EmpresaModel();
    public final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    public Response response;
    String baseUrl = "http://localhost:8080";
    Long idEmpresa;

    public void setFields(String field, String value){

        if(empresa.getCoordenada() == null ){
            empresa.setCoordenada(new CoordenadaModel());
        }

        switch (field){
            case "cnpj" -> empresa.setCnpj(value);
            case "razaoSocial" -> empresa.setRazaoSocial(value);
            case "latitude" -> empresa.getCoordenada().setLatitude(Double.parseDouble(value));
            case "longitude" -> empresa.getCoordenada().setLongitude(Double.parseDouble(value));
            default -> throw new IllegalArgumentException("Invalid field" + field);
        }
    }

    public void createEmpresa(String endPoint){
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(empresa);
        System.out.println("Corpo da req" + bodyToSend);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public void getEmpresas(String endPoint) {
        String url = baseUrl + endPoint;
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(gson.fromJson(response.getBody().asString(), Object.class));

        System.out.println("Corpo da resposta: " + prettyJson);
    }

    public void retrieveIdEmpresa(){
        idEmpresa = gson.fromJson(response.jsonPath().prettify(), EmpresaModel.class).getIdEmpresa();
    }

    public void deleteEmpresa(String endPoint) {
        String url = String.format("%s%s/%d", baseUrl, endPoint, idEmpresa);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}
