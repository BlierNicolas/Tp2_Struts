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
<h4>Liste des livres</h4>
<table border="1" cellspacing="0">
     <tr>
         <th>ISBN</th>
         <th>Titre</th>
         <th>Auteur(s)</th>
     </tr>
<s:iterator value="bookList">
     <tr>
         <td><s:property value="isbn" /></td>
         <td><s:property value="titre" /></td>
         <td><s:property value="auteur" /></td>
         <td>
	        <s:url id="url" action="CommentBook">
	        <s:param name="livre.isbn"><s:property value="isbn" /></s:param>
	        </s:url>
	        <s:a href="%{url}">Commentaires</s:a>
         </td>
     </tr>
</s:iterator>
</table>
<s:url id="url" action="AddBook" />
<s:a href="%{url}">Ajouter un livre</s:a>
</body>
</html>
