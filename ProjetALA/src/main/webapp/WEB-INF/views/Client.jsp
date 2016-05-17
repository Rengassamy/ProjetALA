<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Client</title>
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
					<li><a href="GestionChambre">Chambre</a></li>
					<li><a href="GestionFacture">Facture</a></li>
					<li class="dropdown"><a href="GestionClient"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Personne <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GestionClient">Employer</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GestionClient">Client<span class="sr-only">(current)</span></a></li>
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
<h1 class="text-center">Ajout employe ou client</h1>
	<div class="panel panel-default">
		<table class="table">
			<tr>
				<!-- Ajouter un client -->
				<td><f:form action="insertclient" method="get"
						modelAttribute="model">
						<table class="table">
							<th>Ajouter un client :</th>
							<tr>
								<td>Nom client:</td>
								<td><f:input type="text" path="nomPersonne"></f:input></td>
							</tr>
							<tr>
								<td>Prénom client:</td>
								<td><f:input type="text" path="prenom"></f:input></td>
							</tr>
							<tr>
								<td>Sex:</td>
								<td><f:input type="text" path="sex"></f:input></td>
							</tr>
							<tr>
								<td>Date de naissance:</td>
								<td><f:input type="date" path="dateNaissance"></f:input></td>

							</tr>
							<tr>
								<td>Adresse:</td>
								<td><f:input type="text" path="adresse"></f:input></td>
							</tr>
							<tr>
								<td>Telephone:</td>
								<td><f:input type="text" path="tel"></f:input></td>
							</tr>
							<tr>
								<td>email:</td>
								<td><f:input type="text" path="mail"></f:input></td>
							</tr>
							<tr>
								<td><f:button type="submit" class="btn btn-primary">Ajouter</f:button></td>
							</tr>
							<f:errors path="*"></f:errors>
						</table>
					</f:form></td>

				<!-- Ajouter un employer -->
				<td>
					<form action="insertemployer" method="get">
						<table class="table">
							<th>Ajouter un employer :</th>
							<tr>
								<td>Nom employer:</td>
								<td><input type="text" name="nomPersonne"></td>
							</tr>
							<tr>
								<td>Prénom employer:</td>
								<td><input type="text" name="prenom"></td>
							</tr>
							<tr>
								<td>Sex:</td>
								<td><input type="text" name="sex"></td>
							</tr>
							<tr>
								<td>Date de naissance:</td>
								<td><input type="text" name="dateNaissance"
									value="yyyy-MM-dd"></td>
							</tr>
							<tr>
								<td>Adresse:</td>
								<td><input type="text" name="adresse"></td>
							</tr>
							<tr>
								<td>Telephone:</td>
								<td><input type="text" name="tel"></td>
							</tr>
							<tr>
								<td>email:</td>
								<td><input type="text" name="mail"></td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
							</tr>
						</table>
					</form>

				</td>
			</tr>
		</table>
	</div>

	<!-- Liste des clients -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="text-center">Liste des clients</h3>
		</div>
		<table class="table table-striped">
			<tr class="danger">
				<td><b>Id</b></td>
				<td><b>Nom</b></td>
				<td><b>Prenom</b></td>
				<td><b>sex</b></td>
				<td><b>Date de naissance</b></td>
				<td><b>Adresse</b></td>
				<td><b>telephone</b></td>
				<td><b>email</b></td>
				<td><b>Operation</b></td>
			</tr>
			<c:forEach items="${EntityClient}" var="c">
				<tr>
					<td>${c.idPersonne}</td>
					<td>${c.nomPersonne}</td>
					<td>${c.prenom}</td>
					<td>${c.sex}</td>
					<td>${c.dateNaissance}</td>
					<td>${c.adresse}</td>
					<td>${c.tel}</td>
					<td>${c.mail}</td>
					<td><div class="btn-group">
  <button type="button" class="btn btn-primary">Operation</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="">Modifier</a></li>
    <li><a href="deleteclient?idClient=${c.idPersonne}">Supprimer</a></li>
  </ul>
</div></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- Liste des employés -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="text-center">Liste des employes</h3>
		</div>
		<table class="table table-striped">
			<tr class="danger">
				<td><b>Id</b></td>
				<td><b>Nom</b></td>
				<td><b>Prenom</b></td>
				<td><b>sex</b></td>
				<td><b>Date de naissance</b></td>
				<td><b>Adresse</b></td>
				<td><b>telephone</b></td>
				<td><b>email</b></td>
                <td><b>Operation</b></td>
			</tr>
			<c:forEach items="${EntityEmployer}" var="e">
				<tr>
					<td>${e.idPersonne}</td>
					<td>${e.nomPersonne}</td>
					<td>${e.prenom}</td>
					<td>${e.sex}</td>
					<td>${e.dateNaissance}</td>
					<td>${e.adresse}</td>
					<td>${e.tel}</td>
					<td>${e.mail}</td>	
				    <td><div class="btn-group">
  <button type="button" class="btn btn-primary">Operation</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="">Modifier</a></li>
    <li><a href="deleteemployer?idEmployer=${e.idPersonne}">Supprimer</a></li>
  </ul>
</div></td>
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