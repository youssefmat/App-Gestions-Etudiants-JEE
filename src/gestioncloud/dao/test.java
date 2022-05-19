package gestioncloud.dao;

import java.util.Collection;

import gestioncloud.entitiers.Etudiant;
import gestioncloud.metier.IEtudiant;

public class test {

	public static void main(String[] args) {
		IEtudiant service =new EtudiantDao();
		Collection<Etudiant> etudiants = service.findAll();
		for(Etudiant e : etudiants){
		System.out.println("ID: "+ e.getId()+" Nom: "+e.getNom()+" Prenom: "+e.getPrenom()+" Note: "+e.getNote());
	
		
		}
		
	}

}
