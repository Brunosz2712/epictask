package br.com.fiap.epictask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AICreatorService {
    private final AICreatorRepository aiCreatorRepository;

    public AICreatorService(AICreatorRepository aiCreatorRepository) {
        this.aiCreatorRepository = aiCreatorRepository;
    }

    public List<AICreator> getAllAICreators(){
        return  aiCreatorRepository.findAll();
    }

    public AICreator save(AICreator AICreator) {
        return aiCreatorRepository.save(AICreator);
    }
}
