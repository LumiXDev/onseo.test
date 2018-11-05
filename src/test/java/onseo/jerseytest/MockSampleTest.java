package onseo.jerseytest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static sun.nio.cs.Surrogate.is;
//import static wiremock.org.hamcrest.MatcherAssert.assertThat;

public class MockSampleTest {

    WireMockServer server = new WireMockServer();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().dynamicPort());

    @Test
    public void urlToSampleString() {

        //Sample mocker call
        //With different parameters

        /*stubFor(any(urlPathEqualTo("/everything"))
                .withHeader("Accept", containing("xml"))
                .withCookie("session", matching(".*12345.*"))
                .withQueryParam("search_term", equalTo("WireMock"))
                .withBasicAuth("jeff@example.com", "jeffteenjefftyjeff")
                .withRequestBody(equalToXml("<search-results />"))
                .withRequestBody(matchingXPath("//search-results"))
                .withMultipartRequestBody(
                        aMultipart()
                                .withName("info")
                                .withHeader("Content-Type", containing("charset"))
                )
                .willReturn(aResponse()));*/

        stubFor(get(urlEqualTo("/Sample/"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("This is a sample jersey string I created.")));

        //Assertion samples:

        //assertThat(client.get("/url/thing").statusCode(), is(200));
        //assertThat(client.get("/url/thing/params").statusCode(), is(404));
    }
}
