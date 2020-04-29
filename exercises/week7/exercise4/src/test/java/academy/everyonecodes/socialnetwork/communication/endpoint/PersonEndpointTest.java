package academy.everyonecodes.socialnetwork.communication.endpoint;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.logic.SocialMediaService;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    SocialMediaService service;

    String url = "/persons";

    long id1 = 1L;
    long id2 = 2L;

    @Test
    void getAll() {
        restTemplate.getForObject(url, Person[].class);

        verify(service).getAll();
    }

    @Test
    void post() {
        PersonDTO personDTO = new PersonDTO("name");

        restTemplate.postForObject(url, personDTO, PersonDTO.class);

        verify(service).post(personDTO);
    }

    @Test
    void friend() {
        restTemplate.put(url+"/"+id1+"/friend/"+id2, null);

        verify(service).connect(id1, id2);
    }

    @Test
    void unfriend() {
        restTemplate.put(url+"/"+id1+"/unfriend/"+id2, null);

        verify(service).unfriend(id1, id2);
    }
}