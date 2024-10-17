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
    void shouldVerifyGetPokemonMetadataProperties() throws PokedexException {

        int idxNotValid = 2000;

        when((myInterface.getPokemonMetadata(idxNotValid))).thenThrow(
                new PokedexException("Le metadata du pokemon pour l'indice donné n'existe pas.")
        );
        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        PokemonMetadata metadata = myInterface.getPokemonMetadata(index);

        assertThrows(PokedexException.class, () -> myInterface.getPokemonMetadata(idxNotValid));
        // je garantis que les données renvoyées sont correctes
        assertEquals("Aquali",metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test
    @DisplayName("testing getPokemonMetadata")
    void shouldGetPokemonMetadata() throws PokedexException {

        when(myInterface.getPokemonMetadata(index)).thenReturn(pokemonMetadata);

        assertInstanceOf(PokemonMetadata.class, myInterface.getPokemonMetadata(index));
    }

    @AfterEach
    void tearDown() {
        myInterface = null;
        pokemonMetadata = null;
    }

}