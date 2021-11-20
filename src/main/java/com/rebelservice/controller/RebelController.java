package com.rebelservice.controller;

import com.rebelservice.model.Location;
import com.rebelservice.model.Rebel;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    @GetMapping
    public Flux<Rebel> getRebels(){
        return Flux.empty();
    }

    @GetMapping("/{id}")
    public Mono<Rebel> getById(@PathVariable UUID id) {
        return Mono.empty();
    }

    @PostMapping
    public Mono<Rebel> createRebel(Rebel rebelRequest) {
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
    public Mono setLocation(@PathVariable UUID id, @RequestBody Location location) {
        return Mono.empty();
    }
    
}
