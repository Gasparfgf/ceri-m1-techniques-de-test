package fr.univavignon.pokedex.api;

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
    @DisplayName("testing getPokemonMetadata")
    void testGetPokemonMetadata() throws PokedexException {
        // je fabrique les données
        int index = 1;
        PokemonMetadata pokemon = new PokemonMetadata(index, "Aquali", 186, 168, 260);

        // j'appele l'action
        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemon);

        // je vérifie si le résultat est bien une instance de PokemonMetadata
        // parce que ça peut être null dans les cas où
        // l'utilisateur avec l'id demandé nexiste pas
        assertInstanceOf(PokemonMetadata.class, pokemon);

        // je garantis que les données renvoyées sont correctes
        assertEquals("Aquali",pokemon.getName());
        assertEquals(186, pokemon.getAttack());
        assertEquals(168, pokemon.getDefense());
        assertEquals(260, pokemon.getStamina());
    }

    @AfterEach
    void tearDown() {
        myInterface = null;
    }

}