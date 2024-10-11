package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider myInterface;

    @BeforeEach
    void setUp() {
        myInterface = mock(IPokemonMetadataProvider.class);
    }

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        // je fabrique les données
        int index = 0;
        PokemonMetadata pokemon = new PokemonMetadata(index, "Aquali", 186, 168, 260);

        // j'appele l'action
        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemon);

        // je vérifie si le résultat est bien une instance de PokemonMetadata
        assertInstanceOf(PokemonMetadata.class, pokemon);

        // je garantis que les données renvoyées sont correctes
        assertEquals("Aquali",pokemon.getName());
        assertEquals(186, pokemon.getAttack());
        assertEquals(168, pokemon.getDefense());
        assertEquals(260, pokemon.getStamina());

    }
}