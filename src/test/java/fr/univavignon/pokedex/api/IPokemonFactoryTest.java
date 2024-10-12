package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private Pokemon pokemon;
    private int index;
    private int cp;
    private int hp;
    private int dust;
    private int candy;

    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);

        index = 133;
        cp = 613;
        hp = 64;
        dust = 4000;
        candy = 4;

        pokemon = new Pokemon(index, "Bulbizarre", 126, 126,
                90, cp, hp, dust, candy, 0.56);
    }

    @Test
    @DisplayName("testing createPokemonInstance")
    void testCreatePokemonInstance(){

        when(pokemonFactory.createPokemon(index,cp,hp,dust,candy)).thenReturn(pokemon);

        assertInstanceOf(Pokemon.class, pokemon);
        assertNotNull(pokemon);
    }

    @Test
    @DisplayName("testing createPokemonProperties")
    void testCreatePokemonProperties() {

        when(pokemonFactory.createPokemon(index,cp,hp,dust,candy)).thenReturn(pokemon);

        assertTrue(pokemon.getIndex() > 0);
        assertTrue(pokemon.getCp() > 0);
        assertTrue(pokemon.getHp() > 0);
        assertTrue(pokemon.getDust() > 0);
        assertTrue(pokemon.getCandy() > 0);
    }

    @Test
    @DisplayName("testing createPokemonBounderies")
    void testCreatePokemonBounderies(){

    }

    @AfterEach
    void tearDown() {
        pokemonFactory = null;
        pokemon = null;
    }

}