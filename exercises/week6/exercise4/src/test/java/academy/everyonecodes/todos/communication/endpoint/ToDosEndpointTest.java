package academy.everyonecodes.todos.communication.endpoint;

import academy.everyonecodes.todos.logic.ToDoManager;
import academy.everyonecodes.todos.persistence.domain.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ToDoManager toDoManager;

    String url = "/todos";

    String id = "test id";

    ToDo toDo = new ToDo("title", true);

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, ToDo[].class);

        verify(toDoManager).findAll();
    }

    @Test
    void getBy() {
        testRestTemplate.getForObject(url + "/" + id, ToDo.class);

        verify(toDoManager).findOne(id);
    }

    @Test
    void post() {
        testRestTemplate.postForObject(url, toDo, ToDo.class);

        verify(toDoManager).save(toDo);
    }

    @Test
    void put() {
        testRestTemplate.put(url + "/" + id + "/done", toDo);

        verify(toDoManager).modify(id);
    }

    @Test
    void delete() {
        testRestTemplate.delete(url + "/" + id);

        verify(toDoManager).delete(id);
    }
}