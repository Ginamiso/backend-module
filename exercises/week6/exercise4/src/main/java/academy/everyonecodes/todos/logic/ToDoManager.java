package academy.everyonecodes.todos.logic;

import academy.everyonecodes.todos.persistence.domain.ToDo;
import academy.everyonecodes.todos.persistence.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public ToDoManager(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> findOne(String id) {
        return toDoRepository.findById(id);
    }

    public ToDo save(ToDo toDo) {
        toDoRepository.save(toDo);
        return toDo;
    }

    public Optional<ToDo> modify(String id) {
        Optional<ToDo> oToDo = toDoRepository.findById(id);
        if (oToDo.isPresent()) {
            ToDo toDo = oToDo.get();
            toDo.setDone(true);
            toDoRepository.save(toDo);
            return Optional.of(toDo);
        }
        return Optional.empty();

    }

    public void delete(String id) {
        toDoRepository.deleteById(id);
    }
}
