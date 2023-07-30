package com.petal.petalpokemons.service;

import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.dto.PokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PokemonService {
    Page<Pokemon> pokemonList(int pageNo, int pageSize);

    void addPokemon(AddPokemonDto newPokemon);
    void updatePokemon(int id,AddPokemonDto pokemonToUpdate);

    void deletePokemon(Pokemon pokemonToDelete);

    Optional<Pokemon> findById(int id);
}
