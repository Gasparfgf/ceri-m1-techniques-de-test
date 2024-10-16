package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.repositories.IPokedex;
import fr.univavignon.pokedex.api.repositories.IPokedexFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    @DisplayName("testing testCreatePokedex")
    void testCreatePokedex() {

        IPokemonMetadataProvider provider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex ipokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(provider, pokemonFactory)).thenReturn(ipokedex);

        IPokedex iPokedexFinal = pokedexFactory.createPokedex(provider, pokemonFactory);

        assertInstanceOf(IPokedex.class, ipokedex, "Le résultat obtenu doit être une instance de `Ipokedex`");
        assertNotNull(iPokedexFinal, "Le résultat obtenu ne doit pas être null.");
    }

    @AfterEach
    void tearDown() {
        pokedexFactory = null;
    }
}