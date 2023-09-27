package apiconstants;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.List;

import apimodel.employee;



/* created for perform create, read, delete requests the user API*/
public class Endpointmethods {
	
	public static Response createUser()
	{
	 // Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when().post(Routes.Post_URL);
	 /* RestAssured.baseURI = Routes.Post_URL;

	 String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

      Response response = RestAssured.given().header("Content-Type", "application/json")
          .body(requestBody)
          .post();
   
      response.then().statusCode(200);
	  
	  return response;*/
		
		 String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		 Response response = RestAssured.given()
		            .baseUri(Routes.Base_URL)
		            .body(requestBody)
		            .contentType(ContentType.JSON)
		            .when()
		            .post(Routes.CREATE_ENDPOINT)
		            .then()
		            .statusCode(200)
		            .extract()
		            .response();
		return response;
	}

	
	public static Response  DeleteCreatedUser(int newid)
	{
		System.out.println("ID which going to deleted: " + newid);
		 RestAssured.baseURI = Routes.Delete_URL;

	// Response response = (Response) RestAssured.given().basePath("/delete/"+newid).delete().then().statusCode(200);
		         
		 Response response = RestAssured.given().pathParam("id",newid).when()
		          .delete("/delete/{id}");
		 
		 
		 
	/*Response response = RestAssured.given()
	            .baseUri(Routes.Base_URL)
	            .pathParam("id",newid)
	            .when()
	            .delete(Routes.DELETE_ENDPOINT)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();*/

		 response.then().statusCode(200);

		
		return response;
		
		
		
	}

	public static Response  ReadUser()
	{
	  
	  RestAssured.baseURI = Routes.Get_URL;
	  Response response = RestAssured.given().get("/employee/2");
	  return response;
	}
	
	
	public static Response DeleteUser()
	{
	 
	  RestAssured.baseURI = Routes.Delete_URL;

      Response response = given()
          .pathParam("id", "0")
          .when()
          .delete("/delete/{id}");

     
	  return response;
	}
	
	 
		public  static Response getALLemployees()
		{
			
		//RestAssured.baseURI = "	https://dummy.restapiexample.com/api/v1";
			Response response = RestAssured.given()
			.baseUri("https://dummy.restapiexample.com/api/v1") 
			.basePath("/employees")
			.contentType(ContentType.JSON).get();
			return response;
			

		}

}
