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
<table>
	<s:iterator value="evaluation">
            <tr>
                <td><s:property value="note"/> </td>
                <td><s:property value="commentaire"/> </td>>
            </tr>
	</s:iterator>
</table>

<s:form action="Evaluer">
 	 
Ajouter une note : 
    <select name="uneNote" required>
        <option selected>0</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
    </select> <br> <br>
Ajoutez un commentaire :
 <s:textfield name="unCommentaire" label="Commentaire" required="true" />
 <s:hidden name="livre.isbn" />
 

     <select name="unCours">
         <option>General</option>
         <s:iterator value="ListeCours">
         <option><s:property value="numero"/> </option>
         </s:iterator>
     </select>
<s:submit value="Go"/>   	  
</s:form>
</body>
</html>
