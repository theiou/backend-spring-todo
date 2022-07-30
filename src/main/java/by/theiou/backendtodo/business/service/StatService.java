package by.theiou.backendtodo.business.service;

import by.theiou.backendtodo.business.entity.Stat;
import by.theiou.backendtodo.business.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    private final StatRepository statRepository;

    @Autowired
    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public Stat findStat(String email){
        return statRepository.findByUserEmail(email);
    }
}
