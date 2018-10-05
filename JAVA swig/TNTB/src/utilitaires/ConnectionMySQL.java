package utilitaires;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL implements ConnectionBDD {

	private static final String user = "nsele";
	private static final String mdp  = "dWD-mcx-R4t-NCe";
	private static final String host = "//mysql-nsele.alwaysdata.net:3306/";
	private static final String databaseName = "nsele_tntb" ; 
	private static final String optionsConnection = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ;
	
	// L'url complète de connexion
	private static final String url = "jdbc:mysql:" + host + databaseName + optionsConnection;
		
	private static Connection instance = null ;
	
	private ConnectionMySQL() {
	}
	
	public static Connection getInstance() {
		
		if(instance == null) {
			synchronized (ConnectionMySQL.class) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver") ;
					System.out.println("Driver chargé");
					
					instance = DriverManager.getConnection(url, user, mdp);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}			
		}
		
		return instance;
	}
}
