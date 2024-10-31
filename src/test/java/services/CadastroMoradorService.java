package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import model.CoordenadaModel;
import model.MoradorModel;

import static io.restassured.RestAssured.given;

@Getter
public class CadastroMoradorService {

    final MoradorModel morador = new MoradorModel();
    public final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    @Getter
    public Response response;
    String baseUrl = "http://localhost:8080";
    @Getter
    Long idMorador;

    public void setFields(String field, String value) {

        if (morador.getCoordenada() == null) {
            morador.setCoordenada(new CoordenadaModel());
        }

        switch (field) {
            case "nomeMorador" -> morador.setNomeMorador(value);
            case "email" -> morador.setEmail(value);
            case "telefone" -> morador.setTelefone(value);
            case "logradouro" -> morador.setLogradouro(value);
            case "latitude" -> morador.getCoordenada().setLatitude(Double.parseDouble(value));
            case "longitude" -> morador.getCoordenada().setLongitude(Double.parseDouble(value));
            default -> throw new IllegalArgumentException("Invalid field: " + field);
        }
    }

    public void createMorador(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(morador);
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

        if (response.getStatusCode() == 201) {
            idMorador = response.jsonPath().getLong("idMorador");
        } else {
            throw new RuntimeException("Resposta da requisição é nula.");
        }
    }
}
