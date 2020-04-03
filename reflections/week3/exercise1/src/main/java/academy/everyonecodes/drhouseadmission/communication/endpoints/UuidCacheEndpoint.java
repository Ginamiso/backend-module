package academy.everyonecodes.drhouseadmission.communication.endpoints;

import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {

    private final UUIDProvider provider;

    public UuidCacheEndpoint(UUIDProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    Map<String, String> getAll() {
        return provider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    String getUUID(@PathVariable String patientName) {
        return provider.findUUID(patientName)
                .orElse(null);
    }
}