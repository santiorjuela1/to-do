package to_do.example.to_do.service;


import to_do.example.to_do.model.dto.ToDoDTO;

import java.util.List;

public interface ToDoServiceInterface {
    ToDoDTO createToDo(ToDoDTO toDo);
    ToDoDTO updateToDo(ToDoDTO toDo);
    boolean deleteToDo(Long code);
    ToDoDTO getToDoById(Long code);
    List<ToDoDTO> getAllToDos();
}
