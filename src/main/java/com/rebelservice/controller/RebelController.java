package com.rebelservice.controller;

import com.rebelservice.controller.dto.request.LocationRequest;
import com.rebelservice.controller.dto.request.RebelRequest;
import com.rebelservice.controller.dto.response.RebelResponse;
import com.rebelservice.model.Rebel;
import com.rebelservice.service.rebel.GetAllRebelsService;
import com.rebelservice.service.rebel.GetRebelByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    private final GetRebelByIdService getRebelByIdService;
    private final GetAllRebelsService getAllRebelsService;

    @Autowired
    public RebelController(
            GetRebelByIdService getRebelByIdService,
            GetAllRebelsService getAllRebelsService
    ) {
        this.getRebelByIdService = getRebelByIdService;
        this.getAllRebelsService = getAllRebelsService;
    }

    @GetMapping
    public Flux<RebelResponse> getRebels(){
        return Flux.fromIterable(
                getAllRebelsService.execute().stream()
                        .map(RebelResponse::fromEntity)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public Mono<RebelResponse> getById(@PathVariable UUID id) {
        Rebel rebel = getRebelByIdService.execute(id);
        return Mono.just(
            RebelResponse.fromEntity(rebel)
        );
    }

    @PostMapping
    public Mono<RebelResponse> createRebel(RebelRequest rebelRequest) {
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {

    }

    @PatchMapping("/{id}/denounce")
    public Mono denounce(@PathVariable UUID id) {
        return Mono.empty();
    }

    @PatchMapping("/{id}/location")
    public Mono setLocation(@PathVariable UUID id, @RequestBody LocationRequest location) {
        return Mono.empty();
    }
    
}
