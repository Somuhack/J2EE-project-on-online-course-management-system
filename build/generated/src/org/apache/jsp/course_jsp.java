package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleConnection;
import java.util.Base64;
import java.sql.Blob;

public final class course_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {



        // STEP 3: DECLARING OBJECTS AND VARIABLES
            OracleConnection oconn;
            OraclePreparedStatement ops;
            OracleResultSet ors;
            OracleResultSetMetaData orsmd;
            int counter, reccounter, colcounter;
        
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link href='https://fonts.googleapis.com/css?family=Sofia Sans' rel='stylesheet'>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("                margin-left: 50px;\n");
      out.write("                margin-right: 50px;\n");
      out.write("                font-family: 'Sofia Sans';\n");
      out.write("            }\n");
      out.write("            p{\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("            li{\n");
      out.write("                font-size: 20px; \n");
      out.write("            }\n");
      out.write("            img{\n");
      out.write("                width: 450px;\n");
      out.write("                display: block;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("            .top{\n");
      out.write("                margin-top: 30px;\n");
      out.write("            }\n");
      out.write("            .admit{\n");
      out.write("                position: absolute;\n");
      out.write("                margin-left: 63%;\n");
      out.write("                margin-top: 107px;\n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                position: fixed;\n");
      out.write("                font-size: 26px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 7px;\n");
      out.write("                color: white;\n");
      out.write("                background: blue;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            ol{\n");
      out.write("                margin-bottom: 50px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    ");
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
            ops = (OraclePreparedStatement)oconn.prepareCall("SELECT * FROM courses where C_id>=10001");
//            ops.setString(1, vemail);
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet)ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData)ors.getMetaData();
            
      out.write("\n");
      out.write("    <body>\n");
      out.write("         ");

                    // STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS
                    while(ors.next() == true)
                    {
                    
      out.write("\n");
      out.write("  <h1 class=\"top\">");
      out.print(ors.getString(2));
      out.write("</h1>\n");
      out.write("        <p>");
      out.print(ors.getString(2));
      out.write("</p>\n");
      out.write("        <div align=\"right\"> ");
 //to show the image
                        Blob imageBlob = ors.getBlob("IMAGE");
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        out.write("<img style='width:240px;height:235px'src=\"data:images/jpeg;base64," + new String(Base64.getEncoder().encode(imageBytes)) + "\"/>");
                        
      out.write("\n");
      out.write("</div>\n");
      out.write("        <div class=\"admit\">\n");
      out.write("            <a href=\"Admission.jsp\"><input type=\"button\" class=\"btn\" value=\"Admission now!\"></a>\n");
      out.write("        </div>\n");
      out.write("        <h2>");
      out.print(ors.getString(1));
      out.write("</h2>\n");
      out.write("        <p>");
      out.print(ors.getString(1));
      out.write("</p>\n");
      out.write("        <h2>Jobs future in HTML/CSS</h2>\n");
      out.write("        <ol>\n");
      out.write("            <li>FrontEnd Developer</li>\n");
      out.write("            <li>Website Editor</li>\n");
      out.write("            <li>Social Media Manager</li>\n");
      out.write("            <li>HTML and CSS Production Specialist</li>\n");
      out.write("            \n");
      out.write("        </ol>\n");
      out.write("        <h2> Course Fee:</h2><p>");
      out.print(ors.getString(3));
      out.write("</p> \n");
      out.write("        <h2>Duration:</h2><p>");
      out.print(ors.getString(4));
      out.write("</p><br><br><br><br><br><br><br>\n");
      out.write("         ");
       } 
                    
      out.write("\n");
      out.write("    </body>\n");
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
