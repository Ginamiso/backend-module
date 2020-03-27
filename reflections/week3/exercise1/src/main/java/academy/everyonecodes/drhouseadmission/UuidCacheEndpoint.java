package academy.everyonecodes.drhouseadmission;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {

    private final UUIDProvider provider;

    public UuidCacheEndpoint(UUIDProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    String getPatients() {
        Set<String> names = provider.getCacheSnapshot().keySet();
        Collection<String> uuids = provider.getCacheSnapshot().values();
        String result = "";
        for (String name : names) {
            for (String uuid : uuids) {
                result = name + ":" + uuid;

            }
        }
        return result;
    }

    @GetMapping("/{patientName}")
    String getUUID(@PathVariable String patientName) {
        return provider.findUUID(patientName).orElse(null);
    }
}