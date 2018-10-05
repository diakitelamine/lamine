package strategy;

import graphique.Grille;

public interface Regle {

	public void apply() ;
	
	public default boolean isDone(Grille grille) {
		return Grille.compteur == grille.getCases().length * grille.getCases()[0].length ;
	}
}
