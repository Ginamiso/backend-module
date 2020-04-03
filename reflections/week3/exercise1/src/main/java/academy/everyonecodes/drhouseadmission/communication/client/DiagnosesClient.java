package academy.everyonecodes.drhouseadmission.communication.client;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiagnosesClient {

    private final RestTemplate restTemplate;
    private final String diagnoseUrl;

    public DiagnosesClient(RestTemplate restTemplate,
                           @Value("${diagnoses.url}") String diagnoseUrl) {
        this.restTemplate = restTemplate;
        this.diagnoseUrl = diagnoseUrl;
    }
    public Patient send(Patient patient){
        return restTemplate.postForObject(diagnoseUrl, patient, Patient.class);
    }
}
