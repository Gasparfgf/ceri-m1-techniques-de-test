package fr.univavignon.pokedex.api.services;

import fr.univavignon.pokedex.api.models.PokedexException;
import fr.univavignon.pokedex.api.models.PokemonMetadata;
import fr.univavignon.pokedex.api.repositories.IPokemonMetadataProvider;

import java.util.HashMap;
import java.util.Map;

public class IPokemonMetadataProviderService implements IPokemonMetadataProvider{
    private final Map<Integer, PokemonMetadata> pokemonMetadata;

    public IPokemonMetadataProviderService(){
        this.pokemonMetadata = new HashMap<>();
        // Ajout de quelques exemples de Pokémon
        pokemonMetadata.put(1, new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
        pokemonMetadata.put(2, new PokemonMetadata(2, "Ivysaur", 156, 158, 120));
        pokemonMetadata.put(133, new PokemonMetadata(133, "Eevee", 104, 114, 110));
        pokemonMetadata.put(134, new PokemonMetadata(134, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(!pokemonMetadata.containsKey(index)){
            throw new PokedexException("Le pokémon metadata à l'indice "+index+" n'existe pas.");
        }
        return pokemonMetadata.get(index);
    }
}
