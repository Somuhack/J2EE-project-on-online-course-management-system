<%-- 
    Document   : UserProfile
    Created on : 17 Nov, 2023, 9:37:54 AM
    Author     : somna
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">




</head>
    
          

<%!
                String vemail;
            %>
        <%
            HttpSession sess = request.getSession(false);
try
{
            if(sess!=null) {
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
     
        // STEP 3: DECLARING OBJECTS AND VARIABLES
            OracleConnection oconn;
            OraclePreparedStatement ops;
            OracleResultSet ors;
            OracleResultSetMetaData orsmd;
            int counter, reccounter, colcounter;
        %>
        <%
            // STEP 4: REGISTRATION OF ORACLE DRIVER
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            // STEP 5: INSTANTIATING TH             E CONNECTION
            oconn = 
                    (OracleConnection)
                    DriverManager.getConnection
        ("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
            
            // STEP 6: INSTANTIATING THE STATEMENT OBJECT
            ops = (OraclePreparedStatement)oconn.prepareCall("SELECT * FROM student where semail=?");
            ops.setString(1, vemail);
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet)ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData)ors.getMetaData();
            %>
<body>
    
     <%
                    // STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS
                    while(ors.next() == true)
                    {
                    %>
    
        <div class="row">
            <div class="col-sm-10">
                <h1><%=ors.getString(1)%></h1>
                <button class="btn btn-success">Edit profile</button>
                <button class="btn btn-info"><a href="http://localhost:8080/OC/login.html">Logout</a></button>
            </div>
            <div class="col-sm-2">
                <a href="/users" class="pull-left">
                    <img class="img-circle img-responsive" src="http://www.rlsandbox.com/img/profile.jpg" alt="profile image" title="profile image">
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <ul class="list-group">
                    <li class="list-group-item active">Profile</li>
                    <li class="list-group-item"><strong>Email : </strong><%=ors.getString(2)%></li>
                    <li class="list-group-item"><strong>Gender : </strong><%=ors.getString(3)%> </li>
                    
                    <li class="list-group-item"><strong>number of course : </strong>0</li>
                    <li class="list-group-item"><strong>Phone :</strong><%=ors.getString(4)%></li>
                    <li class="list-group-item"><strong>Address :</strong> <%=ors.getString(5)%></li>
                </ul>
                <div class="panel panel-default">
                    <div class="panel-heading">Course Reminder</div>
                    <div class="panel-body">
                        <i class="fa fa-check-square" style="color: green;"></i> 2.13.2024
                    </div>
                </div>
               
                
                    <div class="panel-heading">Social Media</div>
                    
                        <i class="fa fa-facebook fa-2x"></i>
                        <i class="fa fa-github fa-2x"></i>
                        <i class="fa fa-twitter fa-2x"></i>
                        <i class="fa fa-pinterest fa-2x"></i>
                        <i class="fa fa-google-plus fa-2x"></i>
                    
                
            </div>
            <div class="col-sm-9">
                <div class="panel panel-default">
                    <div class="panel-heading">Welcome to our course</div>
                    <div class="panel-body">A long description about me.</div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="thumbnail">
                                 
                                    <div class="caption">
                                        <h3>Ongoing course</h3>
                                        <p>0</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="thumbnail">
                                   
                                    <div class="caption">
                                        <h3>complete course</h3>
                                        <p>0</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="thumbnail">
                                   
                                    <div class="caption">
                                        <h3>certificate</h3>
                                        <p>0</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <%
                break;    } 
                    %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
    
</body>
</html>
