package StepDef_Package;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class demo_stepdef {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	private static String ENDPOINT_GET_BOOK_BY_ISBN = "https://demo.api-platform.com/books/";
	private static String ENDPOINT_URL = "https://reqres.in/api/users/11";
	
	@Given("^a book exist with an ISBN of (.*)$")
	public void a_book_exist_with_an_isbn(String isbn) {
		request = given().param("q", "isbn:" + isbn);
	}
	
	@When("^a user retrieves the book by ISBN$")
	public void a_user_retrieves_the_book_by_ISBN() {
		response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
		System.out.println("response :" +response.prettyPrint());
	}
	
    @Then("^the status of code is (\\d+)$")
    public void the_status_of_code(int statusCode) {
    	json = response.then().statusCode(statusCode);
    }
    
    @And("^the response includes the following$")
    public void the_response_includes(Map<String,String> responseFields) {
    	for(Map.Entry<String, String> field : responseFields.entrySet()) {
    		if (StringUtils.isNumeric(field.getValue())) {
    		json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
    	}
    	else {
    		json.body(field.getKey(), equalTo(field.getValue()));
    	  }
       }
    }
    
    /*@And("^response include the following in any order$")
    public void response_include_the_following(Map<String, String> responseFields) {
     	for (Map.Entry<String, String> field : responseFields.entrySet()) {
    		if (StringUtils.isNumeric(field.getValue())) {
    			json.body(field.getKey(), containsInAnyOrder(field.getValue()));
    		}
    		else {
    			json.body(field.getKey(), containsInAnyOrder(field.getValue()));
    		}
    	}
    }*/
    
    @When("^user send the data in json format$") 
    	public void user_send_the_data_in_json_format () {
             response =  given().
    	     accept(ContentType.JSON).
    	     contentType(ContentType.JSON).
    	     body("{\"name\" : \"Aabha\" , \"job\" : \"leader\"}").
    	     when().
    	     post(ENDPOINT_URL);
    }
    
    @Then("^status of code is (\\d+)$")
    public void status_of_code_is (int statusCode) {
    	json = response.then().statusCode(statusCode);
    	System.out.println("response2 :" +response.prettyPrint());
    	
    }
    
    @When("^User send the new data$")
    public void User_send_the_new_data() {
     response = given().
    		 accept(ContentType.JSON).
    		 contentType(ContentType.JSON).
    		 body("{\"name\" : \"Ashish\" , \"job\" : \"leader\"}").
    		 when().
    		 put(ENDPOINT_URL);
     }
     @Then("^the status code is (\\d+)$")
     public void the_status_code_is(int statusCode) {
    	 json = response.then().statusCode(statusCode);
    	 System.out.println("response3 :" +response.prettyPrint());
   }
     
     @When("^User delete the existing entry$")
     public void User_delete_the_existing_entry() {
    	 response = given().delete(ENDPOINT_URL);
    }
   /* @Then("^the status code is (\\d+)$")
     public void the_status_code(int statusCode) {
    	 json = response.then().statusCode(statusCode);
     }*/
    
}    
    
    
    
    
    
    
    
    
    
    
    
    
  