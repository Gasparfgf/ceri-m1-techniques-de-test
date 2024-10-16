package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonMetadataProviderTest {
    private static IPokemonMetadataProvider myInterface;
    private PokemonMetadata pokemonMetadata;
    private int index;

    @BeforeEach
    void setUp() {
        index = 1;
        myInterface = mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(index, "Aquali", 186, 168, 260);
    }

    @Test
    @DisplayName("testing getPokemonMetadataProperties")
    void testGetPokemonMetadataProperties() throws PokedexException {

        int idxNotValid = 2000;

        when((myInterface.getPokemonMetadata(idxNotValid))).thenThrow(
                new PokedexException("Le metadata du pokemon pour l'indice donné n'existe pas.")
        );
        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        assertThrows(PokedexException.class, () -> myInterface.getPokemonMetadata(idxNotValid));
        // je garantis que les données renvoyées sont correctes
        assertEquals("Aquali",pokemonMetadata.getName());
        assertEquals(186, pokemonMetadata.getAttack());
        assertEquals(168, pokemonMetadata.getDefense());
        assertEquals(260, pokemonMetadata.getStamina());
    }

    @Test
    @DisplayName("testing getPokemonMetadataInstance")
    void testGetPokemonMetadataInstance() throws PokedexException {

        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        assertInstanceOf(PokemonMetadata.class, pokemonMetadata);
    }

    @AfterEach
    void tearDown() {
        myInterface = null;
        pokemonMetadata = null;
    }

}