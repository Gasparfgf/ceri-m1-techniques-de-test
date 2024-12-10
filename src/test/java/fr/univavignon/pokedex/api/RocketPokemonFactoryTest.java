package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketPokemonFactoryTest {
    private RocketPokemonFactory RocketPokemonFactory = new RocketPokemonFactory();

    @Test
    void testCreatePokemonWithMissingIndex() {
        Pokemon missingNo = RocketPokemonFactory.createPokemon(99, 500, 100, 3000, 3);
        assertEquals("MISSINGNO", missingNo.getName());
        assertTrue(missingNo.getAttack() >= 0 && missingNo.getAttack() <= 100);
    }

    @Test
    void testGenerateRandomStatEfficiency() {
        long startTime = System.currentTimeMillis();
        int randomStat = RocketPokemonFactory.generateRandomStat();
        long endTime = System.currentTimeMillis();
        assertTrue(endTime - startTime < 50, "generateRandomStat is too slow!");
    }

    @Test
    void testUnmodifiableMapIntegrity() {
        assertThrows(UnsupportedOperationException.class, () -> {
            RocketPokemonFactory.index2name.put(2, "Charmander");
        });
    }

    @Test
    public void testIndex2NameMap() {
        assertNotNull(RocketPokemonFactory.index2name);
        assertTrue(RocketPokemonFactory.index2name.containsKey(-1));
        assertTrue(RocketPokemonFactory.index2name.containsKey(0));
        assertTrue(RocketPokemonFactory.index2name.containsKey(1));
        assertEquals("Ash's Pikachu", RocketPokemonFactory.index2name.get(-1));
        assertEquals("MISSINGNO", RocketPokemonFactory.index2name.get(0));
        assertEquals("Bulbasaur", RocketPokemonFactory.index2name.get(1));
    }

    @Test
    public void testGenerateRandomStat() {
        int stat = RocketPokemonFactory.generateRandomStat();
        assertTrue(stat >= 0 && stat <= 100);
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        Pokemon pokemon = RocketPokemonFactory.createPokemon(1, 100, 100, 100, 100);
        assertNotNull(pokemon);
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1.0, pokemon.getIv(), 0.01);
    }
/*
    @Test
    public void testCreatePokemonWithInvalidIndex() {
        Pokemon pokemon = RocketPokemonFactory.createPokemon(-2, 100, 100, 100, 100);
        assertNotNull(pokemon);
        assertTrue(pokemon.getIndex() >= 0);
        assertEquals("MISSINGNO", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1.0, pokemon.getIv(), 0.01);
    }
*/
    @Test
    public void testCreatePokemonWithNegativeIndex() {
        Pokemon pokemon = RocketPokemonFactory.createPokemon(-1, 100, 100, 100, 100);
        assertNotNull(pokemon);
        assertEquals(-1, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.01);
    }

    @Test
    public void testCreatePokemonWithZeroIndex() {
        Pokemon pokemon = RocketPokemonFactory.createPokemon(0, 100, 100, 100, 100);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1.0, pokemon.getIv(), 0.01);
    }
}