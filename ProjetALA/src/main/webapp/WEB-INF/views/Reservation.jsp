<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Gestion des réservations</title>
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
					<li class="active"><a href="GestionReservation">Reservation<span
							class="sr-only">(current)</span></a></li>
					<li><a href="GestionChambre">Chambre</a></li>
					<li><a href="GestionFacture">Facture</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Personne <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Employe</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Client</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
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
	<div>
		<h1>Affichage des réservations de l'Hôtel ALA</h1>
		<div class="table-responsive">
			<table class="table table-striped">
				<th class="info">Identifiant</th>
				<th class="info">Date de début</th>
				<th class="info">Date de fin</th>
				<th class="info">Etat</th>
				<th class="info">Client</th>
				<th class="info">Employe</th>
				<c:forEach items="${EntityReservation}" var="r">
					<tr>
						<td>${r.idReservation}</td>
						<td>${r.datedebut}</td>
						<td>${r.datefin}</td>
						<td>${r.etatresa}</td>
						<td>${r.client}</td>
						<td>${r.employe}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div>
		<h1>Ajout d'une réservation</h1>
		<form class="form-inline" action="insertreservation" method="get">
			<div class="form-group">
				<label for="DateDebut">Date de Début</label>
				<input type="Date" class="form-control" id="datedebut"
					name="datedebut" placeholder="01/01/2016"></input>
				<label for="Date fin">Date de fin</label>
				<input type="Date" class="form-control" id="datefin"
					name="datefin" placeholder="01/01/2016"></input>
				<label for="Etat">Etat</label>
				<input type="text" class="form-control" id="etatresa"
					name="etatresa" placeholder="A valider"></input>
				<label for="idClient">Nom du client</label> <select
					id="select" name="idClient">
					<c:forEach items="${EntityClient}" var="cl">
						<option value="${cl.idPersonne}">${cl.nomPersonne}</option>
					</c:forEach>
				</select>
				<label for="idEmploye">Nom de l'employé</label> <select
					id="select" name="idEmploye">
					<c:forEach items="${EntityEmploye}" var="e">
						<option value="${e.idPersonne}">${e.nomPersonne}</option>
					</c:forEach>
				</select>
				<label for="idchambre">Numéro de la chambre</label>
				<select id="select" name="idChambre">
					<c:forEach items="${EntityChambre}" var="c">
						<option value="${c.idChambre}">${c.numchambre}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-info">Ajouter</button>
			</div>
		</form>
	</div>
	<div>
		<h1>Suppression d'une réservation</h1>
		<form action="deletereservation" method="get">
			<select id="select" name="idReservation">
				<c:forEach items="${EntityReservation}" var="r">
					<option value="${r.idReservation}">${r.idReservation}</option>
				</c:forEach>
			</select> <input type="submit" value="Supprimer" />
		</form>
	</div>
	<div>
		<h1>Affichage des réservation d'un client</h1>
		<form action="getresabyclient" method="get">
			<select id="select" name="idClient">
				<c:forEach items="${EntityClient}" var="cl">
					<option value="${cl.idPersonne}">${cl.nomPersonne}</option>
				</c:forEach>
			</select> <input type="submit" value="Rechercher" />
		</form>
		<div class="table-responsive">
			<table class="table table-striped">
				<th class="info">Identifiant</th>
				<th class="info">Date de début</th>
				<th class="info">Date de fin</th>
				<th class="info">Etat</th>
				<c:forEach items="${EntityReservationbyCli}" var="r">
					<tr>
						<td>${r.idReservation}</td>
						<td>${r.datedebut}</td>
						<td>${r.datefin}</td>
						<td>${r.etatresa}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
<div>
		<h1>Affichage des réservation d'un employe</h1>
		<form action="getresabyemploye" method="get">
			<select id="select" name="idEmploye">
				<c:forEach items="${EntityEmploye}" var="e">
					<option value="${e.idPersonne}">${e.nomPersonne}</option>
				</c:forEach>
			</select> <input type="submit" value="Rechercher" />
		</form>
		<div class="table-responsive">
			<table class="table table-striped">
				<th class="info">Identifiant</th>
				<th class="info">Date de début</th>
				<th class="info">Date de fin</th>
				<th class="info">Etat</th>
				<c:forEach items="${EntityReservationbyEmp}" var="r">
					<tr>
						<td>${r.idReservation}</td>
						<td>${r.datedebut}</td>
						<td>${r.datefin}</td>
						<td>${r.etatresa}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>