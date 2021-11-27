package com.rebelservice.service;

import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import com.rebelservice.service.rebel.CreateRebelService;
import com.rebelservice.utils.RebelUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateRebelServiceTests {

    private CreateRebelService service;

    @Mock
    private RebelRepository rebelRepository;

    @BeforeEach
    public void init() {
        service = new CreateRebelService(rebelRepository);
    }

    @Test
    public void givenReceivesRebel_shouldReturnSaveMethod() {
        //Arrange
        Rebel rebel = RebelUtil.createRebel(null);

        //Act
        service.execute(rebel);

        //Assert
        verify(rebelRepository, times(1)).save(rebel);
    }
}
