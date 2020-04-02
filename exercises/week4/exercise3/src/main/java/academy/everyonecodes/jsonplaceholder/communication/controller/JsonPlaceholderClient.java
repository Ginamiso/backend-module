package academy.everyonecodes.jsonplaceholder.communication.controller;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.domain.PostDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class JsonPlaceholderClient {

    private final RestTemplate restTemplate;
    private final PostTranslator postTranslator;
    private final String url;

    public JsonPlaceholderClient(RestTemplate restTemplate, PostTranslator postTranslator,
                                 @Value("${post.webapp.url}") String url) {
        this.restTemplate = restTemplate;
        this.postTranslator = postTranslator;
        this.url = url;
    }

    public List<Post> getAll() {
        PostDTO[] response = restTemplate.getForObject(url, PostDTO[].class);
        return Stream.of(Objects.requireNonNull(response))
                .map(postTranslator::translateToPost)
                .collect(Collectors.toList());
    }

    public Post getOne(int id) {
        String urlOne = url + "/" + id;
        PostDTO postDTO = restTemplate.getForObject(urlOne, PostDTO.class);
        return postTranslator.translateToPost(Objects.requireNonNull(postDTO));
    }

    public Post send(Post post) {
        PostDTO postDTO = postTranslator.translateToDTO(post);
        PostDTO response = restTemplate.postForObject(url, postDTO, PostDTO.class);
        return postTranslator.translateToPost(response);
    }

    public Post replace(int id, Post replacement) {
        String urlOriginal = url + "/" + id;
        PostDTO postDTO = postTranslator.translateToDTO(replacement);
        restTemplate.put(urlOriginal, postDTO);
        return replacement;

    }
    public void deleteAll(){
        restTemplate.delete(url);
    }

    public void deleteOne(int id) {
        restTemplate.delete(url + "/" + id);
    }
}
