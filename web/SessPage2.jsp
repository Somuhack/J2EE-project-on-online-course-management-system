<%-- 
    Document   : SessPage1
    Created on : May 13, 2023, 2:40:46 AM
    Author     : arind
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            String vname;
            %>
        <%
            HttpSession sess = request.getSession(false);
            if(sess==null)
            {
                %>
                <script>
                    alert("Logged out successfully!!!");
                    location.href="http://localhost:8080/TestWeb/Pages/SessLogin.html";
                </script>
                <%
            }
            else
            {
                vname = sess.getAttribute("fname").toString();
            }
            %> 
            <span style="align-content: flex-end">
            Welcome <%=vname%> . <a href="http://localhost:8080/OC/login.html">Sign out</a>
        </span>
       
        <h1>THIS IS PAGE 2 AFTER LOGGING IN PROPERLY!</h1>
        <a href="http://localhost:8080/OC/index.jsp">Home</a>
     
    </body>
</html>