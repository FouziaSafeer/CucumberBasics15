package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class HardCodedExamples {

    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNDc1OTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTA5MDc5MCwidXNlcklkIjoiNTQwMiJ9.g7gaZ7uJ4T7SE3xxs5io5e_HXFzxqxTlWMNl8hVF7xg";
@Test
 public void createEmployee(){
     //prepare the request

     RequestSpecification prepareRequest= given().
             header("Content-Type","application/json").
             header("Authorization",token).body("{\n" +
                     "  \"emp_firstname\": \"Fouzia\",\n" +
                     "  \"emp_lastname\": \"Safeer\",\n" +
                     "  \"emp_middle_name\": \"ms\",\n" +
                     "  \"emp_gender\": \"F\",\n" +
                     "  \"emp_birthday\": \"2023-05-20\",\n" +
                     "  \"emp_status\": \"Confirmed\",\n" +
                     "  \"emp_job_title\": \"QA\"\n" +
                     "}");


     //hitting end point

     Response response =prepareRequest.when().post("/createEmployee.php");


     //verifying the assertion
     response.then().assertThat().statusCode(201);
     //it will print the output in the console
     response.prettyPrint();
 }
}
