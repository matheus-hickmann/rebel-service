package com.rebelservice.service.rebel;

import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllRebelsService {

    private final RebelRepository rebelRepository;
    @Autowired
    public GetAllRebelsService(RebelRepository rebelRepository) {
        this.rebelRepository = rebelRepository;
    }

    public List<Rebel> execute() {
        return rebelRepository.findAll();
    }
}
