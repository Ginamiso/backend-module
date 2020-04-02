package academy.everyonecodes.jsonplaceholder.communication.endpoint;

import academy.everyonecodes.jsonplaceholder.communication.controller.JsonPlaceholderClient;
import academy.everyonecodes.jsonplaceholder.domain.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {

    private final JsonPlaceholderClient client;

    public PostEndpoint(JsonPlaceholderClient client) {
        this.client = client;
    }


    @GetMapping
    List<Post> getAll() {
        return client.getAll();
    }

    @GetMapping("/{id}")
    Post getOne(@PathVariable int id) {
        return client.getOne(id);
    }

    @PostMapping
    Post postOne(@RequestBody Post post) {
        return client.send(post);
    }

    @PutMapping("/{id}")
    void replaceOne(@PathVariable int id, @RequestBody Post replacement) {
        client.replace(id, replacement);
    }

    @DeleteMapping
    void deleteAll() {
        client.deleteAll();

    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable int id) {
        client.deleteOne(id);
    }

}
