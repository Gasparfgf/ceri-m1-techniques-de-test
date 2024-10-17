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
    private Pokemon finalPokemon;
    private Pokemon pokemon;


    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);

        pokemon = new Pokemon(133, "Bulbizarre", 126, 126,
                90, 613, 64, 4000, 4, 56);

        when(pokemonFactory.createPokemon(133,613,64,4000,4)).thenReturn(pokemon);

        finalPokemon = pokemonFactory.createPokemon(133,613,64,4000,4);
    }

    @Test
    @DisplayName("testing createPokemonInstance")
    void testCreatePokemonInstance(){

        assertInstanceOf(Pokemon.class, finalPokemon, "Le résultat obtenu doit être un `Pokemon`.");
    }

    @Test
    @DisplayName("testing createPokemonProperties")
    void testCreatePokemonProperties() {

        assertTrue(finalPokemon.getIndex() > 0, "Pokemon ne peut pas être créé avec 'index' négatif.");
        assertTrue(finalPokemon.getCp() > 0, "Pokemon ne peut pas être créé avec 'cp' négatif.");
        assertTrue(finalPokemon.getHp() > 0, "Pokemon ne peut pas être créé avec 'hp' négatif.");
        assertTrue(finalPokemon.getDust() > 0, "Pokemon ne peut pas être créé avec 'dust' négatif.");
        assertTrue(finalPokemon.getCandy() > 0, "Pokemon ne peut pas être créé avec 'candy' négatif.");
    }

    /*
    Because some values must be limited
     */
    @Test
    @DisplayName("testing createPokemonBoundaries")
    void testCreatePokemonBoundaries(){

        assertTrue(finalPokemon.getIndex() <= 150,
                "Pokemon ne peut pas être créé avec 'index>150'"); // contrainte établie par l'énoncée
        assertTrue(finalPokemon.getIv() <=100,
                "Pokemon ne peut pas être créé avec 'iv > 100'"); // 1 represents 100%
    }

    @AfterEach
    void tearDown() {
        pokemonFactory = null;
        finalPokemon = null;
        pokemon = null;
    }

}