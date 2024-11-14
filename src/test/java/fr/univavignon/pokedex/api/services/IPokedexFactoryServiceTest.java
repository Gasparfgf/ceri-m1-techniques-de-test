package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.repositories.IPokedex;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IPokedexFactoryServiceTest {
    private IPokedexFactoryService factory;

    @BeforeEach
    void setUp() {
        factory = new IPokedexFactoryService();
    }

    @Test
    void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}