package com.rebelservice.repository;

import com.rebelservice.model.Rebel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RebelRepository extends JpaRepository<Rebel, UUID> {
}
