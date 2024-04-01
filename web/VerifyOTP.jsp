<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
    <style>
        /* Additional styles for a more attractive appearance */
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
        }

        .card {
            max-width: 400px;
            margin: auto;
            background-color: #ffffff;
        }

        .card-header {
            background-color: #343a40;
            color: #ffffff;
            text-align: center;
        }

        .card-body input {
            width: calc(100% - 20px);
            margin: 10px;
        }

        .card-body button {
            margin: 10px;
        }
    </style>
        <script>
            function funClose()
            {
                if(window.parent) if(confirm("Closing window......") === true)  window.parent.window.close();    
                else if(confirm("Closing window......") === true) window.close();   
              }
         </script>     
    </head>
    <body style="background-color: antiquewhite">
         <%!
            String vname, votp, vemail;
            %>
        <%
            HttpSession sess = request.getSession(false);
            try
{
            if(sess!=null) 
            {
                vname = sess.getAttribute("fname").toString();
                votp = sess.getAttribute("otp").toString();
                vemail = sess.getAttribute("email").toString();
            }
}
catch(Exception ex)
{
                %>
                <script>
                    alert("Session was not created!!!");
                    alert("Redirecting for logging==>>");
                    location.href="http://localhost:8080/OC/login.html";
                </script>
                <%  
}
            if(request.getParameter("bVerify")!=null)
            {
                if(request.getParameter("tbOTP").equals(votp))
                {
                %>
                <script>
                    alert("OTP verified successfully!!!");
                    location.href="http://localhost:8080/OC/index.jsp";
                </script>
                <%
                }
                else
                {
                       %> 
                       <h3 style="color:red">Wrong OTP. Please try again!!!</h3>                 
                        <%
                }
            }
            else
            {
                   %>
                   
                   <h3 style="color: blueviolet">
                   Welcome <%=vname%> . 
                   Your designated email is : <%=vemail%>. Check your inbox .
                   Please complete the login process.
                   <a href="http://localhost:8080/OC/SessLogout">Sign out</a>
                   <h3>
                    <%
            }   
            %> 
       <div class="container">
        <div class="card">
            <div class="card-header">
                OTP VERIFICATION FORM
            </div>
            <div class="card-body">
                <form name="frmOTP" method="POST" action="http://localhost:8080/OC/VerifyOTP.jsp">
                    <div class="form-group">
                        <label for="tbOTP">ENTER OTP</label>
                        <input type="number" class="form-control" id="tbOTP" name="tbOTP" required/>
                    </div>
                    <button type="submit" class="btn btn-primary" name="bVerify">Verify</button>
                    <button type="reset" class="btn btn-secondary" name="bReset">Reset</button>
                    <button type="button" class="btn btn-danger" name="bClose" onclick="funClose();">Close</button>
                </form>
            </div>
           
             </div>
    </div>
    </body>
</html>