package onseo.jerseytest;

import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.AddressEntity;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.CompanyEntity;
import onseo.jerseytest.infrastructure.dao.models.GeoEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;
import onseo.jerseytest.services.SummaryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockSampleTest {
    //Mocks
    @Mock
    private PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClientMock;
    @Mock
    private PlaceholderClient<CommentEntity> commentEntityPlaceholderClientMock;
    @Mock
    private PlaceholderClient<UserEntity> userEntityPlaceholderClientMock;

    private SummaryService summaryService;

    @Before
    public void setup() throws InterruptedException
    {
        when(toDoEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(generateToDoStubEntity());
        when(commentEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(generateCommentStubEntity());
        when(userEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(generateUserStubEntity());
        summaryService = new SummaryService(toDoEntityPlaceholderClientMock, commentEntityPlaceholderClientMock, userEntityPlaceholderClientMock);
    }

    @Test
    public void urlToSampleString() {
        System.out.println(summaryService.getToDo(10));
    }

    @Test
    public void urlToSampleGetSummary() throws InterruptedException {

        System.out.println(summaryService.getEntityAsync(10, "/todos/", ToDoEntity.class));
        System.out.println(summaryService.getEntityAsync(8, "/comments/", CommentEntity.class));
        System.out.println(summaryService.getEntityAsync(5, "/users/", UserEntity.class));
        System.out.println(summaryService.getSummaryAsync(5));
    }

    private ToDoEntity generateToDoStubEntity() throws InterruptedException
    {
        ToDoEntity result = new ToDoEntity();
        result.setId(100);
        result.setUserId(200);
        result.setTitle("Some temporary title.");
        result.setCompleted(true);

        Thread.sleep(500);
        return result;
    }

    private CommentEntity generateCommentStubEntity() throws InterruptedException
    {
        CommentEntity result = new CommentEntity();
        result.setId(8);
        result.setPostId(16);
        result.setName("Some stub comment name");
        result.setBody("Some stub comment body.");
        result.setEmail("someemail@stubdomain.org");

        Thread.sleep(300);
        return result;
    }

    private UserEntity generateUserStubEntity() throws InterruptedException
    {
        UserEntity res = new UserEntity();

        res.setId(100);
        res.setName("Some stub name");
        res.setEmail("someemail@stub.org");
        res.setUsername("Some stub uSeRnAMe");
        res.setWebsite("https://somewebsite.com");
        res.setPhone("1-800-STUBPHN");


        AddressEntity addr = new AddressEntity();
        addr.setCity("New Stubton");
        addr.setStreet("Stub ave");
        addr.setSuite("5-star stub");
        addr.setZipcode("10101010");

        GeoEntity geo = new GeoEntity();
        geo.setLat(100);
        geo.setLng(100);
        addr.setGeo(geo);

        res.setAddress(addr);

        CompanyEntity company = new CompanyEntity();

        company.setName("Some stub Inc.");
        company.setCatchPhrase("Some stub catch phrase!");
        company.setBs("Some stub BS.");

        res.setCompany(company);

        Thread.sleep(400);
        return res;
    }
}
