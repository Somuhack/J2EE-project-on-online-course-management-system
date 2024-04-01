<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admission</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia Sans">
        <link rel="stylesheet" href="css/Admission.css">
    </head>
    <body>
        <%
            //STEP 0: DECLEARING OBJECTS
            OracleConnection oconn;
            OraclePreparedStatement ost;
            ResultSet rs;
            OracleResultSet ors;

            //STEP 1: REGISTERING OF THE REQUIRED DRIVER WITH THE JAVA PROGRAM
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            //STEP 2: INSTANTIATING THE CONNECTION OBJECT
            oconn = (OracleConnection) DriverManager.getConnection ("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
       
        %>
        <h1 class="title">Admission Form Fillup</h1>
        <div class="tabContainer">
            <div class="buttonContainer">
                <button onclick="showPanel(0, 'gray'); setVal();">Course Details</button>
                <button onclick="showPanel(1, 'gray'); setVal();">Personal Details</button>
                <button onclick="showPanel(2, 'gray'); setVal();">Educational Qualification</button>
            </div>
            <!--Form 1-->
            <form method="get" action="Admission.jsp"> 
                <div class="tabPanel">
                    <h2 class="heading">Course Details</h2>
                    <div class="heading-set-p1">
                        <div class="heading-box-p1">
                            <a class="head">Course Name<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p1">
                            <a class="head">Course Id<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p1">
                            <a class="head">Course Fees<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p1 cdur">
                            <a class="head">Course Duration<span style="color: red"> *</span></a>
                        </div>

                    </div>
                    <div class="input-set-p1">
                        <div class="input-box-p1">
                            <select class="st ddl" id="cname" name="tbCourseName" onchange="this.form.submit()">
                                <option value="select">------Select------</option>
                                <%
                                    //STEP 3: CREATING THE QUERY
                                    String q = "SELECT *FROM COURSES";
                                    //STEP 4: INSTANTIATING STATEMENT OBJECT FOR EXECUTING SQL QUERIES
                                    ost = (OraclePreparedStatement) oconn.prepareStatement(q);
                                    //STEP 5: EXECUTING THE QUERY
                                    rs = ost.executeQuery(q);
                                    while (rs.next()) {
                                %>
                                <option value="<%=rs.getString("C_NAME")%>"><%=rs.getString("C_NAME")%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <%
                            if (request.getParameter("tbCourseName") != null) {
                                String vCourse = request.getParameter("tbCourseName");
                                //STEP 3: CREATING THE QUERY
                                String query = "SELECT *FROM COURSES WHERE C_NAME=?";
                                //STEP 4: INSTANTIATING STATEMENT OBJECT FOR EXECUTING SQL QUERIES
                                ost = (OraclePreparedStatement) oconn.prepareStatement(query);
                                //STEP 5: FILLING UP THE PARAMETERS
                                ost.setString(1, vCourse);
                                //STEP 5: Executing the query and populating the resultset
                                ors = (OracleResultSet) ost.executeQuery();
                                if (ors.next()) {
                        %>
                        <input type="hidden" id="ccname" value="<%=ors.getString(2)%>">
                        <div class="input-box-p1">
                            <input class="tb cid" type="text" id="cids" name="tbCourseId" value="<%=ors.getString(1)%>">
                        </div>
                        <div class="input-box-p1">
                            <input class="tb ccf" type="text" id="cfees" name="tbCourseFees" value="<%=ors.getString(3)%>">
                        </div>
                        <div class="input-box-p1">
                            <input class="tb cdr" type="text" id="cdur" name="tbCourseDur" value="<%=ors.getString(4)%>">
                        </div>
                        <%
                            }
                        } else {
                        %>
                        <div class="input-box-p1">
                            <input class="tb cid" type="text" id="cids" name="tbCourseId">
                        </div>
                        <div class="input-box-p1">
                            <input class="tb ccf" type="text" id="cfees" name="tbCourseFees">
                        </div>
                        <div class="input-box-p1">
                            <input class="tb cdr" type="text" id="cdur" name="tbCourseDur">
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <div class="next">
                        <input class="next-btn" type="button" value="Next" onclick="showPanel(1, 'gray'); setVal();">
                    </div>
                </div>
            </form>
            <!--Form 2-->
            <form method="post" action="http://localhost:8080/OC/AdmissionPage">

                <div class="tabPanel">
                    <input type="hidden" id="copycid" name="CourseId">
                    <input type="hidden" id="copycname" name="CourseName">
                    <input type="hidden" id="copycfees" name="CourseFees">
                    <input type="hidden" id="copycdur" name="CourseDur">

                    <h2 class="heading">Personal Details</h2>
                    <div class="heading-set-p2-1">
                        <div class="heading-box">
                            <a class="head">Name of Applicant<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box">
                            <a class="head">Date of Birth<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box">
                            <a class="head">Father Name<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box">
                            <a class="head">Gender<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box mob">
                            <a class="head">Mobile Number<span style="color: red"> *</span></a>
                        </div>
                    </div>
                    <div class="heading-set-p2-2">
                        <div class="heading-box">
                            <a class="head">Email<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box">
                            <a class="head">Address<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box">
                            <a class="head">District<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box">
                            <a class="head">State<span style="color: red"> *</span></a>
                        </div>
                    </div>
                    <div class="input-set-p2-1">
                        <div class="input-box">
                            <input class="tb" type ="text" id="pname" name="tbName">
                            <span id="errname" class="err"></span>
                        </div>
                        <div class="input-box">
                            <input class="tb" type ="date"  id="pdob" name="tbDob">
                            <span id="errdob" class="err"></span>
                        </div>
                        <div class="input-box">
                            <input class="tb" type ="text"  id="pfname" name="tbFatherName">
                            <span id="errfname" class="err"></span>
                        </div>
                        <div class="input-box gen">
                            <input type="radio" name="rbGender" value="Male"> Male
                            <input type="radio" name="rbGender" value="Female"> Female
                            <input type="radio" name="rbGender" value="Others"> Others
                            <span id="errgen" class="err"></span>
                        </div>
                        <div class="input-box">
                            <input class="tb" type="text" id="pmob" name="tbMobile">
                            <span id="errmob" class="err"></span>
                        </div>
                    </div>
                    <div class="input-set-p2-2">
                        <div class="input-box email">
                            <input class="tb" type="text" id="pemail" name="tbEmail">
                            <span id="erremail" class="err"></span>
                        </div>
                        <div class="input-box add">
                            <input class="tb" type="text" id="padd" name="tbAddress">
                            <span id="erradd" class="err"></span>
                        </div>
                        <div class="input-box">
                            <input class="tb" type="text" id="pdis" name="tbDistrict">
                            <span id="errdist" class="err"></span>
                        </div>
                        <div class="input-box state">
                            <select class="ddl" id="pstate" name="ddlState">
                                <option value="select">-------Select-------</option>
                                <option value="Andhra Pradesh">Andhra Pradesh</option>
                                <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                                <option value="Assam">Assam</option>
                                <option value="Bihar">Bihar</option>
                                <option value="Chandigarh">Chandigarh</option>
                                <option value="Chhattisgarh">Chhattisgarh</option>
                                <option value="Daman and Diu">Daman and Diu</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Lakshadweep">Lakshadweep</option>
                                <option value="Puducherry">Puducherry</option>
                                <option value="Goa">Goa</option>
                                <option value="Gujarat">Gujarat</option>
                                <option value="Haryana">Haryana</option>
                                <option value="Himachal Pradesh">Himachal Pradesh</option>
                                <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                                <option value="Jharkhand">Jharkhand</option>
                                <option value="Karnataka">Karnataka</option>
                                <option value="Kerala">Kerala</option>
                                <option value="Madhya Pradesh">Madhya Pradesh</option>
                                <option value="Maharashtra">Maharashtra</option>
                                <option value="Manipur">Manipur</option>
                                <option value="Meghalaya">Meghalaya</option>
                                <option value="Mizoram">Mizoram</option>
                                <option value="Nagaland">Nagaland</option>
                                <option value="Odisha">Odisha</option>
                                <option value="Punjab">Punjab</option>
                                <option value="Rajasthan">Rajasthan</option>
                                <option value="Sikkim">Sikkim</option>
                                <option value="Tamil Nadu">Tamil Nadu</option>
                                <option value="Telangana">Telangana</option>
                                <option value="Tripura">Tripura</option>
                                <option value="Uttar Pradesh">Uttar Pradesh</option>
                                <option value="Uttarakhand">Uttarakhand</option>
                                <option value="West Bengal">West Bengal</option>
                            </select>
                            <span id="errstate" class="err"></span>
                        </div>
                    </div>
                    <div class="next">
                        <input class="next-btn" type="button" value="Next" onclick="showPanel(2, 'gray')">
                    </div>

                </div>
                <div class="tabPanel">

                    <h2 class="heading">Educational Qualification</h2>
                    <div class="heading-set-p3">
                        <div class="heading-box-p3">
                            <a class="head">Qualification<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p3">
                            <a class="head">Passing Year<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p3">
                            <a class="head">Total Marks<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p3">
                            <a class="head">Total Marks Obtained<span style="color: red"> *</span></a>
                        </div>
                        <div class="heading-box-p3 per">
                            <a class="head">Percentage<span style="color: red"> *</span></a>
                        </div>
                    </div>
                    <div class="input-set-p3">
                        <div class="input-box-p3">
                            <select class="ddl" id="equa" name="tbQualification">
                                <option>------Select------</option>
                                <option>Secondary</option>
                                <option>Higher Secondary</option>
                                <option>Graduation</option>
                                <option>Post Graduation</option>
                            </select>
                        </div>
                        <div class="input-box-p3">
                            <input class="tb" type="number" id="epass" name="tbPassingyear" maxlength="4" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
                        </div>
                        <div class="input-box-p3">
                            <input class="tb" type="number" id="etmarks" name="tbTMarks" onkeydown="delPer()" maxlength="4" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
                        </div>
                        <div class="input-box-p3">
                            <input class="tb" type="number" id="emarks" name="tbMarks" onkeydown="delPer()" maxlength="6" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
                        </div>
                        <div class="input-box-p3">
                            <input class="tb" type="text" id="eper" name="tbPercentage"  onclick="calPer()">
                        </div>
                    </div>
                    <div class="next">
                        <input class="next-btn" type="submit" value="Submit">
                    </div>

                </div>

            </form>
        </div>
        <script>
            function calPer() {
                var marks = document.getElementById("emarks").value; //Marks obtained
                var total_marks = document.getElementById("etmarks").value; //Total marks
                document.getElementById("eper").value = ((marks * 100) / total_marks).toFixed(2) + "%"; //calculation of percentage
            }
            function delPer() {
                document.getElementById("eper").value = "";
            }
            function setVal() {
                var id = document.getElementById("cids").value;
                var name = document.getElementById("ccname").value;
                var fees = document.getElementById("cfees").value;
                var dur = document.getElementById("cdur").value;
                document.getElementById("copycid").value = id;
                document.getElementById("copycname").value = name;
                document.getElementById("copycfees").value = fees;
                document.getElementById("copycdur").value = dur;
            }
        </script>


        <script>
            var tabButtons = document.querySelectorAll(".tabContainer .buttonContainer button");
            var tabPanels = document.querySelectorAll(".tabContainer  .tabPanel");

            function showPanel(panelIndex, colorCode) {
                tabButtons.forEach(function (node) {
                    node.style.backgroundColor = "";
                    node.style.color = "";
                });
                tabButtons[panelIndex].style.backgroundColor = colorCode;
                tabButtons[panelIndex].style.color = "white";
                tabPanels.forEach(function (node) {
                    node.style.display = "none";
                });
                tabPanels[panelIndex].style.display = "block";
                tabPanels[panelIndex].style.backgroundColor = colorCode;
            }
            showPanel(0, 'gray');
        </script>

    </body>
</html>