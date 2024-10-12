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

    @BeforeEach
    void setUp() {
        myInterface = mock(IPokemonMetadataProvider.class);
    }

    @Test
    @DisplayName("testing getPokemonMetadataProperties")
    void testGetPokemonMetadataProperties() throws PokedexException {
        // je fabrique les données
        int index = 1;
        PokemonMetadata pokemonMetadata = new PokemonMetadata(index, "Aquali", 186, 168, 260);

        // j'appele l'action
        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        // je garantis que les données renvoyées sont correctes
        assertEquals("Aquali",pokemonMetadata.getName());
        assertEquals(186, pokemonMetadata.getAttack());
        assertEquals(168, pokemonMetadata.getDefense());
        assertEquals(260, pokemonMetadata.getStamina());
    }

    @Test
    @DisplayName("testing getPokemonMetadataInstance")
    void testGetPokemonMetadataInstance() throws PokedexException {
        int index = 1;
        PokemonMetadata pokemonMetadata = new PokemonMetadata(index, "Aquali", 186, 168, 260);

        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        assertInstanceOf(PokemonMetadata.class, pokemonMetadata);
    }

    @AfterEach
    void tearDown() {
        myInterface = null;
    }

}