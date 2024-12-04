package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
import fr.univavignon.pokedex.api.repositories.IPokedex;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPokedexService implements IPokedex {
    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;
    private final List<Pokemon> pokemonList;

    public IPokedexService(
            IPokemonMetadataProvider metadataProvider,
            IPokemonFactory pokemonFactory
    ) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemonList = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size() - 1; //renvoie l'indice du pokemon rajouté
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id > pokemonList.size())
            throw new PokedexException("Le pokemon pour l'indice donné n'existe pas.");
        return pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(new ArrayList<>(pokemonList));
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> listToBeSorted = new ArrayList<>(pokemonList);
        listToBeSorted.sort(order);
        return Collections.unmodifiableList(listToBeSorted);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
