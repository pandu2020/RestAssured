   package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;  

@RunWith(Cucumber.class)
@CucumberOptions
		(
		   features =".//Features/",					//  Customers.features Login.feature",   
   //    glue="stepDefinitions",                    // UI Steps 
      glue={"RestSteps"},						// Rest APi Steps
				   
		//   dryRun=false,        // false  dryRun=true,  -- If we true it will check all steps are there or not - it won't run
       //    monochrome=true,
         //  plugin = { "pretty" ,   "html:test-output" },
        	        plugin = "json:target/jsonReports/cucumber-report.json",
        	        
        	        		

           tags  = {"@RestRegression"}   // @sanity5  RestAPIGetCall  @RestApiPostCall  RestAPIGetCall @RestAPIGetCall  @RestRegression
		)
public class TestRun {

}


//  features ={".//Features/Login.feature",".//Features/Customers.feature"}, -- Two run Mutiple
//  features =".//Features/", - To Run All	