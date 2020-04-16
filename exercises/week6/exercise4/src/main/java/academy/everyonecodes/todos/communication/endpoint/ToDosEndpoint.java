package academy.everyonecodes.todos.communication.endpoint;

import academy.everyonecodes.todos.logic.ToDoManager;
import academy.everyonecodes.todos.persistence.domain.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {

    private final ToDoManager toDoManager;

    public ToDosEndpoint(ToDoManager toDoManager) {
        this.toDoManager = toDoManager;
    }

    @GetMapping
    List<ToDo> getAll() {
        return toDoManager.findAll();
    }

    @GetMapping("/{id}")
    ToDo getBy(@PathVariable String id) {
        return toDoManager.findOne(id)
                .orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return toDoManager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo put(@PathVariable String id) {
        return toDoManager.modify(id)
                .orElse(null);

    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        toDoManager.delete(id);
    }
}
