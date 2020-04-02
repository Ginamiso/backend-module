package academy.everyonecodes.jsonplaceholder.communication.endpoint;

import academy.everyonecodes.jsonplaceholder.communication.controller.JsonPlaceholderClient;
import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.domain.PostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PostEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    JsonPlaceholderClient client;

    String url = "/posts";

    Post post = new Post("title", "content", 1, 2);

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, PostDTO[].class);

        verify(client).getAll();
    }

    @Test
    void getOne() {
        testRestTemplate.getForObject(url+"/"+1, PostDTO.class);

        verify(client).getOne(1);
    }

    @Test
    void postOne() {
        testRestTemplate.postForObject(url, post, Post.class);

        verify(client).send(post);
    }

    @Test
    void replaceOne() {
        testRestTemplate.put(url + "/1", post);

        verify(client).replace(1, post);
    }

    @Test
    void deleteAll() {
        testRestTemplate.delete(url);

        verify(client).deleteAll();
    }

    @Test
    void deleteOne() {
        testRestTemplate.delete(url + "/0");

        verify(client).deleteOne(0);
    }
}