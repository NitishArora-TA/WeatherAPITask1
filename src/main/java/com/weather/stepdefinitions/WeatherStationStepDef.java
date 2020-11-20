package com.weather.stepdefinitions;

import com.weather.Utils.PayloadValues;
import com.weather.Utils.WeatherStationTest;
import com.weather.helper.Logger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherStationStepDef extends WeatherStationTest {


    org.apache.log4j.Logger log = Logger.getLogger(WeatherStationStepDef.class);


    @Given("^User added the Payload values \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void addPayloadValues(String arg0, String arg1, float arg2, float arg3, int arg4) throws Throwable {
        PayloadValues.addNewStation(arg0,arg1,arg2,arg3,arg4);
    }

    @When("^User sends Post request to service with Invalid api Key$")
    public void userCallsAPIWithHttpRequestWithInvalidApiKey() throws Throwable {
        submitPostRequestWithInvalidKey();
    }

    @When("^User sends Post request to service with Valid api Key$")
    public void userCallsAPIWithHttpRequest() throws Throwable {
        submitPostRequestWithValidKey();
    }

    @Then("^API response header should have status code as \"([^\"]*)\"$")
    public void theAPIShouldReturnResponse(int responsecode) {
        validateResponseStatus(responsecode);
    }

    @Given("^User sends valid get request to the service$")
    public void aValidGetRequestForStationsSubmitted() {
        submitValidGetRequest();
    }

    @Then("^API Response should contain values \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void responseShouldContain(String arg0, String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        validateGetResponseValues(arg0,arg1,arg2,arg3,arg4);

    }



}
