<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Reset Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body style="background-image: url('../Images/Screen/img101.png')">
         <%!
            String vemail, vpass;
            OracleConnection oconn;
            OraclePreparedStatement ost;
            HttpSession sess;
          
            %>
            <%
            if(request.getParameter("bConfirm")!=null)
            {
                if(request.getParameter("tpass").equals(request.getParameter("cpass")))
                {
                   sess = request.getSession(false);
                   vpass = request.getParameter("tpass");
                   vemail = sess.getAttribute("sessemail").toString();
                   DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                   oconn = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
                   ost =(OraclePreparedStatement) oconn.prepareStatement("update student set  SPASS=? where SEMAIL=?");
                   ost.setString(1, vpass);
                   ost.setString(2, vemail);
                   int x = ost.executeUpdate();
                   ost.close();
                   oconn.close();
                   sess.invalidate();
                     %>
                    <script>
                    alert("Password reset successfully!!! You can now login using your new password");
                    alert("Redirecting for logging==>>");
                    location.href="http://localhost:8080/OC/login.html";
                </script>
                <%  
                }
                else
                {
                       %> 
                       <h3 style="color:red">Password do not match!!!. Please try again!!!</h3>                 
                        <%
                }
            }
            else
            {
                   vemail = request.getParameter("pemail");
                   sess = request.getSession(true);
                   sess.setAttribute("sessemail", vemail);
                   %>
                   <h3 style="color: blueviolet">
                   Please verify your security credentials.
                   </h3>
                    <%
                   
            }   
            %>
         <div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
        <div class="card text-white bg-dark" style="width: 400px;">
            <div class="card-body">
                <h5 class="card-title text-center text-danger font-weight-bold">RESET YOUR PASSWORD</h5>
                <form >
                    <div class="form-group">
                        <label for="tpass">NEW PASSWORD</label>
                        <input type="password" class="form-control" name="tpass" id="tpass" required>
                    </div>

                    <div class="form-group">
                        <label for="cpass">CONFIRM PASSWORD</label>
                        <input type="password" class="form-control" name="cpass" id="cpass" required>
                    </div>

                    <button type="submit" class="btn btn-success btn-block" name="bConfirm">Confirm</button>
                    <button type="reset" class="btn btn-secondary btn-block" name="bClear">Clear</button>
                </form>

                <p class="text-center mt-3">&copy; TECHNO INDIA TECHNOLOGIES &reg;</p>
            </div>
        </div>
    </div>
    </body>
</html>