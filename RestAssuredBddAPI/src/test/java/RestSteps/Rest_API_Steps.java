package RestSteps;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;  // We use one only because need to intergrate with reports 


public class Rest_API_Steps  {
	 
	Response response;
	RequestSpecification httpRequet;
	ResponseBody body;
	
	@Given("Launch the Base URL")
	public void launch_the_Base_URL() {
		
	  RestAssured.baseURI = "https://bookstore.toolsqa.com";
	  
	}

	@When("User Provide Service Details & Provide the Method Name with All Inputs")
	public void user_Provide_Service_Details() {
		
		 httpRequet = RestAssured.given();
		 response = httpRequet.request(Method.GET,"/BookStore/v1/Books");
		
	}

	@Then("Print The Response Body")
	public void print_The_Response_Body() {
		int statusCode = response.getStatusCode();
		System.out.println(" Response Status Code is "+statusCode);
	}

	@Then("Validdate Status Codes Header And Response Body")
	public void validdate_Status_Codes() {
		
	//	System.out.println(response.getBody());
	//	System.out.println(response.getBody().prettyPrint());
		
		body = response.getBody();
	
		body.prettyPeek();   // It will print Status Code Heander & Json Response 
		
		body.prettyPrint();  // It will print Only Json Response 
		
		Headers header = response.getHeaders();
		
		System.out.println(" Reponse Headers "+header);
		
		System.out.println(" Header content-type is "+header.getValue("content-type"));
		
		System.out.println(" Header content-type is "+response.getHeader("content-type"));
		
		int countOfHeader = header.asList().size();
		
		System.out.println("  countOfHeader is "+header);
		
		// Print reponse body As String
				System.out.println(" Response body is "+body.asString());
				
				String responseBodyAsString = response.getBody().asString();
				
				List<Books> allbooks= response.jsonPath().getList("books", Books.class);
				for(Books book:allbooks)
					System.out.println(book.getTitle());
				
				List<String> allisbn= response.jsonPath().getList("books.isbn");
				for(String book:allisbn)
					System.out.println(book);
					
				
				Books Arraybooks[]= response.jsonPath().getObject("books", Books[].class);
				for(Books book:Arraybooks)
					System.out.println(book.getTitle());
				
				
			
		Assert.assertTrue(responseBodyAsString.contains("books"));
		Assert.assertEquals(200,response.getStatusCode());  // (Expected,Actual)  -- We can check status code 
		//Assert.assertEquals("application/json",header.getValue("content-type"));  // (Expected,Actual)  -- we can check header values
	
	    
		
		
	
	}  
	
}
