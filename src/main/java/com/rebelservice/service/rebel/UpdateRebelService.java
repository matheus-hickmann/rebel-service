package com.rebelservice.service.rebel;

import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UpdateRebelService {

    private final RebelRepository rebelRepository;
    private final GetRebelByIdService getRebelByIdService;

    @Autowired
    public UpdateRebelService(RebelRepository rebelRepository, GetRebelByIdService getRebelByIdService) {
        this.rebelRepository = rebelRepository;
        this.getRebelByIdService = getRebelByIdService;
    }


    public Rebel execute(UUID id, Rebel requestRebel) {
        getRebelByIdService.execute(id); //validating

        requestRebel.setId(id);
        return rebelRepository.save(requestRebel);
    }
}
