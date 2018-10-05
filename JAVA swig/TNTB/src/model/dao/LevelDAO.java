package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Level;

public class LevelDAO extends DAO<Level> {

	@Override
	public Level findById(int id) {
		Level level =null;
		try {
			PreparedStatement prepare = connexion.prepareStatement("SELECT * FROM level WHERE id_level = ?") ;
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery() ;
			
			if(result.first()) {
				level = new Level(result.getString("libelle"),result.getInt("nbL"), result.getInt("nbC")) ;
			}
			result.close(); 
			prepare.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return level;
	}

	@Override
	public List<Level> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Level object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Level object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Level object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
