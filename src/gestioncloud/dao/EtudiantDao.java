package gestioncloud.dao;
//v1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import gestioncloud.entitiers.Etudiant;
import gestioncloud.metier.IEtudiant;

public class EtudiantDao implements IEtudiant{

	@Override
	public Etudiant findOne(int id) {
		Etudiant etudiant =null;
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm = conn.prepareStatement("select * from etudiant where id=?");
			stm.setInt(1,id);
			ResultSet result = stm.executeQuery(); 
			if(result.next()) {
				String nom=result.getString("nom");
				String prenom=result.getString("prenom");
				double note=result.getDouble("note");
				etudiant=new Etudiant(id, nom, prenom, note);
			}
			
			
		} catch (Exception ex) {
			System.out.println("Erreur SQL:"+ex.getMessage());
		}
		return etudiant;
	}

	@Override
	public  Collection<Etudiant> findAll() {
		Collection<Etudiant> etudiants =new ArrayList<Etudiant>();
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm= conn.prepareStatement("select * from etudiant");
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				int id=result.getInt("id");
				String nom=result.getString("nom");
				String prenom=result.getString("prenom");
				double note=result.getDouble("note");
				Etudiant etudiant =new Etudiant(id, nom, prenom, note);
				etudiants.add(etudiant);
			}
		} catch (Exception e) {
			System.out.println("Erreur SQL:"+e.getMessage());
		}
		return etudiants;
	}

	@Override
	public void add(Etudiant etudiant) {
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm =conn.prepareStatement("INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `note`) VALUES (NULL, ?, ?, ?)");
			stm.setString(1,etudiant.getNom());
			stm.setString(2, etudiant.getPrenom());
			stm.setDouble(3, etudiant.getNote());
			stm.execute();
		} catch (Exception e) {
			System.out.println("Erreur d'ajouter en SQL:"+e.getMessage());
		}
		
	}

	@Override
	public void update(Etudiant etudiant) {
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm =conn.prepareStatement("Update etudiant set nom=? ,prenom=? ,note=? where id=?");
			stm.setString(1, etudiant.getNom());
			stm.setString(2, etudiant.getPrenom());
			stm.setDouble(3, etudiant.getNote());
			stm.setInt(4, etudiant.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println("Erreur de modification en SQL:"+e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm=conn.prepareStatement("Delete from etudiant where id=?");
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			System.out.println("Erreur:"+e.getMessage());
		}
		
	}

}
