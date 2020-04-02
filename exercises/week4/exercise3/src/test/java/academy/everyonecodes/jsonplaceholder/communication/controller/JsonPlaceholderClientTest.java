package academy.everyonecodes.jsonplaceholder.communication.controller;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.domain.PostDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class JsonPlaceholderClientTest {

    @Autowired
    JsonPlaceholderClient client;

    @MockBean
    RestTemplate restTemplate;


    @Value("${post.webapp.url}")
    String url;

    @SpyBean
    PostTranslator translator;

    Post post = new Post("title", "content", 1, 2);

    PostDTO postDTO = new PostDTO("title", "content", 1, 2);


    @Test
    void getAll() {
        Mockito.when(restTemplate.getForObject(url, PostDTO[].class))
                .thenReturn(new PostDTO[]{postDTO, postDTO});

        client.getAll();

        Mockito.verify(restTemplate).getForObject(url, PostDTO[].class);
        Mockito.verify(translator, Mockito.times(2)).translateToPost(postDTO);
    }

    @Test
    void getOne() {
        int id = 1;
        Mockito.when(restTemplate.getForObject(url + "/" + id, PostDTO.class))
                .thenReturn(postDTO);

        client.getOne(id);

        Mockito.verify(restTemplate).getForObject(url + "/" + id, PostDTO.class);
        Mockito.verify(translator).translateToPost(postDTO);

    }

    @Test
    void send() {
        Mockito.when(restTemplate.postForObject(url, postDTO, PostDTO.class))
                .thenReturn(postDTO);

        client.send(post);

        Mockito.verify(restTemplate).postForObject(url, postDTO, PostDTO.class);
        Mockito.verify(translator).translateToDTO(post);
        Mockito.verify(translator).translateToPost(postDTO);
    }

    @Test
    void replace() {
        int id = 0;

        client.replace(id, post);

        Mockito.verify(restTemplate).put(url + "/" + id, postDTO);
        Mockito.verify(translator).translateToDTO(post);

    }

    @Test
    void deleteAll() {
        client.deleteAll();

        Mockito.verify(restTemplate).delete(url);
    }

    @Test
    void deleteOne() {
        int id = 1;

        client.deleteOne(id);

        Mockito.verify(restTemplate).delete(url + "/" + id);
    }
}