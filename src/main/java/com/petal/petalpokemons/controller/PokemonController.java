package com.petal.petalpokemons.controller;

import com.petal.petalpokemons.dto.AddPokemonDto;
import com.petal.petalpokemons.model.Pokemon;
import com.petal.petalpokemons.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/pokemons")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Page<Pokemon>> getAllPokemons(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "10") int size){
        Page<Pokemon> pokemons=pokemonService.pokemonList(page,size);
        return ResponseEntity.ok(pokemons);
    }

   @GetMapping("/hello")
    public ResponseEntity<?> greeting(){
        return ResponseEntity.ok().body("***** WELCOME TO POKEMON API ****** \n POKEMONS ROCK!");
    }
    @PostMapping("/add")
    @ResponseBody
    public  ResponseEntity<?> addPokemon(@RequestBody AddPokemonDto newPokemon){
        try{
            pokemonService.addPokemon(newPokemon);
            return ResponseEntity.ok("Successfully added");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Sorry"+e.getMessage());
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editPokemon(@PathVariable int id,@RequestBody AddPokemonDto editedPokemon){
       Optional<Pokemon> isPokemon=pokemonService.findById(id);
       Pokemon pokemon=isPokemon.orElseGet(() -> null);
       if(pokemon!=null){
           pokemonService.updatePokemon(id,editedPokemon);
           return ResponseEntity.ok("Successfully Edited");
       }else{
           return ResponseEntity.status(404).body("Pokemon doesn't exist");
       }

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletePokemon(@PathVariable int id){
        Optional<Pokemon> isPokemon=pokemonService.findById(id);
        Pokemon pokemon=isPokemon.orElseGet(()->null);
        if(pokemon!=null){
            pokemonService.deletePokemon(pokemon);
            return ResponseEntity.ok().body(pokemon.getNames()+" was succesfully deleted");
        }else{
            return  ResponseEntity.status(404).body("Pokemon Not found");
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findPokemon(@PathVariable int id){
        Optional<Pokemon> isPokemon=pokemonService.findById(id);
        Pokemon pokemon=isPokemon.orElse(null);
        if(pokemon!=null){
            AddPokemonDto response=this.fromPokemon(pokemon);
            return ResponseEntity.ok().body(response);
        }else {
            return ResponseEntity.status(404).body("Pokemon Not found");
        }
    }


    public AddPokemonDto fromPokemon(Pokemon pokemon) {
        AddPokemonDto addPokemonDto = new AddPokemonDto();
        addPokemonDto.setNoms(pokemon.getNames());
        addPokemonDto.setTypeUn(pokemon.getTypeOne());
        addPokemonDto.setTypeDeux(pokemon.getTypeTwo());
        addPokemonDto.setTotals(pokemon.getTotals());
        addPokemonDto.setHp(pokemon.getHp());
        addPokemonDto.setAttacques(pokemon.getAttacks());
        addPokemonDto.setDefences(pokemon.getDefences());
        addPokemonDto.setSpAtks(pokemon.getSpAtks());
        addPokemonDto.setDefVitesses(pokemon.getDefSpeeds());
        addPokemonDto.setVitesses(pokemon.getSpeeds()); // Changed from speeds to defVitesses
        addPokemonDto.setGenerations(pokemon.getGenerations());
        addPokemonDto.setLegende(pokemon.isLegend()); // Changed from legend to Legende
        return addPokemonDto;
    }
}
