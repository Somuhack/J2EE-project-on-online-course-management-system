<%-- 
    Document   : course
    Created on : 22 Nov, 2023, 9:01:45 PM
    Author     : somna
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="java.util.Base64"%>
<%@page import="java.sql.Blob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href='https://fonts.googleapis.com/css?family=Sofia Sans' rel='stylesheet'>
        <title>JSP Page</title>
        

        <style>
            *{
                margin-left: 50px;
                margin-right: 50px;
                font-family: 'Sofia Sans';
            }
            p{
                font-size: 20px;
            }
            li{
                font-size: 20px; 
            }
            img{
                width: 450px;
                display: block;
                margin-left: auto;
                margin-right: auto;
            }
            .top{
                margin-top: 30px;
            }
            .admit{
                position: absolute;
                margin-left: 63%;
                margin-top: 107px;
            }
            .btn{
                position: fixed;
                font-size: 26px;
                font-weight: 500;
                padding: 10px;
                border: none;
                border-radius: 7px;
                color: white;
                background: blue;
                cursor: pointer;
            }
            ol{
                margin-bottom: 50px;
            }
        </style>
        
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
            ops = (OraclePreparedStatement)oconn.prepareCall("SELECT * FROM courses where C_id>=10001");
//            ops.setString(1, vemail);
            
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
  <h1 class="top"><%=ors.getString(2)%></h1>
        <p><%=ors.getString(2)%></p>
        <div align="right"> <% //to show the image
                        Blob imageBlob = ors.getBlob("IMAGE");
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        out.write("<img style='width:240px;height:235px'src=\"data:images/jpeg;base64," + new String(Base64.getEncoder().encode(imageBytes)) + "\"/>");
                        %>
</div>
        <div class="admit">
            <a href="Admission.jsp"><input type="button" class="btn" value="Admission now!"></a>
        </div>
        <h2><%=ors.getString(1)%></h2>
        <p><%=ors.getString(1)%></p>
        <h2>Jobs future in HTML/CSS</h2>
        <ol>
            <li>FrontEnd Developer</li>
            <li>Website Editor</li>
            <li>Social Media Manager</li>
            <li>HTML and CSS Production Specialist</li>
            
        </ol>
        <h2> Course Fee:</h2><p><%=ors.getString(3)%></p> 
        <h2>Duration:</h2><p><%=ors.getString(4)%></p><br><br><br><br><br><br><br>
         <%       } 
                    %>
    </body>
</html>
