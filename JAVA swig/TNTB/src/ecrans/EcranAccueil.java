package ecrans;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utilitaires.Parametres;

public class EcranAccueil extends Ecran {

	private JLabel title ;
	private JButton partie ;
	private JButton scores ;
	private JButton reglages ;
	private JButton aPropos ;
	
	public EcranAccueil(MainCard mainCard) {
		this.mainCard = mainCard ;
		this.mainCard.add(this,MainCard.ECRAN_HOME_KEY) ;
		buildComlponent();
		addListener();
	}
	
	private void buildComlponent() {
		title = new JLabel(Parametres.APP_NAME) ;
		title.setForeground(Color.BLACK);
		title.setFont(new Font(title.getFont().getFontName(), Font.BOLD,30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		
		partie = new JButton("Nouvelle Partie") ;
		partie.setBackground(Color.GRAY);
		
		scores = new JButton("Afficher les scores") ;
		scores.setBackground(Color.gray);
		
		reglages = new JButton("Paramètres") ;
		reglages.setBackground(Color.GRAY);
		
		aPropos = new JButton("A Propos") ;
		aPropos.setBackground(Color.GRAY);
		
		setLayout(new BorderLayout());
		
		GridLayout layoutMenu = new GridLayout(4, 1) ;
		layoutMenu.setVgap(30);
		JPanel center = new JPanel(layoutMenu) ;
		
		center.add(partie) ;
		center.add(scores) ;
		center.add(reglages);
		center.add(aPropos);
		
		add(title, BorderLayout.NORTH) ;
		add(center,BorderLayout.CENTER) ;
	}
	
	public void addListener() {
		partie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainCard.showEcranJeu();
			}
		});
		
		scores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainCard.showEcranScore();
			}
		});
	}
}
