<%@page import="java.util.Collection"%>
<%@page import="gestioncloud.entitiers.Etudiant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    

<%
    Collection<Etudiant> etudiants = (Collection<Etudiant>)request.getAttribute("etudiant");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Etudiants</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
   <div class="panel panel-primary">
      <div class=" panel panel-heading"><h1 class="center">Liste des Etudiants</h1></div>
     
         <div class="panel-body">
     <a href="ajouterEtudiantForm" class="btn btn-primary">Créer</a>
    <br /> <br />
  
<table class="table table-striped">
  <thead>
       <tr scope="col">
		<th scope="col">Id</th>
		<th scope="col">Nom</th>
		<th scope="col">Prénom</th>
		<th scope="col">Note</th>
		<th scope="col"></th>
	  </tr>	
	 <thead>
<%
	for(Etudiant e : etudiants){
%>
	<tr>
		<th scope="row"><%=e.getId() %></th>
		<td><%=e.getNom() %></td>
		<td><%=e.getPrenom() %></td>
		<td><%=e.getNote() %></td>
		<td>
			<a href="modifierEtudiantForm.jsp?id=<%=e.getId() %>" class="btn btn-success">Modifier</a>
			<a href="supprimerEtudiant?id=<%=e.getId() %>" class="btn btn-danger">Supprimer</a>
		</td>
	</tr>
<%
	}
%>
</table>
  </div>
</div>
</div>
</body>
</html>