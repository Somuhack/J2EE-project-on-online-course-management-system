package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleConnection;

public final class UserProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                String vemail;
            
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\"/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("    \n");
      out.write("          \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            HttpSession sess = request.getSession(false);
try
{
            if(sess!=null) {
                vemail = sess.getAttribute("email").toString();    
            }
}
catch(Exception ex)
{
                
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Session was not created!!!\");\n");
      out.write("                    alert(\"Redirecting for logging==>>\");\n");
      out.write("                    location.href=\"http://localhost:8080/OC/login.html\";\n");
      out.write("                </script>\n");
      out.write("                ");
  
}
     
        // STEP 3: DECLARING OBJECTS AND VARIABLES
            OracleConnection oconn;
            OraclePreparedStatement ops;
            OracleResultSet ors;
            OracleResultSetMetaData orsmd;
            int counter, reccounter, colcounter;
        
      out.write("\n");
      out.write("        ");

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
            
      out.write("\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("     ");

                    // STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS
                    while(ors.next() == true)
                    {
                    
      out.write("\n");
      out.write("    \n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-10\">\n");
      out.write("                <h1>");
      out.print(ors.getString(1));
      out.write("</h1>\n");
      out.write("                <button class=\"btn btn-success\">Edit profile</button>\n");
      out.write("                <button class=\"btn btn-info\"><a href=\"http://localhost:8080/OC/login.html\">Logout</a></button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-2\">\n");
      out.write("                <a href=\"/users\" class=\"pull-left\">\n");
      out.write("                    <img class=\"img-circle img-responsive\" src=\"http://www.rlsandbox.com/img/profile.jpg\" alt=\"profile image\" title=\"profile image\">\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-3\">\n");
      out.write("                <ul class=\"list-group\">\n");
      out.write("                    <li class=\"list-group-item active\">Profile</li>\n");
      out.write("                    <li class=\"list-group-item\"><strong>Email : </strong>");
      out.print(ors.getString(2));
      out.write("</li>\n");
      out.write("                    <li class=\"list-group-item\"><strong>Gender : </strong>");
      out.print(ors.getString(3));
      out.write(" </li>\n");
      out.write("                    \n");
      out.write("                    <li class=\"list-group-item\"><strong>number of course : </strong>0</li>\n");
      out.write("                    <li class=\"list-group-item\"><strong>Phone :</strong>");
      out.print(ors.getString(4));
      out.write("</li>\n");
      out.write("                    <li class=\"list-group-item\"><strong>Address :</strong> ");
      out.print(ors.getString(5));
      out.write("</li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\">Course Reminder</div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <i class=\"fa fa-check-square\" style=\"color: green;\"></i> 2.13.2024\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                    <div class=\"panel-heading\">Social Media</div>\n");
      out.write("                    \n");
      out.write("                        <i class=\"fa fa-facebook fa-2x\"></i>\n");
      out.write("                        <i class=\"fa fa-github fa-2x\"></i>\n");
      out.write("                        <i class=\"fa fa-twitter fa-2x\"></i>\n");
      out.write("                        <i class=\"fa fa-pinterest fa-2x\"></i>\n");
      out.write("                        <i class=\"fa fa-google-plus fa-2x\"></i>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-9\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\">Welcome to our course</div>\n");
      out.write("                    <div class=\"panel-body\">A long description about me.</div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\"></div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <div class=\"thumbnail\">\n");
      out.write("                                 \n");
      out.write("                                    <div class=\"caption\">\n");
      out.write("                                        <h3>Ongoing course</h3>\n");
      out.write("                                        <p>0</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <div class=\"thumbnail\">\n");
      out.write("                                   \n");
      out.write("                                    <div class=\"caption\">\n");
      out.write("                                        <h3>complete course</h3>\n");
      out.write("                                        <p>0</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <div class=\"thumbnail\">\n");
      out.write("                                   \n");
      out.write("                                    <div class=\"caption\">\n");
      out.write("                                        <h3>certificate</h3>\n");
      out.write("                                        <p>0</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    ");

                break;    } 
                    
      out.write("\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
