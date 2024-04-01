<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script>
            function funClose()
            {
                if(window.parent) if(confirm("Closing window......") === true)  window.parent.window.close();    
                else if(confirm("Closing window......") === true) window.close();   
              }
         </script>     
    </head>
    <body style="background-color: blanchedalmond">
         <%!
            String vemail, vques, vans;
            OracleConnection oconn;
          OraclePreparedStatement ost;
          OracleResultSet ors = null;
            %>
        <%
            vemail = request.getParameter("pemail");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            oconn = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
           ost =(OraclePreparedStatement) oconn.prepareStatement("SELECT * FROM student where SEMAIL=?");
            ost.setString(1, vemail);
            ors = (OracleResultSet) ost.executeQuery();
            if(ors.next()) 
            {
                vques = ors.getString("SQUES"); //SQUES IS D COL NAME FOR SECURITY QUES IN UR DB
                vans = ors.getString("SANS");
            }
            else
            {
                 %>
                <script>
                    alert("Do not try any malaligned URL. \n You can only use  the link received in mail ");
                    window.close();
                </script>
                <%
            }
            ost.close();
            oconn.close();
            if(request.getParameter("bVerify")!=null)
            {
                if(request.getParameter("tbAns").equals(vans))
                {
                %>
                <script>
                    alert("Security Answer verified successfully!!!");
                    location.href="http://localhost:8080/OC/NewPassword.jsp?pemail=<%=vemail%>";
                </script>
                <%
                }
                else
                {
                       %> 
                       <h3 style="color:red">Wrong Answer. Please try again!!!</h3>                 
                        <%
                }
            }
            else
            {
                   %>
                   
                   <h3 style="color: blueviolet">
                   Please verify your security credentials.
                    
                    <%
            }   
            %> 
      <div class="container">
        <div class="card mx-auto mt-5 p-3" style="max-width: 300px;">
            <h2 class="mb-3 text-center text-danger font-weight-bold">Security Verification</h2>
            <form name="frmSecurity" method="POST" action="http://localhost:8080/OC/VerifyQues.jsp?pemail=<%=vemail%>">
                <div class="form-group">
                    <label for="tbQues" class="text-dark">Question</label>
                    <input type="text" class="form-control" name="tbQues" value="<%=vques%>" readonly />
                </div>

                <div class="form-group">
                    <label for="tbAns" class="text-dark">Answer</label>
                    <input type="text" class="form-control" name="tbAns" required />
                </div>

                <div class="form-group d-flex justify-content-between mt-3">
                    <button type="submit" class="btn btn-success btn-block" name="bVerify"> Verify</button>
                </div>

                <div class="form-group d-flex justify-content-between">
                    <button type="reset" class="btn btn-secondary btn-block mt-2 mr-2" name="bReset">Reset</button>
                    <button type="button" class="btn btn-danger btn-block mt-2" name="bClose" onclick="funClose();">Close</button>
                </div>
            </form>
           
        </div>
    </div>

    </body>
</html>