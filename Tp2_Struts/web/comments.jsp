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
<h4>Commentaires du livre <s:property value="livre.isbn" />[<s:property value="livre.titre" />] </h4>
<ul>
	<s:iterator value="commentaires">
         <li><s:property /></li>
	</s:iterator>
</ul>
Ajoutez un commentaire :
<s:form action="CommentBook">
 	  <s:textfield name="unCommentaire" label="Commentaire" required="true" />
 	  <s:hidden name="livre.isbn" />
  	  <s:submit value="Go"/>   	  
</s:form>	
</body>
</html>
