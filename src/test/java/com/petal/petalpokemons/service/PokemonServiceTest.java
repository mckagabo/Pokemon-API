package com.petal.petalpokemons.service;

import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import com.petal.petalpokemons.repository.PokemonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    @Test
    public void PokemonService_Create_Pokemon_Returns_Pokemon(){
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
   when(pokemonRepository.save(Mockito.any(Pokemon.class))).thenReturn(pokemon1);
   Pokemon savedPokemon=pokemonService.addPokemon(addPokemonDto);
        Assertions.assertThat(savedPokemon).isNotNull();

    }
    @Test
    public void PokemonService_GetAllPokemon_Returns_Page(){
        Page<Pokemon> pokemons= Mockito.mock(Page.class);
        when(pokemonRepository.findAll(Mockito.any(Pageable.class))).thenReturn(pokemons);
        Page<Pokemon> pokemonResults=pokemonService.pokemonList(1,10);
        Assertions.assertThat(pokemonResults).isNotNull();
    }

    @Test
    public void PokemonService_findById_Returns_onePokemon(){
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
        when(pokemonRepository.findById(1)).thenReturn(Optional.ofNullable(pokemon1));
        Pokemon pokemon=pokemonService.findById(1).orElseGet(null);
        Assertions.assertThat(pokemon).isNotNull();
    }



    @Test
    public void PokemonService_updatePokemon_returnPokemon(){
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
        when(pokemonRepository.save(Mockito.any(Pokemon.class))).thenReturn(pokemon1);
        Pokemon updatedPokemon=pokemonService.updatePokemon(1,addPokemonDto);
        Assertions.assertThat(updatedPokemon).isNotNull();
    }
    @Test
    public void PokemonService_deletePokemon_returns_void(){
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
        //when(pokemonRepository.findById(pokemon1.getId())).thenReturn(Optional.ofNullable(pokemon1));
        assertAll(()-> pokemonService.deletePokemon(pokemon1));
    }
}
