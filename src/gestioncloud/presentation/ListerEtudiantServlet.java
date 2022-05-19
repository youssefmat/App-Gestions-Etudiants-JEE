package gestioncloud.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioncloud.dao.EtudiantDao;
import gestioncloud.entitiers.Etudiant;
import gestioncloud.metier.IEtudiant;

@WebServlet("/listerEtudiant")
public class ListerEtudiantServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IEtudiant service =new EtudiantDao();
		Collection<Etudiant> etudiants = service.findAll();
		request.setAttribute("etudiant", etudiants);
		request.getRequestDispatcher("listerEtudiant.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
