package RestSteps;

import cucumber.api.java.en.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class RestAssuredBDDStyle {
	@Given("This is Get Call")
	public void this_is_Get_Call() {
	    // Write code here that turns the phrase above into concrete actions
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			log().all().
			body("data[0].first_name", equalTo("Michael")).
			body("data.first_name", hasItems("Michael","Byron")).
			body("data[1].id", equalTo(8));
	}

	@When("This is Post Call")
	public void this_is_Post_Call() {
	    // Write code here that turns the phrase above into concrete actions
baseURI = "https://reqres.in/api";
		
		JSONObject request=new JSONObject();
		request.put("name","morpheus");	
		request.put("job","leader");	

	
		given().
		    header("Content-Type","application/json").
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).		
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}

	@Then("This is Patch Call")
	public void this_is_Patch_Call() {
	    // Write code here that turns the phrase above into concrete actions
baseURI = "https://reqres.in/api";
		
		JSONObject request=new JSONObject();
		request.put("name","Pandu");	
		request.put("job","King");	
		
		given().
	    header("Content-Type","application/json").
	    contentType(ContentType.JSON).
	    accept(ContentType.JSON).		
		body(request.toJSONString()).
	when().
		put("/users/2").
	then().
		statusCode(200).
		log().all();
	}

	@Then("This is Delete Call")
	public void this_is_Delete_Call() {
	    // Write code here that turns the phrase above into concrete actions
baseURI = "https://reqres.in/api";
		
		JSONObject request=new JSONObject();
		request.put("name","Pandu");	
		request.put("job","King");	
		
		given().
	    header("Content-Type","application/json").
	    contentType(ContentType.JSON).
	    accept(ContentType.JSON).		
		body(request.toJSONString()).
	when().
		put("/users/2").
	then().
		statusCode(200).
		log().all();
	}
}
