package to_do.example.to_do.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import to_do.example.to_do.model.dto.ToDoDTO;
import to_do.example.to_do.model.entities.ToDo;
import to_do.example.to_do.model.repository.ToDoRepository;
import to_do.example.to_do.service.ToDoServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService implements ToDoServiceInterface {

    ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDoDTO createToDo(ToDoDTO toDo) {
        ToDo toDoEntity = new ToDo();
        toDoEntity.setTitle(toDo.getTitle());
        toDoEntity.setDescription(toDo.getDescription());
        toDoEntity.setCompleted(toDo.isCompleted());
        toDoEntity.setDate(toDo.getDate());
        toDoEntity.setCode(toDo.getCode());
        toDoRepository.save(toDoEntity);

        return toDo;
    }

    @Override
    public ToDoDTO updateToDo(ToDoDTO toDo) {
        ToDo toDoEntity = toDoRepository.findByCode((toDo.getCode())).orElseThrow(() -> new EntityNotFoundException("ToDo code" + toDo.getCode() + " not found"));
        toDoEntity.setCode(toDo.getCode());
        toDoEntity.setTitle(toDo.getTitle());
        toDoEntity.setDescription(toDo.getDescription());
        toDoEntity.setCompleted(toDo.isCompleted());
        toDoEntity.setDate(toDo.getDate());
        toDoRepository.save(toDoEntity);
        return toDo;
    }

    @Override
    public boolean deleteToDo(Long code) {
        ToDo toDoEntity = toDoRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("ToDo not found"));
        toDoRepository.delete(toDoEntity);
        return true;
    }

    @Override
    public ToDoDTO getToDoById(Long code) {
        ToDo toDoEntity = toDoRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("ToDo not found"));
        ToDoDTO toDo = new ToDoDTO();
        toDo.setCode(toDoEntity.getCode());
        toDo.setTitle(toDoEntity.getTitle());
        toDo.setDescription(toDoEntity.getDescription());
        toDo.setCompleted(toDoEntity.isCompleted());
        toDo.setDate(toDoEntity.getDate());

        return toDo;
    }

    @Override
    public List<ToDoDTO> getAllToDos() {
        List<ToDo> toDoEntities = toDoRepository.findAll();
        List<ToDoDTO> toDos = new ArrayList<>();
        for (ToDo toDoEntity : toDoEntities) {
            ToDoDTO toDo = new ToDoDTO();
            toDo.setCode(toDoEntity.getCode());
            toDo.setTitle(toDoEntity.getTitle());
            toDo.setDescription(toDoEntity.getDescription());
            toDo.setCompleted(toDoEntity.isCompleted());
            toDo.setDate(toDoEntity.getDate());

            toDos.add(toDo);
        }
        return toDos;
    }
}
