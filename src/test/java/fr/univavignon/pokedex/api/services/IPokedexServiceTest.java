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
    private Pokemon pokemon2;
    private Pokemon pokemon;
    private int index;

    @BeforeEach
    void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexService = new IPokedexService(metadataProvider, pokemonFactory);

        pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 500, 100, 3000, 3, 50);
        pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 600, 120, 4000, 5, 75);
        index = pokedexService.addPokemon(pokemon);
    }

    @Test
    void testSize() {
        assertEquals(1, pokedexService.size());
        pokedexService.addPokemon(pokemon2);
        assertEquals(2, pokedexService.size());
    }

    @Test
    void testAddPokemon() {
        assertEquals(0, index);
        assertEquals(1, pokedexService.size());
    }

    @Test
    void testGetPokemonValidIndex() throws PokedexException {
        assertEquals(pokemon, pokedexService.getPokemon(0));
    }

}