package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;

import java.util.HashMap;
import java.util.Map;

public class IPokemonFactoryService implements IPokemonFactory {
    private Map<Integer, Pokemon> pokemonMap;

    public IPokemonFactoryService() {
        this.pokemonMap = new HashMap<>();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        final Pokemon pokemon = new Pokemon(index, "Bulbizarre", 126, 126,
                90, cp, hp, dust, candy, 56);
        pokemonMap.put(index, pokemon);

        return pokemon;
    }
}
