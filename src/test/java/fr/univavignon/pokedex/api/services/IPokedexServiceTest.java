package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexServiceTest {
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexService pokedexService;

    @BeforeEach
    void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexService = new IPokedexService(metadataProvider, pokemonFactory);
    }

    @Test
    void testSize() {
        assertEquals(0, pokedexService.size());
        pokedexService.addPokemon(new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50));
        assertEquals(1, pokedexService.size());
    }

    @Test
    void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50);
        int index = pokedexService.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedexService.size());
    }

    @Test
    void testGetPokemonValidIndex() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50);
        pokedexService.addPokemon(pokemon);
        assertEquals(pokemon, pokedexService.getPokemon(0));
    }

    @Test
    void testGetPokemonInvalidIndex() {
        assertThrows(PokedexException.class, () -> pokedexService.getPokemon(1));
    }

    @Test
    void testGetPokemonsUnmodifiableList() {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50);
        pokedexService.addPokemon(pokemon);
        List<Pokemon> pokemons = pokedexService.getPokemons();
        assertEquals(Collections.singletonList(pokemon), pokemons);
        assertThrows(UnsupportedOperationException.class, () -> pokemons.add(pokemon));
    }

    @Test
    void testGetPokemonsSorted() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 600, 120, 4000, 5, 75);
        pokedexService.addPokemon(pokemon1);
        pokedexService.addPokemon(pokemon2);

        List<Pokemon> sortedPokemons = pokedexService.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals(Arrays.asList(pokemon1, pokemon2), sortedPokemons);
    }

    @Test
    void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 500, 100, 3000, 3))
                .thenReturn(new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50));
        Pokemon pokemon = pokedexService.createPokemon(0, 500, 100, 3000, 3);
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(metadata);
        assertEquals(metadata, pokedexService.getPokemonMetadata(0));
    }

}