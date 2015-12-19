<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="not #session['connecte']">
<jsp:forward page="login.jsp"></jsp:forward>
</s:if>
<html>
<head>
    <title>Tp2_Struts</title>
</head>

<body>
<h3>Gestionnaire de livres</h3>

<s:include value="menu.jsp"></s:include>	
Utilisez le menu pour accéder aux fonctionnalités.

</body>
</html>
