package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.StatusModel;

import static io.restassured.RestAssured.given;

public class CadastroStatusService {

    final StatusModel statusModel = new StatusModel();
    public final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    public Response response;
    String baseUrl = "http://localhost:8080";

    public void setFields(String field, String value) {
        switch (field) {
            case "descricaoStatus":
                statusModel.setDescricaoStatus(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }
    public void createStatus(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(statusModel);
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

    public void getStatus(String endPoint) {
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
        String prettyJson = gson.toJson(gson.toJson(response.getBody().asString(), Object.class));

        System.out.println("Corpo da resp" + prettyJson);
    }
}
