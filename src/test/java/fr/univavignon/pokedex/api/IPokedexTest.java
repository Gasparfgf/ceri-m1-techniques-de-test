package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.Pokemon;
import fr.univavignon.pokedex.api.models.PokemonComparators;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
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
    private int idx1;
    private int idx2;
    private int idx3;


    @BeforeEach
    void setUp() {
        iPokedex = mock(IPokedex.class);

        pokemon1 = new Pokemon(18, "Aquali", 186, 168,
                260, 2729, 202, 5000, 4, 100);
        pokemon2 = new Pokemon(124, "Bulbizarre", 126, 126,
                90, 613, 64, 4000, 4, 56);
        pokemon3 = new Pokemon(2, "Gaspar", 156, 158,
                120, 800, 64, 5000, 5, 75);

        when(iPokedex.addPokemon(pokemon1)).thenReturn(0);
        when(iPokedex.addPokemon(pokemon2)).thenReturn(1);
        when(iPokedex.addPokemon(pokemon3)).thenReturn(2);

        idx1 = iPokedex.addPokemon(pokemon1);
        idx2 = iPokedex.addPokemon(pokemon2);
        idx3 = iPokedex.addPokemon(pokemon3);
    }


    @Test
    @DisplayName("testing size")
    void testSize() {

        when(iPokedex.size()).thenReturn(3);

        assertTrue(iPokedex.size() >= 0, "La taille ne peut pas être négative.");
        assertEquals(3, iPokedex.size(), "La taille d'une liste avec trois éléments c'est 3.");
    }

    @Test
    @DisplayName("testing addPokemon")
    void testAddPokemon() {

        assertEquals(0, idx1, "Premier élément d'une liste doit avoir index 0.");
        assertEquals(1, idx2, "Deuxième élément d'une liste doit avoir index 1.");
        assertEquals(2, idx3, "Troisième élément d'une liste doit avoir index 2.");
    }

    @Test
    @DisplayName("testing getPokemon")
    void getPokemon() throws PokedexException {

        int idxNotValid = 151;

        when(iPokedex.getPokemon(idx2)).thenReturn(pokemon2);
        when(iPokedex.getPokemon(idxNotValid))
                .thenThrow(new PokedexException("Le pokemon pour l'indice donné n'existe pas."));

        assertInstanceOf(Pokemon.class, iPokedex.getPokemon(idx2), "On ne peut obtenir que des pokemons.");

        assertEquals("Bulbizarre", iPokedex.getPokemon(idx2).getName(),
                "On ne peut pas obtenir un Ipokedex différent pour l'index donné.");

        assertThrows(PokedexException.class, () -> iPokedex.getPokemon(idxNotValid));
    }

    @Test
    @DisplayName("testing getPokemonsList")
    void getPokemons() throws UnsupportedOperationException {

        when(iPokedex.getPokemons()).thenReturn(
                Arrays.asList(pokemon1, pokemon2, pokemon3)
        );
        // je garantis que la liste ne soit pas modifiable
        List<Pokemon> pokemonsList = Collections.unmodifiableList(iPokedex.getPokemons());

        // les méthodes susceptibles de changer la liste
        assertThrows(UnsupportedOperationException.class, () ->{
            pokemonsList.add(pokemon2);
            pokemonsList.remove(0);
            pokemonsList.clear();
        }, "La liste ne peut subir aucune modification (add/remove/clear).");

        assertEquals("Aquali", pokemonsList.get(idx1).getName(),
                "Le nom du pokemon à l'index 2 doit être Aquali.");
        assertEquals("Bulbizarre", pokemonsList.get(idx2).getName(),
                "Le nom du pokemon à l'index 2 doit être Bulbizarre.");
        assertEquals("Gaspar", pokemonsList.get(idx3).getName(),
                "Le nom du pokemon à l'index 2 doit être Gaspar.");
    }

    @Test
    @DisplayName("testing getPokemonsListComparator")
    void testGetPokemons() {

        PokemonComparators comparator = PokemonComparators.NAME;

        when(iPokedex.getPokemons(comparator)).thenReturn(
                Arrays.asList(pokemon3, pokemon1, pokemon2)
        );
        // je garantis que la liste ne soit pas modifiable
        List<Pokemon> pokemonsList = Collections.unmodifiableList(iPokedex.getPokemons(comparator));

        // les méthodes susceptibles de changer la liste
        assertThrows(UnsupportedOperationException.class, () ->{
            pokemonsList.add(pokemon2);
            pokemonsList.remove(0);
            pokemonsList.clear();
        }, "La liste ne peut subir aucune modification (add/remove/clear).");

        assertEquals("Gaspar", pokemonsList.get(idx1).getName(),
                "Le nom du pokemon à l'index 0 doit être 'Gaspar'.");
        assertEquals("Aquali", pokemonsList.get(idx2).getName(),
                "Le nom du pokemon à l'index 1 doit être 'Aquali'.");
        assertEquals("Bulbizarre", pokemonsList.get(idx3).getName(),
                "Le nom du pokemon à l'index 0 doit être 'Bulbizarre'.");
    }


    @AfterEach
    void tearDown() {
        iPokedex = null;
        pokemon1 = null;
        pokemon2 = null;
        pokemon3 = null;
    }

}