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


    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);

        pokemon = new Pokemon(133, "Bulbizarre", 126, 126,
                90, 613, 64, 4000, 4, 0.56);
    }

    @Test
    @DisplayName("testing createPokemonInstance")
    void testCreatePokemonInstance(){

        when(pokemonFactory.createPokemon(133,613,64,4000,4)).thenReturn(pokemon);

        assertInstanceOf(Pokemon.class, pokemon);
        assertNotNull(pokemon);
    }

    @Test
    @DisplayName("testing createPokemonProperties")
    void testCreatePokemonProperties() {

        when(pokemonFactory.createPokemon(133,613,64,4000,4)).thenReturn(pokemon);

        assertTrue(pokemon.getIndex() > 0);
        assertTrue(pokemon.getCp() > 0);
        assertTrue(pokemon.getHp() > 0);
        assertTrue(pokemon.getDust() > 0);
        assertTrue(pokemon.getCandy() > 0);
    }

    /*
    Because some values must be limited
     */
    @Test
    @DisplayName("testing createPokemonBoundaries")
    void testCreatePokemonBoundaries(){

        when(pokemonFactory.createPokemon(133,613,64,4000,4)).thenReturn(pokemon);

        // Niveau de base de l’espèce + Niveau de l’individu : contrainte non comprise
        assertTrue(pokemon.getIndex() <= 150); // contrainte établie par l'énoncée
        assertTrue(pokemon.getIv() <=1.0); // 1 represents 100%

    }

    @AfterEach
    void tearDown() {
        pokemonFactory = null;
        pokemon = null;
    }

}