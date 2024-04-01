package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class VerifyOTP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String vname, votp, vemail;
            
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function funClose()\n");
      out.write("            {\n");
      out.write("                if(window.parent) if(confirm(\"Closing window......\") === true)  window.parent.window.close();    \n");
      out.write("                else if(confirm(\"Closing window......\") === true) window.close();   \n");
      out.write("              }\n");
      out.write("         </script>     \n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: antiquewhite\">\n");
      out.write("         ");
      out.write("\n");
      out.write("        ");

            HttpSession sess = request.getSession(false);
            try
{
            if(sess!=null) 
            {
                vname = sess.getAttribute("fname").toString();
                votp = sess.getAttribute("otp").toString();
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
            if(request.getParameter("bVerify")!=null)
            {
                if(request.getParameter("tbOTP").equals(votp))
                {
                
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"OTP verified successfully!!!\");\n");
      out.write("                    location.href=\"http://localhost:8080/OC/index.jsp\";\n");
      out.write("                </script>\n");
      out.write("                ");

                }
                else
                {
                       
      out.write(" \n");
      out.write("                       <h3 style=\"color:red\">Wrong OTP. Please try again!!!</h3>                 \n");
      out.write("                        ");

                }
            }
            else
            {
                   
      out.write("\n");
      out.write("                   \n");
      out.write("                   <h3 style=\"color: blueviolet\">\n");
      out.write("                   Welcome ");
      out.print(vname);
      out.write(" . \n");
      out.write("                   Your designated email is : ");
      out.print(vemail);
      out.write(". Check your inbox .\n");
      out.write("                   Please complete the login process.\n");
      out.write("                   <a href=\"http://localhost:8080/OC/SessLogout\">Sign out</a>\n");
      out.write("                   <h3>\n");
      out.write("                    ");

            }   
            
      out.write(" \n");
      out.write("        <h2>THIS IS OTP VERIFICATION PAGE BEFORE LOGGING IN COMPLETELY!</h2>\n");
      out.write("        <form name=\"frmOTP\" method=\"POST\" action=\"http://localhost:8080/OC/VerifyOTP.jsp\">\n");
      out.write("        <div>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr><th colspan=\"2\">OTP VERIFICATION FORM</th></tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ENTER OTP</td>\n");
      out.write("                        <td><input type=\"number\" size=\"4\" name=\"tbOTP\" required/></td></tr>    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"submit\" name=\"bVerify\">Verify</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"reset\" name=\"bReset\">Reset</button>\n");
      out.write("                            <button type=\"button\" name=\"bClose\" onclick=\"funClose();\">Close</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot>\n");
      out.write("                    <tr><th colspan=\"2\">&copy;Techno India Technologies ; Limited &reg;</th></tr>\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("            </form>\n");
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
