package frames;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import controllers.ScoreController;
import ecrans.EcranAccueil;
import ecrans.EcranJeu;
import ecrans.EcranScore;
import ecrans.MainCard;
import model.Gamer;
import model.Score;
import model.Strategy;
import model.dao.DAO;
import model.dao.GamerDAO;
import model.dao.ScoreDAO;
import strategy.RegleCroix;
import strategy.RegleSimple;
import utilitaires.Parametres;
import utilitaires.SystemeCache;

public class Jeu extends JFrame {

	private EcranJeu ecranJeu ;
	private EcranAccueil ecranAccueil ;
	private static EcranScore ecranScore ;
	private Strategy regleSimple, regleCroix ;
	public static SystemeCache cache = new SystemeCache() ;
	public static MainCard cards ;
	public Jeu() {
		
		setTitle(Parametres.APP_NAME);
		setPreferredSize(Parametres.TAILLE_FENETRE_DEFAUT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cards = new MainCard() ;
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		cards.setBorder(padding);
		
		DAO<Gamer> gamerDAO = new GamerDAO() ;
		
		Gamer mamadou = new Gamer("mamadou") ;
		gamerDAO.insert(mamadou) ;
		
		
		cache.putGamerId(GamerDAO.findByPseudo(mamadou.getPseudo()).getId());
		cache.putGamerPseudo(mamadou.getPseudo());
		cache.putLevelId(1);
		
		List<Gamer> gamers = gamerDAO.findAll() ;				
		
		for(Gamer gamer : gamers) {
			System.out.println(gamer.toString());
		}
		
		ScoreController.printScores();
		
		ecranAccueil = new EcranAccueil(cards) ;
		ecranScore = new EcranScore(cards) ;
		ecranJeu = new EcranJeu(cards) ;
//		regleSimple = new RegleSimple(ecranJeu.getGrille()) ;
//		regleSimple.apply();
//		
		regleCroix = new RegleCroix(ecranJeu.getGrille()) ;
		regleCroix.apply();
		
		cards.showEcranAccueil();
		
		getContentPane().add(cards);
		pack() ;
		setVisible(true);
	}
	
	public static void updateScore() {
		ecranScore = new EcranScore(cards) ;
	}
}
