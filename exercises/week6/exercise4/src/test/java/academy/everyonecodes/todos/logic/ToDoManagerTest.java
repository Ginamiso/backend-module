package academy.everyonecodes.todos.logic;

import academy.everyonecodes.todos.persistence.domain.ToDo;
import academy.everyonecodes.todos.persistence.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository toDoRepository;

    ToDo toDo = new ToDo("title", false);
    String id = "test id";

    @Test
    void findAll() {
        toDoManager.findAll();

        verify(toDoRepository).findAll();
    }

    @Test
    void findOne() {
        toDoManager.findOne(id);

        verify(toDoRepository).findById(id);
    }

    @Test
    void save() {
        assertNull(toDo.getId());

        toDoManager.save(toDo);

        verify(toDoRepository).save(toDo);
    }

    @Test
    void modify() {
        ToDo done = new ToDo("title", true);

        when(toDoRepository.findById(id))
                .thenReturn(Optional.of(toDo));
        when(toDoRepository.save(done))
                .thenReturn(done);

        Optional<ToDo> oResult = toDoManager.modify(id);
        Optional<ToDo> oExpected = Optional.of(done);

        assertEquals(oExpected, oResult);
        verify(toDoRepository).findById(id);
        verify(toDoRepository).save(done);

    }

    @Test
    void delete() {
        toDoManager.delete(id);

        verify(toDoRepository).deleteById(id);
    }
}