package fr.univavignon.pokedex.api.models;

import fr.univavignon.pokedex.api.repositories.IPokedex;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
@Getter
@Setter
@RequiredArgsConstructor
public class PokemonTrainer {

	/** Trainer name. **/
    private final String name;

	/** Trainer team. **/
    private final Team team;
	
	/** Trainer pokedex. **/
    private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */

}
