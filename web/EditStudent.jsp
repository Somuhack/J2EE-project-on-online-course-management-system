<%-- 
    Document   : EditStudent
    Created on : 25 Nov, 2023, 10:23:04 AM
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
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords"
        content="Educational Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&subset=latin-ext"
        rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Covered+By+Your+Grace" rel="stylesheet">
    <style>
        .card-container {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            background-color: #f3f3f3; /* Change this to your desired background color */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .modal-content {
            border: none; /* Remove default border from modal content */
        }

        .modal-header h4 {
            margin-top: 0; /* Remove top margin from header */
        }

        /* Style for form fields */
        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        /* Style for radio buttons */
        .radio-inline {
            margin-right: 10px;
        }
    </style>
</head>
        <%  
           String vemail = request.getParameter("email");
     
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
    <div class="card-container">
        <div class="modal-content news-w3l">
            <div class="modal-header">
                <button type="button" class="close w3l" data-dismiss="modal">&times;</button>
                <h4>Edit Form</h4>
                <div class="login-main wthree">
                    <form action="http://localhost:8080/OC/EditStudent" method="post">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="SNAME" value="<%=ors.getString(1)%>" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="SEMAIL" value="<%=ors.getString(2)%>" required>
                        </div>
                        <div class="form-group">
                            <label>Gender:</label>
                            <div class="radio">
                                <label class="radio-inline">
                                    <input type="radio" name="SGEN" value="<%=ors.getString(3)%>"  required> Male
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="SGEN" value="<%=ors.getString(3)%>" required> Female
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="SGEN" value="<%=ors.getString(3)%>" required> Other
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber">Phone Number (+91):</label>
                            <input type="text" class="form-control" id="phoneNumber" name="SPHONE" value="<%=ors.getString(4)%>" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" class="form-control" id="address" name="SADD" value="<%=ors.getString(5)%>" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="SPASS" value="<%=ors.getString(6)%>" required>
                        </div>
                         <div class="form-group">
                            <label for="sq"> Security Question ?</label>
                            <input type="text" class="form-control" id="sq" name="SQUES" value="<%=ors.getString(7)%>" required>
                        </div>
                         <div class="form-group">
                            <label for="SA">Security Answer :</label>
                            <input type="text" class="form-control" id="SA" name="SANS" value="<%=ors.getString(8)%>" required>
                        </div>

                        <button type="submit" class="btn btn-primary"> Click to Edit </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<%

  }
%>
</body>

</html>

