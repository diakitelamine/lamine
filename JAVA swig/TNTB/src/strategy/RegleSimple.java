package strategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controllers.ScoreController;
import frames.Jeu;
import graphique.Case;
import graphique.Grille;
import model.Strategy;

public class RegleSimple extends Strategy {

	private Grille grille ;
	
	public RegleSimple() {
		
	}
	
	public RegleSimple(Grille grille) {
		this.grille = grille ;
		Jeu.cache.putStrategyId(1);
	}
	
	@Override
	public void apply() {
		for(int i = 0 ; i < grille.getCases().length; i++) {
			for(int j = 0 ; j < grille.getCases()[0].length; j++) {
				grille.getCaseIJ(i, j).addActionListener(new RegleSimpleListener());
			}
		}
	}
	
	class RegleSimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Grille.compteurClick++ ;
			
			Case source = (Case)e.getSource() ;
			source.changerCouleur();
			Case haut = grille.getCaseHaut(source) ;
			Case bas = grille.getCaseBas(source) ;
			Case gauche = grille.getCaseGauche(source) ;
			Case droite = grille.getCaseDroite(source) ;
			
			if(haut != null )
				haut.changerCouleur();
			
			if(bas != null)
				bas.changerCouleur();
			
			if(gauche != null)
				gauche.changerCouleur();
			
			if(droite != null)
				droite.changerCouleur();
			
			if(isDone(grille)) {
				grille.decoration();;
				if (JOptionPane.showConfirmDialog(null, "Youpiiiiii Vous avez gagné, voulez-vous sauvegarder ?", "INFO",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {	
					ScoreController.addNewScore(313);
				} else {
					
				}grille.reset();
			}			
		}
		
	}

}
