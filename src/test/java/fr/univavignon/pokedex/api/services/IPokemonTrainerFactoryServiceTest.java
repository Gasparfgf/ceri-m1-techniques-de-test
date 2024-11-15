package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokemonTrainer;
import fr.univavignon.pokedex.api.models.Team;
import fr.univavignon.pokedex.api.repositories.IPokedex;
import fr.univavignon.pokedex.api.repositories.IPokedexFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryServiceTest {
    private IPokemonTrainerFactoryService trainerFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        trainerFactory = new IPokemonTrainerFactoryService(metadataProvider, pokemonFactory);
    }

    @Test
    void testCreateTrainer() {

        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
    }

}