package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Gamer;

public class GamerDAO extends DAO<Gamer>{

	public static final String COLUMN_ID = "id_gamer" ;
	public static final String COLUMN_PSEUDO = "pseudo" ;
	public static final String COLUMN_CREATED_AT = "created_at" ; 
	public static final String TABLE_NAME = "gamer" ;
	
	@Override
	public Gamer findById(int id) {
		Gamer gamer = null  ;
		try {
			String sql = "SELECT * FROM gamer WHERE id_gamer = ? " ;
			PreparedStatement prepare = connexion.prepareStatement(sql) ;
			prepare.setInt(1, id);
			
			ResultSet result = prepare.executeQuery() ;
			
			if(result.first()) {
				gamer = new Gamer(result) ;
			}
			result.close();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return gamer;
	}
	
	public static Gamer findByPseudo(String pseudo) {
		Gamer gamer = null  ;
		try {
			String sql = "SELECT * FROM gamer WHERE pseudo = ? " ;
			PreparedStatement prepare = connexion.prepareStatement(sql) ;
			prepare.setString(1, pseudo);
			
			ResultSet result = prepare.executeQuery() ;
			
			if(result.first()) {
				gamer = new Gamer(result) ;
			}
			result.close();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return gamer;
	}
	
	private boolean exists(String pseudo) {
		
		boolean res = false ;
		
		try {
			String sql = "SELECT * FROM gamer WHERE pseudo = ? " ;
			PreparedStatement prepare = connexion.prepareStatement(sql) ;
			prepare.setString(1, pseudo);
			
			ResultSet result = prepare.executeQuery() ;
			
			res = result.first() ;
					
			result.close();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return res ;
	}

	@Override
	public List<Gamer> findAll() {
		List<Gamer> gamers = new ArrayList<Gamer>() ;
		String sql = "SELECT * FROM " + TABLE_NAME ;
		
		try {
			Statement state = connexion.createStatement() ;
			ResultSet result = state.executeQuery(sql) ;
			
			while(result.next()) {
				gamers.add(new Gamer(result)) ;
			}			
			result.close(); 
			state.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gamers;
	}

	@Override
	public int insert(Gamer gamer) {
		String sql = "INSERT INTO gamer(pseudo) VALUES (?)" ;
		int nbLignes = 0 ;
		
		if(exists(gamer.getPseudo()))
			return -1 ;
		
		try {
			PreparedStatement prepare = connexion.prepareStatement(sql) ;
			prepare.setString(1, gamer.getPseudo());			
			nbLignes = prepare.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nbLignes ;
	}

	@Override
	public int delete(Gamer object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Gamer object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
