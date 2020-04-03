package academy.everyonecodes.drhousediagnoses.configuration;

import academy.everyonecodes.drhousediagnoses.domain.Diagnosis;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("available")
public class DiagnosisConfiguration {

    private List<Diagnosis> diagnoses;

    void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
    @Bean
    List<Diagnosis> diagnoses(){
        return diagnoses;
    }
}
