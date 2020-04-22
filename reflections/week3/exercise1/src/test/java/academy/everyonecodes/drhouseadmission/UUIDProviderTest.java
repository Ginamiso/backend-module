package academy.everyonecodes.drhouseadmission;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UUIDProviderTest {

    UUIDProvider provider;
    Map<String, String> cache;

    @BeforeEach
    void setup() {
        cache = new HashMap<>();
        provider = new UUIDProvider(cache);
    }

    @Test
    void provideUUIDUnknownPatient() {
        Patient patient = new Patient("name", "symptoms");

        provider.provideUUID(patient);

        assertNotNull(patient.getUuid());
    }

    @Test
    void provideUUIDKnowPatient() {
        String name = "name";
        String uuid = "uuid";
        cache.put(name, uuid);
        Patient patient = new Patient(name, "symptoms");
        assertNull(patient.getUuid());

        provider.provideUUID(patient);
        assertEquals(uuid, patient.getUuid());
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findUUID(Optional<String> oExpected, String name) {
        cache.put("name", "uuid");
        cache.put("name1", "uuid1");
        Optional<String> oResult = provider.findUUID(name);
        assertEquals(oExpected, oResult);
    }
    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(Optional.empty(), ""),
                Arguments.of(Optional.of("uuid"), "name"),
                Arguments.of(Optional.of("uuid1"), "name1")
        );
    }
}