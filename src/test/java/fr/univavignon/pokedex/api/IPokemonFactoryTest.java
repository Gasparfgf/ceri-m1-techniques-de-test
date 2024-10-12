package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    @DisplayName("testing createPokemonProperties")
    void testCreatePokemonProperties() {
        int index = 133;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        Pokemon pokemon = pokemonFactory.createPokemon(index,cp,hp,dust,candy);

        assertTrue(pokemon.getIndex() > 0);
        assertTrue(pokemon.getCp() > 0);
        assertTrue(pokemon.getHp() > 0);
        assertTrue(pokemon.getDust() > 0);
        assertTrue(pokemon.getCandy() > 0);
    }

    @Test
    @DisplayName("testing createPokemonInstance")
    void testCreatePokemonInstance(){
        Pokemon pokemon = pokemonFactory.createPokemon(133, 613, 64, 4000, 4);

        assertInstanceOf(Pokemon.class, pokemon);
        assertNotNull(pokemon, "Pokemon can not be null");
    }

    @AfterEach
    void tearDown() {
        pokemonFactory = null;
    }

}