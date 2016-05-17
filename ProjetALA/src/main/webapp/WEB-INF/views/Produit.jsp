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
	<!-- ------------------ FIN Barre de naviguation------------------ -->


	<!-- ------------------Affichage des produits de l'Hôtel ALA------------------ -->
	<div>
		<h2>Liste des produits de l'Hôtel ALA</h2>
		<div class="table-responsive">
			<table class="table table-striped">
			
				<th class="success">Identifiant</th>
				<th class="success">Nom</th>
				<th class="success">Prix</th>
				<th class="success">Description</th>
				<th class="success">Quantité</th>
				<th class="success">Modifier</th>
				<th class="success">Supprimer</th>
				
				<c:forEach items="${EntityProduit}" var="c">
					<tr>
						<td>${c.idProduit}</td>
						<td>${c.nomProduit}</td>
						<td>${c.prixProduit}</td>
						<td>${c.desrcriptionProduit}</td>
						<td>${c.quantitéProduit}</td>
						<td>
						
						<button type="submit" class="btn btn-default btn-sm">
  						<span class="glyphicon glyphicon-pencil"></span></button>
  						
  						</td>
						<td>
						<form action="deleteproduit" method="get">
						<button type="submit" class="btn btn-default btn-sm">
  						<span class="glyphicon glyphicon-trash"></span></button>
  						</form>
  						</td>
						
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- ------------------FIN Affichage des produits de l'Hôtel ALA------------------ -->



		<!-- ------------------Suppression des produits de l'Hôtel ALA------------------ -->
		<h2>Suppression d'un produit</h2>
		<form action="deleteproduit" method="get">
			<select id="select" name="idProduit">
				<c:forEach items="${EntityProduit}" var="c">
					<option value="${c.idProduit}">${c.nomProduit}</option>
				</c:forEach>
			</select> <input type="submit" value="Supprimer" />
		</form>
	</div>

	<!-- ------------------ FIN Suppression des produits de l'Hôtel ALA------------------ -->

	<!-- ------------------Modification des produits de l'Hôtel ALA------------------ -->
	<div>
		<h2>Modification d'un produit</h2>
		<f:form class="form-horizontal" action="mergeproduit" method="get"
			modelAttribute="model">
			<div class="form-group">

				<div class="col-xs-8">								
					<select id="select" name="idProduit">
						<c:forEach items="${EntityProduit}" var="c">
							<option value="${c.idProduit}">
							${c.nomProduit}
							${c.nomProduit}
							${c.prixProduit}
							${c.desrcriptionProduit}
							${c.quantitéProduit}
							</option>	
						</c:forEach>
						</select>
					</div>


				<div class="col-xs-8">
					<label class="control-label col-xs-1" for="Numero">Nom Produit</label>
					<f:input type="text" class="form-control" id="nomProduit"
						path="nomProduit" placeholder="nom produit"></f:input>
				</div>

				<div class="col-xs-8">
					<label class="control-label col-xs-1" for="Prix">Prix</label>
					<f:input type="number" class="form-control" id="prixProduit"
						path="prixProduit" placeholder="50.0"></f:input>
				</div>

				<div class="col-xs-8">
					<label class="control-label col-xs-1" for="Description">Description</label>
					<f:input type="text" class="form-control" id="desrcriptionProduit"
						path="desrcriptionProduit" placeholder="Produit"></f:input>
				</div>

				<div class="col-xs-8">
					<label class="control-label col-xs-1" for="Quantité">Quantité</label>
					<f:input type="number" class="form-control" id="quantitéProduit"
						path="quantitéProduit" placeholder="2"></f:input>
				</div>				
				<div class="col-xs-12">
					<button type="submit" class="btn btn-success">Modifier</button>
					<f:errors path="*"></f:errors>
				</div>

			
		</f:form>
	</div>

	<!-- ------------------ FIN Modification des produits de l'Hôtel ALA------------------ -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>