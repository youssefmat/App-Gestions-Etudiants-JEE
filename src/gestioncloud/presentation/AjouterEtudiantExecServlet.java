package gestioncloud.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioncloud.dao.EtudiantDao;
import gestioncloud.entitiers.Etudiant;
import gestioncloud.metier.IEtudiant;

@WebServlet("/ajouterEtudiantExec")
public class AjouterEtudiantExecServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		Double note=Double.parseDouble(request.getParameter("note"));
		Etudiant etudiant =new Etudiant(nom, prenom, note);
		IEtudiant service =new EtudiantDao();
		service.add(etudiant);
		response.sendRedirect("listerEtudiant");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
