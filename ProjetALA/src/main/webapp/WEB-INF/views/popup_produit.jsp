<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Nouveau Produit</title>
</head>
<body>

	<!-- ------------------Ajout des produits de l'Hôtel ALA------------------ -->
	<div>
		<h2>Ajout d'un produit</h2>
		<f:form class="form-horizontal" action="insertproduit" method="get"
			modelAttribute="model">
			<div class="form-group">

				<div class="col-xs-8">
					<label class="control-label col-xs-1" for="Numero">Nom</label>
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
					<label class="control-label col-xs-1" for="idDevis">Identifiant
						du devis</label> <select id="select" name="idDevis">
						<c:forEach items="${EntityDevis}" var="d">
							<option value="${d.idDevis}">${d.idDevis}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-12">
					<button type="submit" class="btn btn-success">Ajouter</button>
					<f:errors path="*"></f:errors>
				</div>


			</div>
		</f:form>
	</div>
	<div>
		<!-- ------------------FIN Ajout des produits de l'Hôtel ALA------------------ -->


</body>
</html>