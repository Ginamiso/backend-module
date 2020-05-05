package academy.everyonecodes.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.xmlunit.builder.Input;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidationEndpoint.class)
class ValidationEndpointTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void whenInvalidInputThrowsException() throws Exception{
        Artwork artwork = new Artwork();
        String body = objectMapper.writeValueAsString(artwork);

        mvc.perform(post("/artworks")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());

    }
}