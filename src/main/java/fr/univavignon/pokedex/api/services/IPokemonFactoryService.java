package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;

import java.util.ArrayList;
import java.util.List;

public class IPokemonFactoryService implements IPokemonFactory {
    private List<Pokemon> pokemonList = new ArrayList<>();

    public IPokemonFactoryService(){}

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = new Pokemon(index, "Bulbizarre", 126, 126,
                90, cp, hp, dust, candy, 56);
        pokemonList.add(pokemon);

        return pokemon;
    }
}
