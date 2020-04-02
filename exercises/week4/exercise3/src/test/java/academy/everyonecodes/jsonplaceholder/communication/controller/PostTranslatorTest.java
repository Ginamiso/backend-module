package academy.everyonecodes.jsonplaceholder.communication.controller;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.domain.PostDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTranslatorTest {

    PostTranslator translator = new PostTranslator();

    Post post = new Post("title", "content", 1, 2);
    PostDTO postDTO = new PostDTO("title", "content", 1, 2);

    @Test
    void translateToDTO() {
        PostDTO result = translator.translateToDTO(post);

        assertEquals(postDTO, result);
    }

    @Test
    void translateToPost() {

        Post result = translator.translateToPost(postDTO);

        assertEquals(post, result);
    }
}