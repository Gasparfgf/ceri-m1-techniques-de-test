package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.Pokemon;
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


    @BeforeEach
    void setUp() {
        iPokedex = mock(IPokedex.class);

        pokemon1 = new Pokemon(18, "Aquali", 186, 168,
                260, 2729, 202, 5000, 4, 1.0);
        pokemon2 = new Pokemon(124, "Bulbizarre", 126, 126,
                90, 613, 64, 4000, 4, 0.56);
        pokemon3 = new Pokemon(2, "Gaspar", 156, 158,
                120, 800, 64, 5000, 5, 0.75);

        when(iPokedex.addPokemon(pokemon1)).thenReturn(0);
        when(iPokedex.addPokemon(pokemon2)).thenReturn(1);
        when(iPokedex.addPokemon(pokemon3)).thenReturn(2);
    }


    @Test
    @DisplayName("testing size")
    void testSize() {

        iPokedex.addPokemon(pokemon1);

        when(iPokedex.size()).thenReturn(1);

        assertTrue(iPokedex.size() >= 0, "La taille ne peut pas être négative.");
        assertEquals(1, iPokedex.size(), "La taille d'une liste avec un élément est 1.");
    }

    @Test
    @DisplayName("testing addPokemon")
    void testAddPokemon() {

        int idx1 = iPokedex.addPokemon(pokemon1);
        int idx2 = iPokedex.addPokemon(pokemon2);
        int idx3 = iPokedex.addPokemon(pokemon3);

        assertEquals(0, idx1, "Premier élément d'une liste doit avoir index 0.");
        assertEquals(1, idx2, "Deuxième élément d'une liste doit avoir index 1.");
        assertEquals(2, idx3, "Troisième élément d'une liste doit avoir index 2.");
    }

    @Test
    @DisplayName("testing getPokemon")
    void getPokemon() throws PokedexException {

        int idx2 = iPokedex.addPokemon(pokemon2);
        int idxNotValid = 151;

        when(iPokedex.getPokemon(idx2)).thenReturn(pokemon2);
        when(iPokedex.getPokemon(idxNotValid))
                .thenThrow(new PokedexException("Le pokemon pour l'indice donné n'existe pas."));

        assertInstanceOf(Pokemon.class, iPokedex.getPokemon(idx2), "On ne peut obtenir que des pokemons.");
        assertNotNull(iPokedex.getPokemon(idx2), "On ne peut pas obtenir de pokemon null.");

        assertEquals("Bulbizarre", iPokedex.getPokemon(idx2).getName(),
                "On ne peut pas obtenir un élément différent pour l'index donné.");

        assertThrows(PokedexException.class, () -> iPokedex.getPokemon(idxNotValid));
    }

    @Test
    @DisplayName("testing getPokemonsList")
    void getPokemons() throws UnsupportedOperationException {

        int idx1 = iPokedex.addPokemon(pokemon1);
        int idx2 = iPokedex.addPokemon(pokemon2);
        int idx3 = iPokedex.addPokemon(pokemon3);

        when(iPokedex.getPokemons()).thenReturn(
                Arrays.asList(pokemon1, pokemon2, pokemon3)
        );
        // je garantis que la liste ne soit pas modifiable
        List<Pokemon> pokemonsList = Collections.unmodifiableList(iPokedex.getPokemons());

        // for tests only
        /*
        pokemonsList.add(pokemon1);
        pokemonsList.remove(idx2);
        pokemonsList.clear();
         */
        // les méthodes susceptibles de changer la liste
        assertThrows(UnsupportedOperationException.class, () ->{
            pokemonsList.add(pokemon2);
            pokemonsList.remove(0);
            pokemonsList.clear();
        }, "La liste ne peut subir aucune modification (add/remove/clear).");

        assertEquals(1.0, pokemonsList.get(idx1).getIv(),
                "Le pourcentage de perfection du pokemon à l'index 0 doit être 1.0.");
        assertEquals(124, pokemonsList.get(idx2).getIndex(),
                "L'index du pokemon à l'index 1 doit être 124.");
        assertEquals("Gaspar", pokemonsList.get(idx3).getName(),
                "Le nom du pokemon à l'index 2 doit être Gaspar.");
    }

    @Test
    @DisplayName("testing getPokemonsListComparator")
    void testGetPokemons() {

        int idx1 = iPokedex.addPokemon(pokemon1);
        int idx2 = iPokedex.addPokemon(pokemon2);
        int idx3 = iPokedex.addPokemon(pokemon3);
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);

        when(iPokedex.getPokemons(comparator)).thenReturn(
                Arrays.asList(pokemon3, pokemon1, pokemon2)
        );
        // je garantis que la liste ne soit pas modifiable
        List<Pokemon> pokemonsList = Collections.unmodifiableList(iPokedex.getPokemons(comparator));

        // for tests only
        /*
        pokemonsList.add(pokemon1);
        pokemonsList.remove(idx2);
        pokemonsList.clear();
*/
        // les méthodes susceptibles de changer la liste
        assertThrows(UnsupportedOperationException.class, () ->{
            pokemonsList.add(pokemon2);
            pokemonsList.remove(0);
            pokemonsList.clear();
        }, "La liste ne peut subir aucune modification (add/remove/clear).");

        assertEquals("Gaspar", pokemonsList.get(idx1).getName());
        assertEquals("Aquali", pokemonsList.get(idx2).getName());
        assertEquals("Bulbizarre", pokemonsList.get(idx3).getName());
    }


    @AfterEach
    void tearDown() {
        iPokedex = null;
        pokemon1 = null;
        pokemon2 = null;
        pokemon3 = null;
    }

}