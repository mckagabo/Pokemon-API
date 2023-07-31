package com.petal.petalpokemons.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import com.petal.petalpokemons.repository.PokemonRepository;
import com.petal.petalpokemons.service.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(controllers = PokemonController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class PokemonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private AddPokemonDto addPokemonDtoDto;

    private Pokemon pokemon;
    @BeforeEach
    public void init(){

    }

    @Test
    public void PokemonController_AddPokemon_ReturnCreated ()throws Exception{
        AddPokemonDto addPokemonDto = new AddPokemonDto();
        addPokemonDto.setNoms("Pikachu");
        addPokemonDto.setTypeUn("Electric");
        addPokemonDto.setTypeDeux(null);
        addPokemonDto.setTotals(320);
        addPokemonDto.setHp(35);
        addPokemonDto.setAttacques(55);
        addPokemonDto.setDefences(40);
        addPokemonDto.setSpAtks(50);
        addPokemonDto.setVitesses(90);
        addPokemonDto.setDefVitesses(50);
        addPokemonDto.setGenerations(1);
        addPokemonDto.setLegende(false);
         when(pokemonService.addPokemon(addPokemonDto)).thenReturn(pokemon);
        //given(pokemonService.addPokemon(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));
        ResultActions response=mockMvc.perform(post("/api/pokemons/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addPokemonDto)));
        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void PokemonController_getAllPokemons_returns_page() throws Exception{

        Page<Pokemon> allPokemons= Mockito.mock(Page.class);
        when(pokemonRepository.findAll(Mockito.any(Pageable.class))).thenReturn(allPokemons);
        Page<Pokemon> pokemons=pokemonService.pokemonList(1,10);
        //when(pokemonService.pokemonList(1,10)).thenReturn(allPokemons);

        ResultActions results=mockMvc.perform(get("/api/pokemons")
                .contentType(MediaType.APPLICATION_JSON)
                .param("page","1")
                .param("page", "10"));

        results.andExpect(MockMvcResultMatchers.status().isOk());
               // .andExpect(MockMvcResultMatchers.jsonPath("$.content.size()", CoreMatchers.is(responseDto.getContent().size())));
    }

    @Test
    public void PokemonController_findById_return_pokemon() throws Exception {
        Pokemon pokemon1 = new Pokemon();
        pokemon1.setId(1);
        pokemon1.setNames("Pikachu");
        pokemon1.setTypeOne("Electric");
        pokemon1.setTypeTwo(null);
        pokemon1.setTotals(320);
        pokemon1.setHp(35);
        pokemon1.setAttacks(55);
        pokemon1.setDefences(40);
        pokemon1.setSpAtks(50);
        pokemon1.setSpeeds(90);
        pokemon1.setDefSpeeds(50);
        pokemon1.setGenerations(1);
        pokemon1.setLegend(false);
        AddPokemonDto addPokemonDto = new AddPokemonDto();
        addPokemonDto.setNoms("Pikachu");
        addPokemonDto.setTypeUn("Electric");
        addPokemonDto.setTypeDeux(null);
        addPokemonDto.setTotals(320);
        addPokemonDto.setHp(35);
        addPokemonDto.setAttacques(55);
        addPokemonDto.setDefences(40);
        addPokemonDto.setSpAtks(50);
        addPokemonDto.setVitesses(90);
        addPokemonDto.setDefVitesses(50);
        addPokemonDto.setGenerations(1);
        addPokemonDto.setLegende(false);
       // when(pokemonRepository.findById(1)).thenReturn(Optional.ofNullable(pokemon1));
        when(pokemonService.findById(1)).thenReturn(Optional.ofNullable(pokemon1));
        ResultActions response=mockMvc.perform(get("/api/pokemon/find/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addPokemonDto)));
        response.andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public  void PokemonController_updatePokemon_return_void() throws Exception {
        AddPokemonDto addPokemonDto = new AddPokemonDto();
        addPokemonDto.setNoms("Pikachu");
        addPokemonDto.setTypeUn("Electric");
        addPokemonDto.setTypeDeux(null);
        addPokemonDto.setTotals(320);
        addPokemonDto.setHp(35);
        addPokemonDto.setAttacques(55);
        addPokemonDto.setDefences(40);
        addPokemonDto.setSpAtks(50);
        addPokemonDto.setVitesses(90);
        addPokemonDto.setDefVitesses(50);
        addPokemonDto.setGenerations(1);
        addPokemonDto.setLegende(false);

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setId(1);
        pokemon1.setNames("Pikachu");
        pokemon1.setTypeOne("Electric");
        pokemon1.setTypeTwo(null);
        pokemon1.setTotals(320);
        pokemon1.setHp(35);
        pokemon1.setAttacks(55);
        pokemon1.setDefences(40);
        pokemon1.setSpAtks(50);
        pokemon1.setSpeeds(90);
        pokemon1.setDefSpeeds(50);
        pokemon1.setGenerations(1);
        pokemon1.setLegend(false);
        when(pokemonService.findById(1)).thenReturn(Optional.ofNullable(pokemon1));
        //when(pokemonService.updatePokemon(1,addPokemonDto)).thenReturn(pokemon1);
        ResultActions response=mockMvc.perform(put("/api/pokemons/edit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addPokemonDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
 @Test
 public  void PokemonController_deletePokemon_return_void() throws Exception {
     AddPokemonDto addPokemonDto = new AddPokemonDto();
     addPokemonDto.setNoms("Pikachu");
     addPokemonDto.setTypeUn("Electric");
     addPokemonDto.setTypeDeux(null);
     addPokemonDto.setTotals(320);
     addPokemonDto.setHp(35);
     addPokemonDto.setAttacques(55);
     addPokemonDto.setDefences(40);
     addPokemonDto.setSpAtks(50);
     addPokemonDto.setVitesses(90);
     addPokemonDto.setDefVitesses(50);
     addPokemonDto.setGenerations(1);
     addPokemonDto.setLegende(false);

     Pokemon pokemon1 = new Pokemon();
     pokemon1.setId(1);
     pokemon1.setNames("Pikachu");
     pokemon1.setTypeOne("Electric");
     pokemon1.setTypeTwo(null);
     pokemon1.setTotals(320);
     pokemon1.setHp(35);
     pokemon1.setAttacks(55);
     pokemon1.setDefences(40);
     pokemon1.setSpAtks(50);
     pokemon1.setSpeeds(90);
     pokemon1.setDefSpeeds(50);
     pokemon1.setGenerations(1);
     pokemon1.setLegend(false);
     when(pokemonService.findById(1)).thenReturn(Optional.ofNullable(pokemon1));
     //when(pokemonService.updatePokemon(1,addPokemonDto)).thenReturn(pokemon1);
     ResultActions response=mockMvc.perform(delete("/api/pokemons/delete/1")
             .contentType(MediaType.APPLICATION_JSON)
             .content(objectMapper.writeValueAsString(addPokemonDto)));

     response.andExpect(MockMvcResultMatchers.status().isOk());
 }
}
