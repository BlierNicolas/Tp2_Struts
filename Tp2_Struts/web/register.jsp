<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>MyBooKs</title>
</head>

<body>
<h3>Correction Labo Struts 2 :</h3>
<ul>
    <li>
        <s:url id="url" action="connexion/Login">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="connexion/Login">
            <s:param name="request_locale">fr</s:param>
        </s:url>
        <s:a href="%{url}">Français</s:a>
    </li>
</ul>
<s:text name="Form.registration.title" />
<s:form action="Register">
 	  <s:textfield name="username" label="%{getText('username')}" required="true" />
 	  <s:textfield name="password" label="%{getText('password')}" required="true" />
  	  <s:submit value="Register"/>   	  
</s:form>	
    <li>
        <s:url id="url" action="Login" />
        <s:a href="%{url}"><s:text name="Form.login.title" /></s:a>
    </li>

</body>
</html>
