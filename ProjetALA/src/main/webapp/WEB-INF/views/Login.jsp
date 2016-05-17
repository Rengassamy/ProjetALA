<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/accueil.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<title>Login</title>
</head>
<body class="containeracceuil">

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Login</h1>
				<div class="account-wall">


					<form class="form-signin" action="j_spring_security_check"
						method="post">
						<input type="text" class="form-control" name="j_username"
							placeholder="pseudo" required autofocus> 
					    <input type="password" class="form-control" name="j_password"
							placeholder="mot de passe" required>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		<p>votre mot de passe est incorrect!!</p>

	</c:if>

</body>
</html>