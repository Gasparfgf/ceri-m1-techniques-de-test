package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.repositories.IPokedex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexTest {
    private static IPokedex iPokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;


    @BeforeEach
    void setUp() {
        iPokedex = mock(IPokedex.class);

        pokemon1 = new Pokemon(124, "Aquali", 186, 168,
                260, 2729, 202, 5000, 4, 1.0);
        pokemon2 = new Pokemon(18, "Bulbizarre", 126, 126,
                90, 613, 64, 4000, 4, 0.56);
        pokemon3 = new Pokemon(2, "Gaspar", 156, 158,
                120, 800, 64, 5000, 5, 75.0);
        pokemon4 = new Pokemon(4, "Francisco", 112, 102,
                78, 500, 52, 4000, 4, 39.0);
    }


    @Test
    @DisplayName("testing size")
    void testSize() {

        when(iPokedex.size()).thenReturn(4);

        assertEquals(4, iPokedex.size(), "La taille du Pokedex doit être 4.");
        assertTrue(iPokedex.size() >= 0, "La taille ne peut pas être négative.");
    }

    @Test
    @DisplayName("testing addPokemon")
    void testAddPokemon() {

        when(iPokedex.addPokemon(pokemon1)).thenReturn(0);
        int index = iPokedex.addPokemon(pokemon1);
        when(iPokedex.size()).thenReturn(1);

        assertInstanceOf(Pokemon.class, pokemon1, "On ne peut rajouter que des pokemons.");
        assertNotNull(pokemon1, "On ne peut pas rajouter de pokemon vide.");
        assertTrue(index >= 0, "L'index d'un pokemon ne peut pas être négatif.");
        assertEquals(0, index, "Premier élément d'une liste doit avoir index 0.");
        assertEquals(1, iPokedex.size(), "La taille d'une liste avec un élément est 1.");
    }

    @Test
    @DisplayName("testing getPokemon")
    void getPokemon() throws PokedexException {

        when(iPokedex.addPokemon(pokemon2)).thenReturn(0);
        int index = iPokedex.addPokemon(pokemon2);
        when(iPokedex.getPokemon(index)).thenReturn(pokemon2);

        // testing instance
        assertInstanceOf(Pokemon.class, pokemon2, "On ne peut obtenir que des pokemons.");
        assertNotNull(pokemon2, "On ne peut pas obtenir de pokemon null.");

        // testing properties -> pokemon exists
        assertEquals("Bulbizarre", pokemon2.getName(),
                "On ne peut pas obtenir un élément différent pour l'index donné");
    }

    @Test
    @DisplayName("testing getPokemonsList")
    void getPokemons() {

        when(iPokedex.getPokemons()).thenReturn(
                Arrays.asList(pokemon1, pokemon2, pokemon3, pokemon4)
        );
        // je garantis que la liste ne soit pas modifiable
        List<Pokemon> pokemonsList = Collections.unmodifiableList(iPokedex.getPokemons());

        // les méthodes susceptibles de changer la liste
        assertThrows(UnsupportedOperationException.class, () ->{
            pokemonsList.add(pokemon2);
            pokemonsList.remove(0);
            pokemonsList.clear();
        });

        assertEquals(pokemon1.getName(), pokemonsList.get(0).getName());
        assertEquals(pokemon2.getName(), pokemonsList.get(1).getName());
        assertEquals(pokemon3.getName(), pokemonsList.get(2).getName());
        assertEquals(pokemon4.getName(), pokemonsList.get(3).getName());
    }

    @Test
    @DisplayName("testing getPokemonsListComparator")
    void testGetPokemons() {

        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);

        when(iPokedex.getPokemons(comparator)).thenReturn(
                Arrays.asList(pokemon3, pokemon4, pokemon2, pokemon1)
        );
        // je garantis que la liste ne soit pas modifiable
        List<Pokemon> pokemonsList = Collections.unmodifiableList(iPokedex.getPokemons(comparator));

        assertEquals(5, pokemonsList.get(0).getCandy());
        assertEquals("Francisco", pokemonsList.get(1).getName());
        assertEquals(18, pokemonsList.get(2).getIndex());
        assertEquals(1.0, pokemonsList.get(3).getIv());
    }


    @AfterEach
    void tearDown() {
        iPokedex = null;
        pokemon1 = null;
        pokemon2 = null;
        pokemon3 = null;
        pokemon4 = null;
    }

}