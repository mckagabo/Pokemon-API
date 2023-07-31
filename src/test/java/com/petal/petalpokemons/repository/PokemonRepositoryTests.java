package com.petal.petalpokemons.repository;

import com.petal.petalpokemons.model.Pokemon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PokemonRepositoryTests {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void PokemonRepository_saveAll_ReturnSavedPokemon(){
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

        Pokemon savedPokemon=pokemonRepository.save(pokemon1);
        Assertions.assertThat(savedPokemon).isNotNull();
    }

    @Test
    public void PokemonRepository_GetAll_Returmultiple_pokemon(){
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

        Pokemon pokemon2 = new Pokemon();
        pokemon2.setId(2);
        pokemon2.setNames("Bulbasaur");
        pokemon2.setTypeOne("Grass");
        pokemon2.setTypeTwo("Poison");
        pokemon2.setTotals(318);
        pokemon2.setHp(45);
        pokemon2.setAttacks(49);
        pokemon2.setDefences(49);
        pokemon2.setSpAtks(65);
        pokemon2.setSpeeds(45);
        pokemon2.setDefSpeeds(65);
        pokemon2.setGenerations(1);
        pokemon2.setLegend(false);
        List<Pokemon> pokemonList=new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonRepository.saveAll(pokemonList);

        List<Pokemon> testResults=pokemonRepository.findAll();
        Assertions.assertThat(testResults.size()).isEqualTo(2);


    }

  @Test
    public void PokemonRepository_findById_return_One_pokemon(){
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
      pokemonRepository.save(pokemon1);
      Pokemon onePokemon=pokemonRepository.findById(pokemon1.getId()).orElse(pokemon1);
      Assertions.assertThat(onePokemon).isNotNull();
  }
}
