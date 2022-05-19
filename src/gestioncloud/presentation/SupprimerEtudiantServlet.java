package gestioncloud.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioncloud.dao.EtudiantDao;
import gestioncloud.metier.IEtudiant;

/**
 * Servlet implementation class SupprimerEtudiantServlet
 */
@WebServlet("/supprimerEtudiant")
public class SupprimerEtudiantServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		IEtudiant service =new EtudiantDao();
		service.delete(id);
		response.sendRedirect("listerEtudiant");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
