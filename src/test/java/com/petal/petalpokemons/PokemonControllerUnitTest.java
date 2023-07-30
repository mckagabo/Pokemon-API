package com.petal.petalpokemons;

import com.petal.petalpokemons.controller.PokemonController;
import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import com.petal.petalpokemons.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class PokemonControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

   @MockBean
    PokemonService pokemonService;


    @InjectMocks
    private PokemonController pokemonController;

//    @Test
//    public void testGetPokemonList() throws Exception{
//        // Mock the behavior of pokemonService.pokemonList method
//        Page<Pokemon> mockPage = new PageImpl<>(Arrays.asList(new Pokemon(), new Pokemon()));
//        when(pokemonService.pokemonList(anyInt(), anyInt())).thenReturn(mockPage);
//
//        // Perform the controller method invocation
//        ResponseEntity<Page<Pokemon>> responseEntity = pokemonController.getAllPokemons(1, 10);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertEquals(2, responseEntity.getBody().getContent().size());
//    }
//
//    @Test
//    public void testEditPokemon_Success() {
//        int id = 1;
//        AddPokemonDto editedPokemon = new AddPokemonDto();
//        // Mock the behavior of findById method
//        Pokemon existingPokemon = new Pokemon();
//        when(pokemonService.findById(id)).thenReturn(Optional.of(existingPokemon));
//
//        ResponseEntity<?> responseEntity = pokemonController.editPokemon(id, editedPokemon);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Successfully Edited", responseEntity.getBody());
//        verify(pokemonService).updatePokemon(id, editedPokemon);
//    }
//
//    @Test
//    public void testEditPokemon_PokemonNotFound() {
//        int id = 1;
//        AddPokemonDto editedPokemon = new AddPokemonDto();
//        // Mock the behavior of findById method when Pokemon is not found
//        when(pokemonService.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<?> responseEntity = pokemonController.editPokemon(id, editedPokemon);
//
//        // Assert the response
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Pokemon doesn't exist", responseEntity.getBody());
//        verify(pokemonService, never()).updatePokemon(anyInt(), any(AddPokemonDto.class));
//    }
//
//    @Test
//    public void testAddPokemon_Success() {
//        AddPokemonDto newPokemon = new AddPokemonDto();
//        // Mock the behavior of addPokemon method
//        doNothing().when(pokemonService).addPokemon(newPokemon);
//
//        ResponseEntity<?> responseEntity = pokemonController.addPokemon(newPokemon);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Successfully added", responseEntity.getBody());
//    }
//
//    @Test
//    public void testAddPokemon_Failure() {
//        AddPokemonDto newPokemon = new AddPokemonDto();
//        // Mock the behavior of addPokemon method when an exception is thrown
//        doThrow(new RuntimeException("Error adding Pokemon")).when(pokemonService).addPokemon(newPokemon);
//
//        ResponseEntity<?> responseEntity = pokemonController.addPokemon(newPokemon);
//
//        // Assert the response
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        assertEquals("SorryError adding Pokemon", responseEntity.getBody());
//    }
//
//    @Test
//    public void testDeletePokemon_Success() {
//        int id = 1;
//        // Mock the behavior of findById method
//        Pokemon existingPokemon = new Pokemon();
//        existingPokemon.setId(id);
//        existingPokemon.setNames("Bulbasaur");
//        when(pokemonService.findById(id)).thenReturn(Optional.of(existingPokemon));
//
//        ResponseEntity<?> responseEntity = pokemonController.deletePokemon(id);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Bulbasaur was succesfully deleted", responseEntity.getBody());
//        verify(pokemonService).deletePokemon(existingPokemon);
//    }
//
//    @Test
//    public void testDeletePokemon_PokemonNotFound() {
//        int id = 1;
//        // Mock the behavior of findById method when Pokemon is not found
//        when(pokemonService.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<?> responseEntity = pokemonController.deletePokemon(id);
//
//        // Assert the response
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Pokemon Not found", responseEntity.getBody());
//        verify(pokemonService, never()).deletePokemon(any(Pokemon.class));
//    }
}
