package onseo.jerseytest.functional;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.http.ContentType;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class SampleMediumTest extends AbstractMediumTest {

    private static final String TODO_RESPONSE_JSON_SAMPLE_ID10 = "{\n" +
            "  \"userId\": 1,\n" +
            "  \"id\": 10,\n" +
            "  \"title\": \"title\",\n" +
            "  \"completed\": true\n" +
            "}";

    private static final String COMMENT_RESPONSE_JSON_SAMPLE_ID10 = "{\n" +
            "  \"postId\": 2,\n" +
            "  \"id\": 10,\n" +
            "  \"name\": \"eaque et deleniti atque tenetur ut quo ut\",\n" +
            "  \"email\": \"Carmen_Keeling@caroline.name\",\n" +
            "  \"body\": \"voluptate iusto quis nobis reprehenderit ipsum amet nulla\\nquia quas dolores velit et non\\naut quia necessitatibus\\nnostrum quaerat nulla et accusamus nisi facilis\"\n" +
            "}";

    private static final String USER_RESPONSE_JSON_TEMPLATE_ID10 = "{\n" +
            "  \"id\": 10,\n" +
            "  \"name\": \"Clementina DuBuque\",\n" +
            "  \"username\": \"Moriah.Stanton\",\n" +
            "  \"email\": \"Rey.Padberg@karina.biz\",\n" +
            "  \"address\": {\n" +
            "    \"street\": \"Kattie Turnpike\",\n" +
            "    \"suite\": \"Suite 198\",\n" +
            "    \"city\": \"Lebsackbury\",\n" +
            "    \"zipcode\": \"31428-2261\",\n" +
            "    \"geo\": {\n" +
            "      \"lat\": \"-38.2386\",\n" +
            "      \"lng\": \"57.2232\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"phone\": \"024-648-3804\",\n" +
            "  \"website\": \"ambrose.net\",\n" +
            "  \"company\": {\n" +
            "    \"name\": \"Hoeger LLC\",\n" +
            "    \"catchPhrase\": \"Centralized empowering task-force\",\n" +
            "    \"bs\": \"target end-to-end models\"\n" +
            "  }\n" +
            "}";

    @Test
    public void testSampleEndpointServicesSuccess() {

        //Let's say I hard-code 10 into ID
        registerStubs(10);

        given()
                .header("Content-Type", "application/json")
                .when().get("/Sample/summary/10").then()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .assertThat().body(notNullValue());
    }
    private void registerStubs(int id)
    {
        getToDoEntityStub(id);
        getCommentEntityStub(id);
        getUserEntityStub(id);
    }

    private void getToDoEntityStub(int id) {
        wireMockServer.stubFor(WireMock.get("/todos/" +  id).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withStatus(200)
                .withBody(TODO_RESPONSE_JSON_SAMPLE_ID10)
        ));
    }

    private void getCommentEntityStub(int id){
        wireMockServer.stubFor(WireMock.get("/comments/" +id).willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBody(COMMENT_RESPONSE_JSON_SAMPLE_ID10)
        ));
    }

    private void getUserEntityStub(int id){
        wireMockServer.stubFor(WireMock.get("/users/" + id).willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withBody(USER_RESPONSE_JSON_TEMPLATE_ID10)
        .withStatus(200)
        ));

    }
}
