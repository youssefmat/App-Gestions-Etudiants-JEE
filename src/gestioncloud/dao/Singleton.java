package gestioncloud.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
	private static Singleton uniqueInstance;
    private Singleton() {
   	 
    }
    
    public static Singleton getInstance() {
   	 if(uniqueInstance==null) {
   		 uniqueInstance= new Singleton();
   	 }
   	 return uniqueInstance;
    }
    
    public Connection getConnection() {
   	 Connection conn=null;
   	 try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/mastercloud","root","");
		} catch (Exception ex) {
			System.out.println("Erreur connexion !:"+ex.getMessage());
		}
   	 return conn;
    }
}
