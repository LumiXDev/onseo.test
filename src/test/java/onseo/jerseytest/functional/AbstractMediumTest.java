package onseo.jerseytest.functional;

import io.restassured.RestAssured;
import onseo.jerseytest.config.properties.PlaceholderClientProperties;
import onseo.jerseytest.services.SummaryService;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("mediumtest")
public abstract class AbstractMediumTest {

    @ClassRule
    public static final WireMockClassRule wmClassRule = new WireMockClassRule(wireMockConfig().dynamicPort());

    @Rule
    public final WireMockClassRule wireMockServer = wmClassRule;

    @SpyBean
    private PlaceholderClientProperties placeholderClientPropertiesSpy;

    @LocalServerPort
    private int serverPort;

    @Autowired
    private SummaryService summaryService;

    @Before
    public void setup()
    {
        RestAssured.port = serverPort;
        setupSpies();
    }

    private void setupSpies() {

        when(placeholderClientPropertiesSpy.getPort()).thenReturn(wmClassRule.port());
    }
}
