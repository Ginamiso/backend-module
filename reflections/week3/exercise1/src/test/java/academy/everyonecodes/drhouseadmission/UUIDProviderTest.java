package academy.everyonecodes.drhouseadmission;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UUIDProviderTest {

    UUIDProvider provider = new UUIDProvider();

    @Test
    void provideUUID() {
        Patient patient = new Patient("gina", "", "headache");
        provider.provideUUID(patient);
        String uuid = provider.getCacheSnapshot().get("gina");
        int result = provider.getCacheSnapshot().size();

        assertEquals(1, result);
    }

    @Test
    void findUUID() {
        Patient patient = new Patient("gina", "123", "headache");
        provider.provideUUID(patient);
        Optional<String> result = provider.findUUID("gina");

        assertEquals(Optional.of("123"), result);
    }
}