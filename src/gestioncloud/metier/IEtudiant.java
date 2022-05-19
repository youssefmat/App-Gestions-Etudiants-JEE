package gestioncloud.metier;

import java.util.Collection;

import gestioncloud.entitiers.Etudiant;

public interface IEtudiant {
	public Etudiant findOne(int id);
    public Collection<Etudiant> findAll();
    public void add(Etudiant etudiant);
    public void update(Etudiant etudiant);
    public void delete(int id);
}
