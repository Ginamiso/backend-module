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

    @Test
    void provideUUID() {
        Patient patient = new Patient(null, "gina", "headache");

        provider.provideUUID(patient);

        String uuid1 = patient.getUuid();

        provider.provideUUID(patient);

        String uuid2 = patient.getUuid();

        assertEquals(uuid2, uuid1);
    }

    @Test
    void findUUID() {
        Optional<String> oResult = provider.findUUID("unknown");
        assertTrue(oResult.isEmpty());

        String patientName = "gina";
        Patient patient = new Patient(null, patientName , "headache");
        provider.provideUUID(patient);
        String uuid = patient.getUuid();
        oResult = provider.findUUID(patientName);

        assertTrue(oResult.isPresent());

        assertEquals(uuid, oResult.get());
    }
}