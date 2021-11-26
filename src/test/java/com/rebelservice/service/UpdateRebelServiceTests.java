package com.rebelservice.service;

import com.rebelservice.errors.exceptions.RebelNotFoundException;
import com.rebelservice.model.Rebel;
import com.rebelservice.repository.RebelRepository;
import com.rebelservice.service.rebel.GetRebelByIdService;
import com.rebelservice.service.rebel.UpdateRebelService;
import com.rebelservice.utils.RebelUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateRebelServiceTests {

    private UpdateRebelService service;

    @Mock
    private RebelRepository rebelRepository;

    @Mock
    private GetRebelByIdService getRebelByIdService;

    @BeforeEach
    public void init() {
        service = new UpdateRebelService(rebelRepository, getRebelByIdService);
    }

    @Test
    public void givenRequestRebelDoesNotExists_shouldTryToFindRebelById_thenThrowRebelNotFoundException() {
        //Arrange
        UUID uuid = UUID.randomUUID();
        when(getRebelByIdService.execute(uuid)).thenThrow(new RebelNotFoundException());

        //Act/Assert
        assertThrows(RebelNotFoundException.class, () -> service.execute(uuid, RebelUtil.createRebel(uuid)));
        verify(getRebelByIdService, times(1)).execute(uuid);
    }

    @Test
    public void givenRequestRebelExists_shouldTryToFindRebelById_thenCallSaveWithUpdatedFields() {
        //Arrange
        UUID uuid = UUID.randomUUID();

        Rebel expectedRebel = RebelUtil.createRebel(uuid);
        Rebel requestRebel = RebelUtil.createRebel(uuid);

        requestRebel.setName("This is a updated name");
        when(getRebelByIdService.execute(uuid)).thenReturn(expectedRebel);
        ArgumentCaptor<Rebel> argument = ArgumentCaptor.forClass(Rebel.class);

        //Act
        service.execute(uuid, requestRebel);

        //Assert
        verify(rebelRepository).save(argument.capture());
        assertEquals(requestRebel, argument.getValue());

    }

}
