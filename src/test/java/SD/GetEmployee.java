package SD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import response.Employees;

import static io.restassured.RestAssured.given;

public class GetEmployee {

    Employees emp = new Employees();
    @Given("I have the Employee Endpoint")
    public void iHaveTheEmployeeEndpoint() {

        RestAssured.baseURI = "http://dummy.restapiexample.com";
         Response resp=given().log().all()
                .when().get("/api/v1/employees")
                .then().assertThat().statusCode(200)
                .extract().response();
        System.out.print(resp);

        emp= resp.as(Employees.class, ObjectMapperType.GSON);

        System.out.println(String.valueOf(emp.getStatus()));



    }

    @When("I hit the endpoint to get the list of employees")
    public void iHitTheEndpointToGetTheListOfEmployees() {
    }

    @Then("Validate that API returns me list of employees")
    public void validateThatAPIReturnsMeListOfEmployees() {
    }

    @And("Status of API is {string}")
    public void statusOfAPIIs(String arg0) {
    }
}
