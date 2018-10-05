package graphique;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import utilitaires.Parametres;

public class Grille extends JPanel {
	
	private final GridLayout layout;
	public static int compteur = 0 , compteurClick = 0;
	
	
	private Case[][] cases ;
	
	public Grille() {
		layout = new GridLayout(Parametres.NB_L_DEFAUT, Parametres.NB_C_DEFAUT) ;
		cases = new Case[Parametres.NB_L_DEFAUT][Parametres.NB_C_DEFAUT] ;
		initGrille() ;
	}
	
	public Grille(int nb_lignes, int nb_colonnes) {
		layout = new GridLayout(nb_lignes, nb_colonnes) ;
		cases = new Case[nb_lignes][nb_colonnes] ;
		initGrille();
	}
	
	private void initGrille() {
		setLayout(layout);
		for(int i = 0 ; i < cases.length ; i++) {
			for(int j = 0 ; j < cases[0].length ; j++) {
				Case uneCase = new Case(i,j) ;
				uneCase.setBackground(Parametres.COULEUR_DEB);
				cases[i][j] = uneCase ;
				add(uneCase) ;
			}
		}
	}

	public Case[][] getCases() {
		return cases;
	}

	public Case getCaseIJ(int i, int j) {
		return cases[i][j] ;
	}
	
	public Case getCaseGauche(Case source) {
		Case gauche = null ;
		if(source.getJ()-1 >= 0)
			gauche = cases[source.getI()][source.getJ()-1] ;
		return gauche ;
	}
	
	public Case getCaseDroite(Case source) {
		Case droite = null ;
		if(source.getJ()+1 < cases[0].length)
			droite = cases[source.getI()][source.getJ()+1] ;
		return droite ;
	}
	
	public Case getCaseHaut(Case source) {
		Case haut = null ;
		if(source.getI()-1 >= 0)
			haut = cases[source.getI()-1][source.getJ()] ;
		return haut ;
	}
	
	public Case getCaseBas(Case source) {
		Case bas = null ;
		if(source.getI()+1 < cases.length)
			bas = cases[source.getI()+1][source.getJ()] ;
		return bas ;
	}
	
	public void reset() {
		compteur = 0 ;
		compteurClick = 0 ;
		for(int i = 0 ; i < cases.length ; i++) {
			for(int j = 0 ; j < cases[0].length ; j++) {
				cases[i][j].setBackground(Parametres.COULEUR_DEB);				
			}
		}
	}
	
	public void decoration() {
		for(int i = 0 ; i < cases.length ; i++) {
			for(int j = 0 ; j < cases[0].length ; j++) {
				if(i % 2 == 0) {
					if(j%2 == 0)
						cases[i][j].setBackground(Color.RED);
					else
						cases[i][j].setBackground(Color.WHITE);
				}
				else {
					if(j%2 == 0)
						cases[i][j].setBackground(Color.WHITE);
					else
						cases[i][j].setBackground(Color.RED);
				}
			}
		}
	}
	
}
