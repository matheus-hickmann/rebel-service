package com.rebelservice.service.rebel;

import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRebelService {

    private final RebelRepository rebelRepository;

    @Autowired
    public CreateRebelService(RebelRepository rebelRepository) {
        this.rebelRepository = rebelRepository;
    }

    public Rebel execute(Rebel rebelRequest) {
        return rebelRepository.save(rebelRequest);
    }
}
