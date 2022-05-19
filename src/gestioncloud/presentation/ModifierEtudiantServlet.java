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

@WebServlet("/ModifierEtudiant")
public class ModifierEtudiantServlet extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		Double note=Double.parseDouble(request.getParameter("note"));
		Etudiant etudiant =new Etudiant(id,nom, prenom, note);
		IEtudiant service =new EtudiantDao();
		service.update(etudiant);
		response.sendRedirect("listerEtudiant");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
