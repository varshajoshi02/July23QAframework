package apitests;

import static org.testng.Assert.assertFalse;
import com.github.javafaker.Faker;

import apiconstants.Endpointmethods;
import apiconstants.Waitconstants;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apimodel.employee;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;


public class MainTest extends Endpointmethods{

public static int newid;


@Test(enabled=false)
	public void testGetAllUser1()
	{
		
		Response response= Endpointmethods.getALLemployees();
		response.then()
		.statusCode(200)
		.body("status", equalTo("success"));

		Assert.assertEquals(response.getStatusCode(), 200);

		String responseBody = response.prettyPrint();
		System.out.println("Response Body: " + responseBody);
		   Waitconstants.waitTest();
	}
@Test(priority=1)
	public static void testPostUser2() throws InterruptedException
	{
	   
	    Response response= Endpointmethods.createUser();
	    String responseBody = response.prettyPrint();
		System.out.println("Response Body: " + responseBody);
        Assert.assertEquals("success", response.path("status"));

        Assert.assertEquals("test", response.path("data.name"));
        Assert.assertEquals("123", response.path("data.salary"));
        Assert.assertEquals("23", response.path("data.age"));

        newid = response.path("data.id");
        System.out.println("ID: " + newid);
        Waitconstants.waitTest();
	   
/*
	@Test(dependsOnMethods = "testPostUser2")
	public static void testDeleteCreatedUser( int newid)
	{ */
    
   Response response1= Endpointmethods.DeleteCreatedUser( newid);
	    response1 .then()
        .assertThat()
        .statusCode(200)
        .body("status", equalTo("success"))
        .body("data", equalTo(newid))
        .extract()
        .response();

String message = response.path("message");
System.out.println("Response message: " + message);
	}
	   // Assert.assertEquals("success", response1.path("status"));
       // Assert.assertEquals(newid, response1.path("data"));
	  /*  employee emp= ((ResponseBodyExtractionOptions) response).as(employee.class);
        Assert.assertEquals("success", emp.getStatus());
        Assert.assertEquals(newid, ((employee) emp.getData()).getId());

        System.out.println("Message: " + emp.getMessage());
return;
}*/



@Test(enabled=false)
public void testDeleteuser4()
{
	
	Response response= Endpointmethods.DeleteUser();
	String responseBody = response.getBody().asString();
    System.out.println("Response Body is =>  " + responseBody);

    response.then().statusCode(400);

    response.then().body("status", equalTo("error"));


    String message = response.jsonPath().getString("message");
    System.out.println("Message: " + message);
    Waitconstants.waitTest();
	
}

@Test(enabled=false)
	public void testGetUser5()
	{
		Response response= Endpointmethods.ReadUser();
		String responseBody = response.prettyPrint();
		System.out.println("Response Body: " + responseBody);
		
	response.then().assertThat().
        statusCode(200).
        and().
        contentType(ContentType.JSON).
        and().
        body("data.employee_name", equalTo("Garrett Winters")).
        body("data.employee_salary", equalTo(170750)).
        body("data.employee_age", equalTo(63));
	   Waitconstants.waitTest();
	        }
		
	
	


}
