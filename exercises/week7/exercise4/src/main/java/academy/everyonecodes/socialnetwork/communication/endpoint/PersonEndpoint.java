package academy.everyonecodes.socialnetwork.communication.endpoint;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.logic.SocialMediaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonEndpoint {

    private final SocialMediaService service;

    public PersonEndpoint(SocialMediaService service) {
        this.service = service;
    }
    @GetMapping
    List<PersonDTO> getAll(){
        return service.getAll();
    }
    @PostMapping
    PersonDTO post(@RequestBody PersonDTO personDTO){
        return service.post(personDTO);
    }
    @PutMapping("/{id1}/friend/{id2}")
    void friend(@PathVariable Long id1, @PathVariable Long id2){
        service.connect(id1, id2);
    }
    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1, @PathVariable Long id2){
        service.unfriend(id1, id2);
    }
}
