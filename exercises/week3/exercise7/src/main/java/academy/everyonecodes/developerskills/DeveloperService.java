package academy.everyonecodes.developerskills;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {

    private List<Developer> developers;

    void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    List<Developer> findAll() {
        return developers;
    }

    List<Developer> findBy(String skills) {
        List<String> parsedSkills = List.of(skills.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(parsedSkills))
                .collect(Collectors.toList());
    }
}
