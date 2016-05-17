<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Gestion des chambres</title>
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
					<li class="dropdown"><a href="GestionChambre"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Chambres<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionChambre">Gestion des chambres</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="getdispochambre">Dispo des chambres</a></li>
						</ul></li>
					<li><a href="GestionFacture">Facture</a></li>
					<li class="dropdown"><a href="GestionClient"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Personne <span
							class="caret"></span></a>
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
							<li><a href="#">Separated link<span class="glyphicon glyphicon-off" aria-hidden=true></span></a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<h1>Bienvenue dans la partie de gestion des chambres de l'Hôtel
		ALA</h1>

	<div class="panel-group" id="accordion" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingOne">
				<h4 class="panel-title">
					<a role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne"> Affichage des chambres de l'Hôtel
						ALA </a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in"
				role="tabpanel" aria-labelledby="headingOne">
				<div class="panel-body">
					<h1>Affichage des chambres de l'Hôtel ALA</h1>
					<div class="table-responsive">
						<table class="table table-striped">
							<th class="success">Identifiant</th>
							<th class="success">Numéro</th>
							<th class="success">Description</th>
							<th class="success">Capacité</th>
							<th class="success">Prix</th>
							<c:forEach items="${EntityChambre}" var="c">
								<tr>
									<td>${c.idChambre}</td>
									<td>${c.numchambre}</td>
									<td>${c.description}</td>
									<td>${c.capacite}</td>
									<td>${c.prix}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
						data-parent="#accordion" href="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo">Ajout d'une chambre </a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
				aria-labelledby="headingTwo">
				<div class="panel-body">
					<f:form class="form-inline" action="insertchambre" method="post"
						modelAttribute="model">
						<div class="form-group">
							<label for="Numero">Numéro</label>
							<f:input type="text" class="form-control" id="numchambre"
								path="numchambre" placeholder="123"></f:input>
							<label for="Description">Description</label>
							<f:input type="text" class="form-control" id="description"
								path="description" placeholder="Chambre"></f:input>
							<label for="Capacite">Capacité</label>
							<f:input type="number" class="form-control" id="capacite"
								path="capacite" placeholder="2"></f:input>
							<label for="Prix">Prix</label>
							<f:input type="Double" class="form-control" id="prix" path="prix"
								placeholder="50.0"></f:input>
							<button type="submit" class="btn btn-success">Ajouter</button>
							<f:errors path="*"></f:errors>
						</div>
					</f:form>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingThree">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
						data-parent="#accordion" href="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree">
						Suppression d'une chambre </a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="headingThree">
				<div class="panel-body">
					<h1>Suppression d'une chambre</h1>
					<form action="deletechambre" method="get">
						<select id="select" name="idChambre">
							<c:forEach items="${EntityChambre}" var="c">
								<option value="${c.idChambre}">${c.numchambre}</option>
							</c:forEach>
						</select> <input type="submit" class="btn btn-success" value="Supprimer" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>