<%-- 
    Document   : index
    Created on : May 14, 2019, 8:04:57 PM
    Author     : Hicham
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JMS Test Page</title>
    </head>
    <body>
        <h1>JMS Test page</h1>
        <form action="${pageContext.request.contextPath}/MyServlet" method="post">
            <div>
                <label>Enter your message: </label>        
                <input type="text" name="message" />
                <input type="submit" name="submit" value="Send" />
            </div>
        </form>
    </body>
</html>
