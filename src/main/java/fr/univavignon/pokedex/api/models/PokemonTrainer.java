package fr.univavignon.pokedex.api.models;

import fr.univavignon.pokedex.api.repositories.IPokedex;
import lombok.Getter;
import lombok.Setter;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
@Getter
@Setter
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
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
}
