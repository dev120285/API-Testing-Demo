package com.ddas.apitesting.getRequest;



import io.restassured.RestAssured;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.FileInputStream;
import java.io.InputStream;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoapAPITest {

    private String  PATH_CURRENCY_CONVERTER_XML_REQUEST = "/soapRequests/currencyConverterRequest.xml";
    private String  BASE_URI = "http://currencyconverter.kowabunga.net";
    private String  RESOURCE_URI = "/converter.asmx";
    private Integer STATUS_CODE_OK = 200;

    /**
     * @throws Exception
     */
    @Test
    public void testCurrencyConverterSOAPRequest() throws Exception {
        InputStream stream = new ClassPathResource(PATH_CURRENCY_CONVERTER_XML_REQUEST).getInputStream();
        RestAssured.baseURI = BASE_URI;
        Response response = given().header("Content-Type", "text/xml")
                .and().body(IOUtils.toString(stream, "UTF-8"))
                .when()
                .post(RESOURCE_URI)
                .then().statusCode(STATUS_CODE_OK)
                .and().log().all()
                .extract().response();
        XmlPath xmlPath = new XmlPath(response.asString());
        String rate = xmlPath.getString("GetConversionRateResult");
        System.err.println("Conversion Rate is :" +rate);
        long time = response.getTime();
        System.err.println("Completion Time  :" +time);
    }
}
