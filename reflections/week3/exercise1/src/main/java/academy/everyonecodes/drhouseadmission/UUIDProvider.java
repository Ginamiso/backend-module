package academy.everyonecodes.drhouseadmission;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDProvider {

    private Map<String, String> cache = new HashMap<>();

    public void provideUUID(Patient patient) {
        if (cache.containsKey(patient.getName())) {
            patient.setUuid(cache.get(patient.getName()));
        }
        String uuid = UUID.randomUUID().toString();
        patient.setUuid(uuid);
        cache.put(patient.getName(), patient.getUuid());
    }

    public Map<String, String> getCacheSnapshot() {
        return cache;
    }

    public Optional<String> findUUID(String name) {
        if (cache.containsKey(name)) {
            return Optional.of(cache.get(name));
        }
        return Optional.empty();
    }
}
