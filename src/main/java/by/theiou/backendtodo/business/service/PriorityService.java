package by.theiou.backendtodo.business.service;

import by.theiou.backendtodo.business.entity.Priority;
import by.theiou.backendtodo.business.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {
    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> findAll(String email){
        return priorityRepository.findByUserEmailOrderByIdAsc(email);
    }

    public Priority findById(Long id){
        return priorityRepository.findById(id).get();
    }

    public List<Priority> find(String title, String email){
        return priorityRepository.find(title, email);
    }

    public Priority add(Priority priority){
        return priorityRepository.save(priority);
    }

    public void update(Priority priority){
        priorityRepository.save(priority);
    }

    public void deleteById(Long id){
        priorityRepository.deleteById(id);
    }
}
