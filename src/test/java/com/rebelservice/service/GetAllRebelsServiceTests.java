package com.rebelservice.service;

import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import com.rebelservice.service.rebel.GetAllRebelsService;
import com.rebelservice.utils.RebelUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class GetAllRebelsServiceTests {

    private GetAllRebelsService service;

    @Mock
    private RebelRepository rebelRepository;

    @BeforeEach
    public void init() {
        service = new GetAllRebelsService(rebelRepository);
    }

    @Test
    public void givenThereIsAnyRebelsOnDatabase_shouldReturnEmptyList() {
        //Arrange
        when(rebelRepository.findAll()).thenReturn(Collections.emptyList());

        //Act
        List<Rebel> result = service.execute();

        //Assert
        assertTrue(result.isEmpty());

    }

    @Test
    public void givenExistsRebelsOnDatabase_shouldReturnAllOfThem() {

        //Arrange
        when(rebelRepository.findAll()).thenReturn(Arrays.asList(
                RebelUtil.createRebel(UUID.randomUUID()),
                RebelUtil.createRebel(UUID.randomUUID()),
                RebelUtil.createRebel(UUID.randomUUID())
        ));

        //Act
        List<Rebel> result = service.execute();

        //Assert
        assertEquals(3, result.size());
    }
}
