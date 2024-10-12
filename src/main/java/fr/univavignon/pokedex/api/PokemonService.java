package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;

public class PokemonService implements IPokemonFactory {
    private IPokemonFactory pokemonFactory;

    public PokemonService(IPokemonFactory factory){
        this.pokemonFactory = factory;
    }
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return null;
    }
}
