package controllers;

import java.sql.Timestamp;
import java.util.List;

import frames.Jeu;
import graphique.Grille;
import model.Gamer;
import model.Score;
import model.dao.DAO;
import model.dao.GamerDAO;
import model.dao.ScoreDAO;

public class ScoreController extends Controller{

	private static DAO<Score> scoreDAO = new ScoreDAO() ;
	private static DAO<Gamer> gamerDAO = new GamerDAO() ;
	
	public static void addNewScore(double duree) {
		Score score = new Score(duree,
				Grille.compteurClick,
				gamerDAO.findById(Jeu.cache.getGamerId()),
				Jeu.cache.getLevelId(),
				Jeu.cache.getStrategyId(),
				new Timestamp(System.currentTimeMillis())
		) ;		
		
		scoreDAO.insert(score) ;
		Jeu.updateScore();
		System.out.println("Nouveau score enregistré");
	}
	
	public static List<Score> getAllScores(){
		return scoreDAO.findAll() ;
	}
	
	public static void printScores() {
		for(Score score : scoreDAO.findAll()) {
			System.out.println(score.getGamer().getPseudo() + " ; " + score.getNbClick() + " ; " + score.getDureeSeconde() + " ; " + score.getLevel() + " ; " + score.getStrategy() + " ; " + score.getCreatedAt());
		}
			
	}
	
}
