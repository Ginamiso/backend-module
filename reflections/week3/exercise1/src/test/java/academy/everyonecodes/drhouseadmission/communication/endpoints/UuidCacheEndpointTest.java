package academy.everyonecodes.drhouseadmission.communication.endpoints;

import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UuidCacheEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    UUIDProvider uuidProvider;

    String url = "/uuids";

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, HashMap.class);

        verify(uuidProvider).getCacheSnapshot();
    }

    @Test
    void getUUID() {
        testRestTemplate.getForObject(url+"/name", String.class);

        verify(uuidProvider).findUUID("name");
    }
}