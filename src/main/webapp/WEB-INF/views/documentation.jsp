<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>AIQS REST API</title>
    <link rel="shortcut icon" href='<c:url value="/resources/img/favicon.ico"/>'>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/highlight.default.css"/>'>
	<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/screen.css"/>'>

    <script src='<c:url value="/resources/js/swaggerjs/shred.bundle.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/jquery-1.8.0.min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/jquery.slideto.min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/jquery.wiggle.min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/jquery.ba-bbq.min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/handlebars-1.0.0.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/underscore-min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/backbone-min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/swagger.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/swagger-ui.min.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/highlight.7.3.pack.js"/>'></script>
    <script src='<c:url value="/resources/js/swaggerjs/swagger-oauth.js"/>'></script>


	<style type="text/css">
		
		body {
			margin-left: 30px;
			margin-right: 30px;
		}
	
	</style>

    <script type="text/javascript">
        $(document).ready(function () {

            displaySwaggerDocuments();

            function displaySwaggerDocuments() {
                var resourceUrl = '/aiqs/documentation/resourceList';
                window.swaggerUi = new SwaggerUi({
                    url: resourceUrl,
                    dom_id: "swagger-ui-container",
                    supportHeaderParams: false,
                    supportedSubmitMethods: ['get', 'post', 'put', 'delete'],
                    onComplete: function (swaggerApi, swaggerUi) {
                        if (console) {
                            console.log("Loaded SwaggerUI")
                            console.log(swaggerApi);
                            console.log(swaggerUi);
                        }
                        $('pre code').each(function (i, e) {
                            hljs.highlightBlock(e)
                        });
                        if(typeof initOAuth == "function")
                            initOAuth();
                    },
                    onFailure: function (data) {
                        if (console) {
                            console.log("Unable to Load SwaggerUI");
                            console.log(data);
                        }
                    },
                    docExpansion: "none"
                });

                $('#input_apiKey').change(function() {
                    var key = $('#input_apiKey')[0].value;
                    log("key: " + key);
                    if(key && key.trim() != "") {
                        log("added key " + key);
                        window.authorizations.add("key", new ApiKeyAuthorization("api_key", key, "query"));
                    }
                })
                window.swaggerUi.load();
            	
            }
            
             setTimeout(function() {
            	 
            	 $('a[href$="Controller"]').each(function() {
             		var text = $(this).text();
             		text = text.substring(text.lastIndexOf(".") + 1);
             		$(this).text(text);
             	})
            	
             //	 $('#resources_container').html("<br><br><br> <h4 align='center'>* * * * * * * * * * * *  CONTROLLERS  * * * * * * * * * * * *</h4> <br>" + $('#resources_container').html());
            	 
            	 $('div[class="footer"]').html("<br><br><br><br><i>Developed by : Siva Narayana Reddy</i><br><br>"); // to Hide the footer
            	 
            	/*  $('a[href="#"]').each(function() {
            		$(this).hide(); 
            	 });
            	 $('a').each(function() {
             		if($(this).text() == "Raw" || $(this).text() == "Show/Hide" ) $(this).hide(); 
             	 });
            	$('a[href^="#!/org.siva"]').each(function() {
            		var text = $(this).text();
            		text = text.substring(text.lastIndexOf(".") + 1);
            		$(this).text(text);
            	})  */
            }, 2000); // 500 millis to truncate the package-name and display only the class-name. 
            
        });
    </script>
</head>

<body>

<div id="message-bar" class="swagger-ui-wrap">
    &nbsp;
</div>

<div id="swagger-ui-container" class="swagger-ui-wrap">

</div>

</body>

</html>