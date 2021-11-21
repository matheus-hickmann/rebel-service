package com.rebelservice.service;

import com.rebelservice.errors.exceptions.RebelNotFoundException;
import com.rebelservice.model.Gender;
import com.rebelservice.model.Location;
import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import com.rebelservice.service.rebel.GetRebelByIdService;
import com.rebelservice.utils.RebelUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetRebelByIdServiceTests {

    private GetRebelByIdService service;

    @Mock
    private RebelRepository repository;

    @BeforeEach
    public void init() {
        service = new GetRebelByIdService(repository);
    }
    @Test
    public void givenRebelExists_shouldReturnRebel(){
        //Arrange
        UUID id = UUID.randomUUID();
        Rebel expected = RebelUtil.createRebel(id);

        when(repository.findById(id)).thenReturn(Optional.of(expected));

        //Act
        Rebel response = service.execute(id);

        //Assert
        assertEquals(expected, response, "Should return same rebel");
    }

    @Test
    public void givenRebelDoesNotExists_shouldThrowRebelNotFoundException() {

        //Arrange
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        //Act/Assert
        assertThrows(RebelNotFoundException.class, () -> service.execute(id));

    }
}
