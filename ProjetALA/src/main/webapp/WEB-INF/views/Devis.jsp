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

	<!-- ------------------Barre de naviguation------------------ -->
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

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Reservation <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionChambre">Chambre</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GestionProduit">Produit</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GestionReservation">Reservation</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Paiement <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionDevis">Devis</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GestionFacture">Facture</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Personne <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionClient">Employe</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GestionClient">Client</a></li>
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
	<!-- ------------------ FIN Barre de naviguation------------------ -->


	<!-- ------------------Affichage des Devis de l'Hôtel ALA------------------ -->
	<div>
		<h1>Affichage des Devis de l'Hôtel ALA</h1>
		<div class="table-responsive">
			<table class="table table-striped">
				<th class="success">Identifiant Devis</th>
				<th class="success">Identifiant Reservation</th>
				<th class="success">Nom Client</th>
				<!-- <th class="success">Produit</th> -->


				<c:forEach items="${EntityDevis}" var="d">
					<%-- 	<c:forEach items="${d.reservation}" var="dr">
						<c:forEach items="${dr.client}" var="drc">
							<c:forEach items="${d.listProduit}" var="dl"> --%>
					
					<tr>
						<td>${d.idDevis}</td>
						<td>${d.reservation.idReservation}</td>
						<td>${d.reservation.client.nomPersonne}</td>
						<td>	
						<table class="table table-striped">
						<th class="success">Identifiant Produit</th>
						<th class="success">Nom Produit</th>
						<th class="success">Prix Produit</th>
						<th class="success">Description Produit</th>
						<th class="success">Nom Produit</th>
							<c:forEach items="${d.listProduit}" var="dl">
								<tr>
									<td>${dl.idProduit}</td>
									<td>${dl.nomProduit}</td>
									<td>${dl.prixProduit}</td>
									<td>${dl.desrcriptionProduit}</td>
									<td>${dl.quantitéProduit}</td>
								</tr>

							</c:forEach></table>
						</td>	

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- ------------------FIN Affichage des devis de l'Hôtel ALA------------------ -->

	<!-- ------------------Ajout de devis de l'Hôtel ALA------------------ -->
	<div>
		<h1>Ajout d'un produit</h1>
		<f:form class="form-inline" action="insertDevis" method="get"
			modelAttribute="model">
			<div class="form-group">
				<label for="idReservation">Identifiant de la Reservation</label>
				<f:input type="number" class="form-control"
					id="Reservation.idReservation" path="Reservation.idReservation"
					placeholder="1"></f:input>
				<%-- 				<div class="col-xs-12">
					<label class="control-label col-xs-1" for="idDevis">Identifiant
						du devis</label> <select id="select" name="idDevis">
						<c:forEach items="${EntityDevis}" var="d">
							<option value="${d.idDevis}">${d.idDevis}</option>
						</c:forEach>
					</select>
 --%>


				<button type="submit" class="btn btn-success">Ajouter</button>
				<f:errors path="*"></f:errors>
			</div>
		</f:form>
	</div>
	<div>
		<!-- ------------------FIN Ajout des Devis de l'Hôtel ALA------------------ -->

		<!-- ------------------Suppression des Devis de l'Hôtel ALA------------------ -->
		<h1>Suppression d'un produit</h1>
		<form action="deleteDevis" method="get">
			<select id="select" name="idDevis">
				<c:forEach items="${EntityDevis}" var="c">
					<option value="${c.idDevis}">${c.idDevis}</option>
				</c:forEach>
			</select> <input type="submit" value="Supprimer" />
		</form>
	</div>

	<!-- ------------------ FIN Suppression des Devis de l'Hôtel ALA------------------ -->
	
	

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>