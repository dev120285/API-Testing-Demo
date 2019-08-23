package com.ddas.apitesting.getRequest;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAPITest {

    public static String REST_API_URL = "https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1";
    public static String TIME_SUFFIX = " seconds";
    private static final Logger logger = LoggerFactory.getLogger(RestAPITest.class);
    private static Response response ;

    @BeforeClass
    public  static void setUpResponse() throws Exception {
        response = get(REST_API_URL);
    }

    /**
     *
     */
    @Test
    public void testResponseCode() {
        int statusCode = response.getStatusCode();
        logger.info("===============Status Code returned============  {}", statusCode);
        System.err.println("Returned Staus Code is {} " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    /**
     *
     */
    @Test
    public void testResponseTime() {
        long time = response.getTime();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        logger.info("===============Time Executed for Response generation ============ {}", seconds ,TIME_SUFFIX);
        System.err.println("Completion time  {} " + seconds + TIME_SUFFIX);
        Assert.assertNotNull(seconds);
    }
}
