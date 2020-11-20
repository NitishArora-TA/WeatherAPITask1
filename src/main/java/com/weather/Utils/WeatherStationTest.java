package com.weather.Utils;
import static io.restassured.RestAssured.*;
import com.weather.Pojo.WeatherAPI.WeatherStationRequest;
import com.weather.enums.Context;
import com.weather.helper.ScenarioContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;

/**
 *
 * @author Nitish Arora
 *
 */

public class WeatherStationTest extends WeatherStationRequest {
    ScenarioContext scenarioContext = new ScenarioContext();

    public void submitPostRequestWithValidKey(){
        Response response = given()
                .baseUri(Constants.BaseURL)
                .basePath(Constants.AddNewStations)
                .queryParam("appid", Constants.ApiKey)
                .contentType("application/json")
                .body(PayloadValues.postAddNewStation())
                .when()
                .post();
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
        scenarioContext.setContext(Context.Status_Code,response.statusCode() );

    }
    public void submitPostRequestWithInvalidKey() {
        Response response = given()
                .baseUri(Constants.BaseURL)
                .basePath(Constants.AddNewStations)
                .queryParam("appid", "InvalidAPIKey")
                .contentType("application/json")
                .body(PayloadValues.postAddNewStation())
                .when()
                .post();
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
        scenarioContext.setContext(Context.Status_Code,response.statusCode() );

    }
    public void submitValidGetRequest(){
        Response response = given()
                .baseUri(Constants.BaseURL)
                .basePath(Constants.AddNewStations)
                .queryParam("appid", Constants.ApiKey)
                .contentType("application/json")
                .when()
                .get();
        System.out.println(response.getBody().asString());

        System.out.println(response.statusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String body = response.getBody().asString();
        scenarioContext.setContext(Context.Status_Code,response.statusCode());
        scenarioContext.setContext(Context.Response_body,body);


    }
    public void validateResponseStatus(int expectedCode) {
            String actualResponseCode = String.valueOf(scenarioContext.getContext(Context.Status_Code));
            Assert.assertEquals(expectedCode,Integer.parseInt(actualResponseCode),"API Response Code validated");

        }
    public void validateGetResponseValues(String external_id, String name, String latitude, String longitude, String altitude) throws JSONException {
        String actualResponseBody = String.valueOf(scenarioContext.getContext(Context.Response_body));
        System.out.println("Response Output "+actualResponseBody);

       Assert.assertEquals(actualResponseBody.contains("id"), true, "Valid Response Id Value");

    }

}
