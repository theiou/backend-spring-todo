package by.theiou.backendtodo.business.service;

import by.theiou.backendtodo.business.entity.Task;
import by.theiou.backendtodo.business.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(String email){
        return taskRepository.findByUserEmailOrderByTitleAsc(email);
    }

    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }

    public Task add(Task task){
        return taskRepository.save(task);
    }

    public void update(Task task){
        taskRepository.save(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
