package onseo.jerseytest.functional;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class SampleMediumTest extends AbstractMediumTest {

    //someProc() - what am I creating stub for, again?

    private void getToDoEntityStub(Object someParams) {
        wireMockServer.stubFor(someProc().willReturn(aResponse()
                .withHeader("Content-Type", "application-json")
                .withStatus(200)
                .withBody("SOME_BODY_STRING")
        ));
    }
}
