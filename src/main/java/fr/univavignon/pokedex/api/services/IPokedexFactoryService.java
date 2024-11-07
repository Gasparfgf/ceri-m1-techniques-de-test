package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.repositories.IPokedex;
import fr.univavignon.pokedex.api.repositories.IPokedexFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonFactory;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;

import java.util.ArrayList;
import java.util.List;

public class IPokedexFactoryService implements IPokedexFactory {
    private List<IPokedex> pokedexList;

    public IPokedexFactoryService(){
        pokedexList = new ArrayList<>();
    }

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        IPokedex pokedex = new IPokedexService(metadataProvider, pokemonFactory);
        pokedexList.add(pokedex);
        return pokedex;
    }
}
