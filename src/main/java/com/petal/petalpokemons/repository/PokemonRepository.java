package com.petal.petalpokemons.repository;

import com.petal.petalpokemons.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {

}
