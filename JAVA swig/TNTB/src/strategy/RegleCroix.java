package strategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controllers.ScoreController;
import frames.Jeu;
import graphique.Case;
import graphique.Grille;
import model.Strategy;
import model.dao.StrategyDAO;

public class RegleCroix extends Strategy{

	private Grille grille ;
	
	public RegleCroix() {
		
	}
	
	public RegleCroix(Grille grille) {
		this.grille = grille ;		
		Jeu.cache.putStrategyId(2);		
	}
	
	
	@Override
	public void apply() {
		for(int i = 0 ; i < grille.getCases().length ; i++) {				
			for(int j = 0 ; j < grille.getCases()[0].length ; j++) {
				grille.getCaseIJ(i, j).addActionListener(new RegleCroixListener());
			}
		}
	}
	
	class RegleCroixListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Grille.compteurClick++ ;
			
			Case source = (Case) arg0.getSource() ;
			
			for(int i = 0 ; i < grille.getCases().length ; i++) {				
				for(int j = 0 ; j < grille.getCases()[0].length ; j++) {
										
					if((i == source.getI() || j == source.getJ()))
						grille.getCaseIJ(i, j).changerCouleur();			
				}
			}
			
			if(isDone(grille)) {
				grille.decoration();
				if (JOptionPane.showConfirmDialog(null, "Youpiiiiii Vous avez gagné, voulez-vous sauvegarder ?", "INFO",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {	
					ScoreController.addNewScore(313);
				} else {
					
				}
				
				grille.reset();
			}
		}
		
	}

}
