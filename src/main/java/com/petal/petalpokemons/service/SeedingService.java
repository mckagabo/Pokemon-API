package com.petal.petalpokemons.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.petal.petalpokemons.model.Pokemon;
import com.petal.petalpokemons.repository.PokemonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeedingService {

    @Autowired
    PokemonRepository pokemonRepo;

    @PostConstruct
    public void seedDb(){
        List<Pokemon> pokemonList=pokemonRepo.findAll();
        List<Pokemon> pokemons=new ArrayList<>();
        if(pokemonList.isEmpty()){
          try{
              ClassPathResource resource = new ClassPathResource("pokemon.csv");
              CSVReader reader = new CSVReader(new FileReader(resource.getFile()));
              String[] headers = reader.readNext(); // Read headers (skip the first line)
              String[] nextLine;
              while((nextLine = reader.readNext()) != null){
                  Pokemon pokemon=new Pokemon();
                  pokemon.setId(Integer.parseInt(nextLine[0]));
                  pokemon.setNames(nextLine[1]);
                  pokemon.setTypeOne(nextLine[2]);
                  pokemon.setTypeTwo(nextLine[3]);
                  pokemon.setTotals(Integer.parseInt(nextLine[4]));
                  pokemon.setHp(Integer.parseInt(nextLine[5]));
                  pokemon.setAttacks(Integer.parseInt(nextLine[6]));
                  pokemon.setDefences(Integer.parseInt(nextLine[7]));
                  pokemon.setSpAtks(Integer.parseInt(nextLine[8]));
                  pokemon.setDefSpeeds(Integer.parseInt(nextLine[9]));
                  pokemon.setSpeeds(Integer.parseInt(nextLine[10]));
                  pokemon.setGenerations(Integer.parseInt(nextLine[11]));
                  pokemon.setLegend(Boolean.parseBoolean(nextLine[12]));
                  pokemons.add(pokemon);
              }
              pokemonRepo.saveAll(pokemons);
          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          } catch (IOException e) {
              throw new RuntimeException(e);
          } catch (CsvValidationException e) {
              throw new RuntimeException(e);
          }
        }

    }

}
