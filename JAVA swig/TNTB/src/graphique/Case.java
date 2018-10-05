package graphique;

import javax.swing.JButton;

import utilitaires.Parametres;

public class Case extends JButton {
	
	private int i ; // quelle ligne ;
	private int j ; // quelle colonne ;
	
	public Case () {
		i = 0 ;
		j = 0 ;
	}
	
	public Case(int i , int j) {
		this.i = i ;
		this.j = j ;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	public void changerCouleur() {
		if(getBackground().equals(Parametres.COULEUR_DEB)) {
			setBackground(Parametres.COULEUR_FIN);
			Grille.compteur++ ;
		}
			
		else {
			setBackground(Parametres.COULEUR_DEB);
			Grille.compteur-- ;
		}
			
	}
	
}
