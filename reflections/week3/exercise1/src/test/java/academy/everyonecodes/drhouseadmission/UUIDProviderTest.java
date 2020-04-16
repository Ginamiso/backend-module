package academy.everyonecodes.drhouseadmission;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UUIDProviderTest {

    UUIDProvider provider;
    Map<String, String> cache;

    @BeforeEach
    void setup() {
        cache = new HashMap<>();
        provider = new UUIDProvider();
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

    @Test
    void findUUID() {
        Optional<String> oResult = provider.findUUID("unknown");
        assertTrue(oResult.isEmpty());

        String patientName = "gina";
        Patient patient = new Patient(null, patientName, "headache");
        provider.provideUUID(patient);
        String uuid = patient.getUuid();
        oResult = provider.findUUID(patientName);

        assertTrue(oResult.isPresent());

        assertEquals(uuid, oResult.get());
    }
}