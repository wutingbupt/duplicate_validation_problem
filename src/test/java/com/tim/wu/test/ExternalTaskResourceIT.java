package com.tim.wu.test;

import com.tim.wu.test.boundary.external.MyBean;

import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;

public class ExternalTaskResourceIT extends BaseArquillianIT {

    private static final String FACADE_TASK_URI = "v1/hello/";

    @Test
    public void testGetShouldSucceed() {

        MyBean myBean = new MyBean();
        myBean.setHello("hello");
        given().
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON)
                .body(myBean)
                .when()
                .post(taskURL() + FACADE_TASK_URI +"beanvalidator")
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }

}