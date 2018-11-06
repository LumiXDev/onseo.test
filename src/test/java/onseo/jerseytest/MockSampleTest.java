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
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockSampleTest {
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
