<%@page import="gestioncloud.dao.EtudiantDao"%>
<%@page import="gestioncloud.metier.IEtudiant"%>
<%@page import="gestioncloud.entitiers.Etudiant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<body>


<%  
       int id=Integer.parseInt(request.getParameter("id"));
       IEtudiant  service =new EtudiantDao();
       Etudiant etudiant=service.findOne(id);
    
%>
<div class="container">
  <div class="panel panel-primary">
     <div class="panel-heading"><h1>Modifier d'un étudiant</h1></div>
     <div class="panel-body">
       <form action="ModifierEtudiant" method="get">
 <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">ID</label>
    <div class="col-sm-6">
      <input value="<%=etudiant.getId() %>" readonly="readonly" type="text" name="id"  class="form-control" id="id" placeholder="Id">
    </div>
  </div>
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-6">
      <input value="<%=etudiant.getNom() %>" type="text" name="nom"  class="form-control" id="nom" placeholder="Nom">
    </div>
  </div>
  <div class="form-group row">
    <label for="prenom" class="col-sm-2 col-form-label">Prénom</label>
    <div class="col-sm-6">
      <input value="<%=etudiant.getPrenom() %>" type="text" name="prenom" class="form-control" id="prenom" placeholder="Prénom">
    </div>
  </div>
  <div class="form-group row">
    <label  for="note" class="col-sm-2 col-form-label">Note</label>
    <div class="col-sm-6">
      <input value="<%=etudiant.getNote() %>" type="text" name="note" class="form-control" id="note" placeholder="Note">
       <br /> 
      <button type="submit" id=<%=etudiant.getId() %>" class="btn btn-danger mb-2">Modifier</button>
    </div>
  </div>
</form>
     </div>
  </div>
</div>
</body>
</html>