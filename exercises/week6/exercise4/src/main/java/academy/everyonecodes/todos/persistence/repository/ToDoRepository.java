package academy.everyonecodes.todos.persistence.repository;

import academy.everyonecodes.todos.persistence.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository  extends MongoRepository<ToDo, String> {
}
