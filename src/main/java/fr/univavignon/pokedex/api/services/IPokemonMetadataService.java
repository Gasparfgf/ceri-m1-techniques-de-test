package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;

import java.util.ArrayList;
import java.util.List;

public class IPokemonMetadataService implements IPokemonMetadataProvider{
    private List<PokemonMetadata> metadataList = new ArrayList<>();

    public IPokemonMetadataService(){
        metadataList.add(
                new PokemonMetadata(0, "Aquali", 186, 168, 260)
        );
    }


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata pokemonMetadata = metadataList.get(index);
        if(pokemonMetadata == null){
            throw new PokedexException("Le pokémon metadata à l'indice "+index+" n'a pas été trouvé.");
        }
        return pokemonMetadata;
    }
}
