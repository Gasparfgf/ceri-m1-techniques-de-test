package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderServiceTest {
    private IPokemonMetadataProviderService metadataProvider;

    @BeforeEach
    void setUp() {
        metadataProvider = new IPokemonMetadataProviderService();
    }

    @Test
    void testGetPokemonMetadataValidIndex() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);
        assertNotNull(metadata);
        assertEquals("Bulbasaur", metadata.getName());
    }

    @Test
    void testGetPokemonMetadataInvalidIndex() {
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(999));
    }

}