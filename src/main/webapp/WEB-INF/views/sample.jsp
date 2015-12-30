<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<!-- Note that this is functionally equivalent to using the HTML5 doctype. 
It places Internet Explorer into the highest supported document mode.
Refer :: https://msdn.microsoft.com/en-us/library/jj676915(v=vs.85).aspx
 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--
The initial-scale property controls the zoom level when the page is first loaded. 
The maximum-scale, minimum-scale, and user-scalable properties control how users are allowed to zoom the page in or out. 
 -->
<title>AIQS :: Login</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/plugins/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- HTML shim and Respond.js for IE8 support -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/dist/html5/html5shiv.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/dist/html5/respond.min.js"></script>
<![!endif]-->

</head>
<body>
	<h1>Bootstrap wired.. Bootstrap buttons :</h1>
	<p>
        <button type="button" class="btn btn-lg btn-default">Default</button>
        <button type="button" class="btn btn-lg btn-primary">Primary</button>
        <button type="button" class="btn btn-lg btn-success">Success</button>
        <button type="button" class="btn btn-lg btn-info">Info</button>
        <button type="button" class="btn btn-lg btn-warning">Warning</button>
        <button type="button" class="btn btn-lg btn-danger">Danger</button>
        <button type="button" class="btn btn-lg btn-link">Link</button>
    </p>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<!-- Include all compiled plugins(below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>