package com.petal.petalpokemons;

import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class PokemonControllerIntegrationTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void testGetAllPokemons() {
//        ResponseEntity<Page<Pokemon>> responseEntity = restTemplate.exchange(
//                "/pokemons", HttpMethod.GET, null, new ParameterizedTypeReference<Page<Pokemon>>() {
//                });
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//
//    }
//
//    @Test
//    public void testEditPokemon_Success() {
//        int id = 1;
//        AddPokemonDto editedPokemon = new AddPokemonDto();
//        // Send a PUT request to the edit/{id} endpoint
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "/edit/" + id, HttpMethod.PUT, new HttpEntity<>(editedPokemon), String.class);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Successfully Edited", responseEntity.getBody());
//    }
//
//    @Test
//    public void testEditPokemon_PokemonNotFound() {
//        int id = 1;
//        AddPokemonDto editedPokemon = new AddPokemonDto();
//        // Send a PUT request to the edit/{id} endpoint with an unknown id
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "/edit/" + id, HttpMethod.PUT, new HttpEntity<>(editedPokemon), String.class);
//
//        // Assert the response
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Pokemon doesn't exist", responseEntity.getBody());
//    }
//
//    @Test
//    public void testAddPokemon_Success() {
//        AddPokemonDto newPokemon = new AddPokemonDto();
//        // Send a POST request to the /add endpoint
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/add", newPokemon, String.class);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Successfully added", responseEntity.getBody());
//    }
//
//    @Test
//    public void testAddPokemon_Failure() {
//        AddPokemonDto newPokemon = new AddPokemonDto();
//        // Send a POST request to the /add endpoint with an invalid request body
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/add", null, String.class);
//
//        // Assert the response
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        assertTrue(responseEntity.getBody().contains("Sorry"));
//    }
//
//    @Test
//    public void testDeletePokemon_Success() {
//        int id = 1;
//        // Send a DELETE request to the delete/{id} endpoint
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "/delete/" + id, HttpMethod.DELETE, null, String.class);
//
//        // Assert the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Bulbasaur was succesfully deleted", responseEntity.getBody());
//    }
//
//    @Test
//    public void testDeletePokemon_PokemonNotFound() {
//        int id = 1;
//        // Send a DELETE request to the delete/{id} endpoint with an unknown id
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "/delete/" + id, HttpMethod.DELETE, null, String.class);
//
//        // Assert the response
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Pokemon Not found", responseEntity.getBody());
//    }
}
