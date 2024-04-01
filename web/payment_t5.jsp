<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record Displayer</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="assets/css/style.css">
        <!--STEP 2: ADDING A INTERNAL STYLE FOR TABLE-->
      
    </head>
    <%!
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
            ops = (OraclePreparedStatement)oconn.prepareCall("select * from PAYMENTS");
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet)ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData)ors.getMetaData();
            %>
    <body>
        <!--STEP 1: BASIC STRUCTURE OF A TABLE-->
          <div class="table-responsive">
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <%
                        // STEP 9: BRINGING THE TABLE HEADINGS
                        for(counter = 1; counter <= orsmd.getColumnCount(); counter ++)
                        {
                        %>
                        <th><%=orsmd.getColumnName(counter)%></th>
                        <%
                            }
                        %>
                     <th>ACTION</th>
      </tr>
    </thead>
    <tbody>
      <%
      // STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS
      while(ors.next() == true)
      {
      %>
      <tr>
        <%
                       for(counter = 1; counter <= orsmd.getColumnCount(); counter ++)
                        {
                        %>
                        <th><%=ors.getString(counter)%></th>
                        <%
                            }
                        %>
                        <td><a href="http://localhost:8080/OC/delPayment?id=<%=ors.getString(5)%>"<button>Delete</button></a></td>
                  <%
                    }
                    %>
    </tbody>
    
  </table>
</div>  <%
                        // STEP 11: CLOSING THE CONNECTIONS
                        ors.close();
                        ops.close();
                        oconn.close();
                        %>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
<footer align="center"><a href="http://localhost:8080/OC/admin.html"<button>Go Back</button></a></footer>
    </body>
</html>