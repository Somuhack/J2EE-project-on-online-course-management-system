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

public final class course_005ft4_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Record Displayer</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("        <!--STEP 2: ADDING A INTERNAL STYLE FOR TABLE-->\n");
      out.write("      \n");
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
            ops = (OraclePreparedStatement)oconn.prepareCall("select * from courses");
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet)ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData)ors.getMetaData();
            
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!--STEP 1: BASIC STRUCTURE OF A TABLE-->\n");
      out.write("          <div class=\"table-responsive\">\n");
      out.write("  <table class=\"table\">\n");
      out.write("    <thead class=\"thead-dark\">\n");
      out.write("      <tr>\n");
      out.write("        ");

                        // STEP 9: BRINGING THE TABLE HEADINGS
                        for(counter = 1; counter <= orsmd.getColumnCount(); counter ++){
                          
                        
      out.write("\n");
      out.write("                        <th>");
      out.print(orsmd.getColumnName(counter));
      out.write("</th>\n");
      out.write("                        ");

                            
}
                        
      out.write("\n");
      out.write("                     <th>ACTION</th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("      ");

      // STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS
      while(ors.next() == true)
      {
      
      out.write("\n");
      out.write("      <tr>\n");
      out.write("        ");

                       for(counter = 1; counter <= orsmd.getColumnCount(); counter ++)
                        {
                            if(counter==6){ 
      out.write("\n");
      out.write("                            <th>");
 Blob imageBlob = ors.getBlob("IMAGE");
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        out.write("<img style='width:55px;height:70px'src=\"data:images/jpeg;base64," + new String(Base64.getEncoder().encode(imageBytes)) + "\"/>");
      out.write("</th>\n");
      out.write("                         ");

               }
                          else{
                        
      out.write("\n");
      out.write("                   \n");
      out.write("                        <th>");
      out.print(ors.getString(counter));
      out.write("</th>\n");
      out.write("                        ");

                            }
}
                        
      out.write("\n");
      out.write("            \n");
      out.write("           <td> <a href=\"http://localhost:8080/OC/deleteCourse?cid=");
      out.print(ors.getString(1));
      out.write("\"<button>Delete</button></a></td>\n");
      out.write("      </tr>\n");
      out.write("      ");

                    }
                    
      out.write("\n");
      out.write("                   \n");
      out.write("    </tbody>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("  </table>\n");
      out.write("                    <a href=\"http://localhost:8080/OC/AddCourse.jsp\"><button align=\"left\">ADD Course</button>\n");
      out.write("</div>  ");

                        // STEP 11: CLOSING THE CONNECTIONS
                        ors.close();
                        ops.close();
                        oconn.close();
                        
      out.write("\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js\"></script>\n");
      out.write("<footer align=\"center\"> &copy; somnathbarik516@gmail.com &reg; TIIT &trade;</footer>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
