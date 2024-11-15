package fr.univavignon.pokedex.api.repositories;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.*;

class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    @DisplayName("testing shouldCreatePokedex")
    void shouldCreatePokedex() {

        IPokemonMetadataProvider provider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex ipokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(provider, pokemonFactory)).thenReturn(ipokedex);

        IPokedex finalIPokedex = pokedexFactory.createPokedex(provider, pokemonFactory);

        assertInstanceOf(IPokedex.class, finalIPokedex,
                "Le résultat obtenu doit être une instance de `Ipokedex`"
        );
        assertEquals(ipokedex, finalIPokedex);

        verify(pokedexFactory).createPokedex(provider, pokemonFactory);
    }

    @AfterEach
    public void tearDown() {
        pokedexFactory = null;
    }
}