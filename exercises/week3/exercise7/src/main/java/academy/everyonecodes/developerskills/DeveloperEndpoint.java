package academy.everyonecodes.developerskills;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperEndpoint {

    private final DeveloperService developerService;

    public DeveloperEndpoint(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    List<Developer> getAll(){
        return developerService.findAll();
    }
    @GetMapping("/skills/{skills}")
    List<Developer> getDevelopers(@PathVariable String skills){
        return developerService.findBy(skills);
    }
}
