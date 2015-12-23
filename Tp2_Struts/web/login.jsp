<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Tp2 - Struts 2</title>
    </head>

    <body>
        <h3>Tp2 - Struts 2</h3>

        <s:text name="Connexion" />
        <s:form action="connexion/Login">
                  <s:textfield name="username" label="Nom d'utilisateur: " required="true" />
                  <s:textfield name="password" label="Mot de passe: " required="true" />
                  <s:submit value="Connexion"/>   	  
        </s:form>
    </body>
</html>
