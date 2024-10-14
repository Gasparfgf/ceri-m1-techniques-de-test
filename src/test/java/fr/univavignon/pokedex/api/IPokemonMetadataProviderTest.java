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
        myInterface = mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(index, "Aquali", 186, 168, 260);
        index = 1;
    }

    @Test
    @DisplayName("testing getPokemonMetadataProperties")
    void testGetPokemonMetadataProperties() throws PokedexException {
        // j'appele l'action
        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        // je garantis que les données renvoyées sont correctes
        assertEquals("Aquali",pokemonMetadata.getName());
        assertEquals(186, pokemonMetadata.getAttack());
        assertEquals(168, pokemonMetadata.getDefense());
        assertEquals(260, pokemonMetadata.getStamina());

        assertThrows(PokedexException.class, () -> myInterface.getPokemonMetadata(151));
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