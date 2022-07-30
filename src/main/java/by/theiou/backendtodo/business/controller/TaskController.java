package by.theiou.backendtodo.business.controller;

import by.theiou.backendtodo.business.entity.Task;
import by.theiou.backendtodo.business.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<Task>> findAll(@RequestBody String email){
        return ResponseEntity.ok(taskService.findAll(email));
    }

    @PostMapping("/id")
    public ResponseEntity<Task> findById(@RequestBody Long id){
        Task task = null;

        try {
            task = taskService.findById(id);
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(task);
    }

    @PutMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task){
        if (task.getId() != null && task.getId() != 0)
            return new ResponseEntity("redundant param: id must be null", HttpStatus.NOT_ACCEPTABLE);

        if (task.getTitle() == null || task.getTitle() == "")
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);

        return ResponseEntity.ok(taskService.add(task));
    }

    @PatchMapping("/update")
    public ResponseEntity update(@RequestBody Task task){
        if (task.getId() == null || task.getId() == 0)
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);

        if (task.getTitle() == null || task.getTitle() == "")
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);

        taskService.update(task);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestBody Long id){
        try {
            taskService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
