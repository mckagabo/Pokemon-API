package com.petal.petalpokemons.service;

import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.dto.PokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import com.petal.petalpokemons.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    PokemonRepository pokemonRepo;
    @Override
    public Page<Pokemon> pokemonList(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        Page<Pokemon> paginatedPokemons=pokemonRepo.findAll(pageable);
        return paginatedPokemons;
    }

    @Override
    public Pokemon addPokemon(AddPokemonDto newPokemon) {
        Pokemon addedPokemon=null;
        try {
           Pokemon transformedPokemon=this.fromAddPokemonDto(newPokemon);
           addedPokemon= pokemonRepo.save(transformedPokemon);
        }catch (Exception e){
          e.printStackTrace();
        }
        return addedPokemon;
    }

    @Override
    public Pokemon updatePokemon(int id,AddPokemonDto pokemonToUpdate) {
         Pokemon updatedPokemon=null;
        try{
          Pokemon transformedPokemon=this.fromAddPokemonDto(pokemonToUpdate);
          transformedPokemon.setId(id);
          updatedPokemon=pokemonRepo.save(transformedPokemon);
        }catch (Exception e){
            e.printStackTrace();
        }
        return updatedPokemon;
    }

    @Override
    public void deletePokemon(Pokemon pokemonToDelete) {
         pokemonRepo.delete(pokemonToDelete);

    }

    @Override
    public Optional<Pokemon> findById(int id) {
        return pokemonRepo.findById(id);
    }



        private Pokemon fromAddPokemonDto(AddPokemonDto addPokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNames(addPokemonDto.getNoms());
        pokemon.setTypeOne(addPokemonDto.getTypeUn());
        pokemon.setTypeTwo(addPokemonDto.getTypeDeux());
        pokemon.setTotals(addPokemonDto.getTotals());
        pokemon.setHp(addPokemonDto.getHp());
        pokemon.setAttacks(addPokemonDto.getAttacques());
        pokemon.setDefences(addPokemonDto.getDefences());
        pokemon.setSpAtks(addPokemonDto.getSpAtks());
        pokemon.setSpeeds(addPokemonDto.getVitesses()); // Changed from defVitesses to speeds
        pokemon.setDefSpeeds(addPokemonDto.getDefVitesses());
        pokemon.setGenerations(addPokemonDto.getGenerations());
        pokemon.setLegend(addPokemonDto.isLegende()); // Changed from Legende to legend
        return pokemon;
    }

}
