package to_do.example.to_do.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import to_do.example.to_do.model.dto.ToDoDTO;
import to_do.example.to_do.service.ToDoServiceInterface;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoController {

    private final ToDoServiceInterface toDoService;

    public ToDoController(ToDoServiceInterface toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/create")
    public ResponseEntity<ToDoDTO> createToDo(@RequestBody ToDoDTO toDo) {
        return ResponseEntity.ok(toDoService.createToDo(toDo));
    }

    @PutMapping("/update")
    public ResponseEntity<ToDoDTO> updateToDo(@RequestBody ToDoDTO toDo) {
        return ResponseEntity.ok(toDoService.updateToDo(toDo));
    }


    @DeleteMapping("/delete/{code}")
    ResponseEntity<Boolean> deleteToDo(@PathVariable("code") Long code) {
        return ResponseEntity.ok(toDoService.deleteToDo(code));
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<ToDoDTO> getToDoById(@PathVariable("code") Long code) {
        return ResponseEntity.ok(toDoService.getToDoById(code));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ToDoDTO>> getAllToDos() {
        return ResponseEntity.ok(toDoService.getAllToDos());
    }
}
