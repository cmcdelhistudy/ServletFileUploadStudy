<%-- 
    Document   : showPage
    Created on : Apr 26, 2013, 6:53:32 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        String imagePath=(String)request.getAttribute("imagePath");
        %>

        
        
        
        <img src="/images/<%=imagePath%>"  width="700" height="500" alt="<%=imagePath %>"/>



    </body>
</html>
