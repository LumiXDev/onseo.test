/*
package onseo.jerseytest;


import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;
import onseo.jerseytest.services.SummaryService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
//import static sun.nio.cs.Surrogate.is;
//import static wiremock.org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WireMockSampleTest {

    */
/*WireMockServer server = new WireMockServer();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().dynamicPort());*//*



    //Mocks
    @Mock
    private PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClient;
    @Mock
    private PlaceholderClient<CommentEntity> commentEntityPlaceholderClientMock;
    @Mock
    private PlaceholderClient<UserEntity> userEntityPlaceholderClientMock;

    private SummaryService summaryService;

    @Before
    public void setup()
    {

        when(toDoEntityPlaceholderClient.getEntity(Matchers.anyInt(), any(), any())).thenReturn(generateStubEntity());
        summaryService = new SummaryService(toDoEntityPlaceholderClient, commentEntityPlaceholderClientMock, userEntityPlaceholderClientMock);


    }

    @Test
    public void urlToSampleString() {
        System.out.println(summaryService.getToDo(111));
        //Sample mocker call
        //With different parameters

        */
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
                .willReturn(aResponse()));*//*


        */
/*stubFor(get(urlEqualTo("/Sample/"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("This is a sample jersey string I created.")));*//*


        //Assertion samples:

        //assertThat(client.get("/url/thing").statusCode(), is(200));
        //assertThat(client.get("/url/thing/params").statusCode(), is(404));
    }


    private ToDoEntity generateStubEntity()
    {
        ToDoEntity result = new ToDoEntity();
        result.setId(100);
        result.setUserId(200);
        result.setTitle("Some temporary title.");
        result.setCompleted(true);

        return result;
    }
}
*/
