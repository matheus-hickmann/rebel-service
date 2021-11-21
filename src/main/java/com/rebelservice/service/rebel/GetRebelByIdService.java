package com.rebelservice.service.rebel;

import com.rebelservice.errors.exceptions.RebelNotFoundException;
import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetRebelByIdService {

    private final RebelRepository repository;
    @Autowired
    public GetRebelByIdService(
        RebelRepository repository
    ) {

        this.repository = repository;
    }

    public Rebel execute(UUID id) {
        Optional<Rebel> optionalRebel = repository.findById(id);

        return optionalRebel.orElseThrow(RebelNotFoundException::new);
    }
}
