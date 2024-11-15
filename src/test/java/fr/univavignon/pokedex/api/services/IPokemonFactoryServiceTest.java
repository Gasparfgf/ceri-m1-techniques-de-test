package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryServiceTest {
    private IPokemonFactoryService factory;

    @BeforeEach
    void setUp() {
        factory = new IPokemonFactoryService();
    }

    @Test
    void testCreatePokemon() {

        Pokemon pokemon = factory.createPokemon(0, 500, 100, 3000, 3);

        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(500, pokemon.getCp());
    }

}