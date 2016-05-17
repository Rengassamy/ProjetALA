<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Disponibilité des chambres</title>
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home">Hotel ALA</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="GestionReservation">Reservation</a></li>
					<li class="dropdown"><a href="GestionChambre" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Chambres<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionChambre">Gestion des chambres</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="getdispochambre">Dispo des chambres</a></li>
						</ul></li>
					<li><a href="GestionFacture">Facture</a></li>
					<li class="dropdown"><a href="GestionClient" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Personne <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionClient">Employer</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GestionClient">Client</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
							<li><a href="https://docs.oracle.com/javase/7/docs/api/">Help</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<h1>Consultation des disponibilités de l'hotel</h1>
	<form class="form-inline" action="getdispochambre" method="get">
		<label for="datedeb">Date début</label> <input type="text"
			class="form-control" id="datedeb" name="datedeb"
			placeholder="2000/01/01"></input> <label for="datefin">Date
			fin</label> <input type="text" class="form-control" id="datefin"
			name="datefin" placeholder="2000/01/01"></input> <label
			for="nbrepers">Nombre de personne</label> <input type="number"
			class="form-control" id="nbrepers" name="nbrepers"></input> <input
			type="submit" class="btn btn-success" value="Rechercher" /> 
			<span class="exception">${exc.exception}</span>
	</form>
	<!-- Affichage du résultat -->
	<h2>Chambre(s) disponible(s)</h2>
	<div class="table-responsive">
		<table class="table table-striped">
			<th class="success">Identifiant</th>
			<th class="success">Numéro</th>
			<th class="success">Description</th>
			<th class="success">Capacité</th>
			<th class="success">Prix</th>
			<c:forEach items="${EntityChambre2}" var="ch">
				<tr>
					<td>${ch.idChambre}</td>
					<td>${ch.numchambre}</td>
					<td>${ch.description}</td>
					<td>${ch.capacite}</td>
					<td>${ch.prix}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>