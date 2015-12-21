<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="not #session['connecte']">
<jsp:forward page="login.jsp"></jsp:forward>
</s:if>
<html>
<head>
    <title>MyBooKs</title>
</head>

<body>
<h3>MyBooKs manager</h3>
<s:include value="menu.jsp"></s:include>	
Ajoutez un nouvel exemplaire :
<s:actionmessage/>
<s:form action="AddExemplaire">
        <s:textfield name="exemplairePK.isbn" label="ISBN" required="true" />
        <s:textfield name="exemplairePK.numero" label="Numero" required="true" />
        <s:textfield name="exemplaire.proprietaire" label="Proprietaire" required="true" />
        <s:textfield name="exemplaire.detenteur" label="Detenteur" />
        <s:submit value="Ajouter"/>   	  
</s:form>	
</body>
</html>
