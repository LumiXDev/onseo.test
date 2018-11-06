package onseo.jerseytest.functional;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import onseo.jerseytest.config.properties.PlaceholderClientProperties;

import onseo.jerseytest.services.SummaryService;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public abstract class AbstractMediumTest {

    @ClassRule
    public static final WireMockClassRule wmClassRule = new WireMockClassRule(wireMockConfig().dynamicPort());

    @Rule
    public final WireMockClassRule wireMockServer = wmClassRule;

    @SpyBean
    private PlaceholderClientProperties placeholderClientPropertiesSpy;

    @LocalServerPort
    private int serverPort;

    @LocalManagementPort
    private int managementPort;

    @Autowired
    private SummaryService summaryService;

    @Before
    public void setup()
    {
        RestAssured.port = serverPort;
        setupSpies();
    }

    private void setupSpies() {

        when(placeholderClientPropertiesSpy.getMockport()).thenReturn(wmClassRule.port());
    }

    protected void runStubProc() {
        wireMockServer.stubFor(WireMock.get("URL")
                .willReturn(aResponse()
                        .withFixedDelay(1000)
                        .withHeader("Content-Type", "application/json")
                        .withBody("BODY_STRING")));
    }
}
