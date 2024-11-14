package fr.univavignon.pokedex.api.repositories;

import fr.univavignon.pokedex.api.models.PokemonTrainer;
import fr.univavignon.pokedex.api.models.Team;
import fr.univavignon.pokedex.api.repositories.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;


    @BeforeEach
    void setUp() {

        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    @DisplayName("testing createTrainer")
    void shouldCreateTrainer() {

        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex ipokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(ipokedex);

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Sasha", Team.MYSTIC, pokedex);
        when(trainerFactory.createTrainer("Sasha", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);

        assertInstanceOf(PokemonTrainer.class,
                trainerFactory.createTrainer("Sasha", Team.MYSTIC, pokedexFactory),
                "La méthode doit obtenir un 'PokemonTrainer'."
        );
    }

    @AfterEach
    void tearDown() {
        trainerFactory = null;
        pokedexFactory = null;
    }
}