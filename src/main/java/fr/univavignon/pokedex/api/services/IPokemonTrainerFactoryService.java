package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokemonTrainer;
import fr.univavignon.pokedex.api.models.Team;
import fr.univavignon.pokedex.api.repositories.*;

import java.util.ArrayList;
import java.util.List;

public class IPokemonTrainerFactoryService implements IPokemonTrainerFactory {
    private IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;
    private List<PokemonTrainer> pokemonTrainerList;

    public IPokemonTrainerFactoryService(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory){
        this.pokemonTrainerList = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }


    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        PokemonTrainer trainer = new PokemonTrainer(name, team, pokedex);
        pokemonTrainerList.add(trainer);
        return trainer;
    }
}
