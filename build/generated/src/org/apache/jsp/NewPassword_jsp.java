package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleConnection;

public final class NewPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String vemail, vpass;
            OracleConnection oconn;
            OraclePreparedStatement ost;
            HttpSession sess;
          
            
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Password Reset Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-image: url('../Images/Screen/img101.png')\">\n");
      out.write("         ");
      out.write("\n");
      out.write("            ");

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
                     
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                    alert(\"Password reset successfully!!! You can now login using your new password\");\n");
      out.write("                    alert(\"Redirecting for logging==>>\");\n");
      out.write("                    location.href=\"http://localhost:8080/OC/Forgotlogin.html\";\n");
      out.write("                </script>\n");
      out.write("                ");
  
                }
                else
                {
                       
      out.write(" \n");
      out.write("                       <h3 style=\"color:red\">Password do not match!!!. Please try again!!!</h3>                 \n");
      out.write("                        ");

                }
            }
            else
            {
                   vemail = request.getParameter("pemail");
                   sess = request.getSession(true);
                   sess.setAttribute("sessemail", vemail);
                   
      out.write("\n");
      out.write("                   <h3 style=\"color: blueviolet\">\n");
      out.write("                   Please verify your security credentials.\n");
      out.write("                   </h3>\n");
      out.write("                    ");

                   
            }   
            
      out.write("\n");
      out.write("         <div class=\"container d-flex justify-content-center align-items-center\" style=\"height: 100vh;\">\n");
      out.write("        <div class=\"card text-white bg-dark\" style=\"width: 400px;\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <h5 class=\"card-title text-center text-danger font-weight-bold\">RESET YOUR PASSWORD</h5>\n");
      out.write("                <form >\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"tpass\">NEW PASSWORD</label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"tpass\" id=\"tpass\" required>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"cpass\">CONFIRM PASSWORD</label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"cpass\" id=\"cpass\" required>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-success btn-block\" name=\"bConfirm\">Confirm</button>\n");
      out.write("                    <button type=\"reset\" class=\"btn btn-secondary btn-block\" name=\"bClear\">Clear</button>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <p class=\"text-center mt-3\">&copy; TECHNO INDIA TECHNOLOGIES &reg;</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
