package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.index.qual.LessThan;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxNzExOTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTIxNDM5NCwidXNlcklkIjoiNTQwMiJ9.N_Z09yFFrfaxu_tRxgk4yWm_paFzI4ykbusX6pfEpKM";
    static String employee_id;

    @Test
    public void getCreatedEmplopyee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);


        //hitting the end point
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);
        String tempEmpID = response.jsonPath().getString("employee.employee_id");
// we have two employee id global and local
        Assert.assertEquals(employee_id, tempEmpID);
        // employee_id=tempEmpID;

    }

    @Test
    public void createEmployee() {
        //prepare the request

        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Fouzia\",\n" +
                        "  \"emp_lastname\": \"Safeer\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-05-20\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");


        //hitting end point

        Response response = prepareRequest.when().post("/createEmployee.php");


        //verifying the assertion
        response.then().assertThat().statusCode(201);
        //it will print the output in the console
        response.prettyPrint();

        employee_id = response.jsonPath().getString("Employee.employee_id");

//veryfying first name in the response body
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Fouzia"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Safeer"));
        //verify the response header
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println(employee_id);
        System.out.println("My test case is passed");
    }
    //in homework creat a method to get all employees status and job title

    @Test
    public void getAllEmployeeStatus() {
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token);
        //for response
        //hitting end point
        Response response = prepareRequest.when().get("employeementStatus.php");
        //printing response
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.time() < 900);
    }

    @Test
    public void getAllEmployeeJobTitle() {
        //prepare request
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token);
        //for response
        //hitting end point
        Response response = prepareRequest.when().get("/jobTitle.php");
        response.prettyPrint();
        //verifying the assertion
        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.time() < 800);

    }
    @Test
    public void cupdateEmployee() {
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Fizzycool\",\n" +
                        "  \"emp_lastname\": \"fouzia\",\n" +
                        "  \"emp_middle_name\": \"M\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-05-20\",\n" +
                        "  \"emp_status\": \"internship\",\n" +
                        "  \"emp_job_title\": \"Marketing_Manager\"\n" +
                        "}");

        //hitting the endpoind
        Response response = prepareRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    response.prettyPrint();

    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        //if you want to verify the body of response using hamcrest mathers







    }


}
