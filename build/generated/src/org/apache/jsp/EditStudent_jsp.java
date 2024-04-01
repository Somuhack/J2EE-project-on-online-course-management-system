package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EditStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>Register</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    <meta name=\"keywords\"\n");
      out.write("        content=\"Educational Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, Sony Ericsson, Motorola web design\" />\n");
      out.write("    <script type=\"application/x-javascript\">\n");
      out.write("        addEventListener(\"load\", function () {\n");
      out.write("            setTimeout(hideURLbar, 0);\n");
      out.write("        }, false);\n");
      out.write("\n");
      out.write("        function hideURLbar() {\n");
      out.write("            window.scrollTo(0, 1);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("    <link href=\"//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&subset=latin-ext\"\n");
      out.write("        rel=\"stylesheet\">\n");
      out.write("    <link href=\"//fonts.googleapis.com/css?family=Covered+By+Your+Grace\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        .card-container {\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin: auto;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: #f3f3f3; /* Change this to your desired background color */\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .modal-content {\n");
      out.write("            border: none; /* Remove default border from modal content */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .modal-header h4 {\n");
      out.write("            margin-top: 0; /* Remove top margin from header */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Style for form fields */\n");
      out.write("        .form-group {\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-group label {\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-control {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 8px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Style for radio buttons */\n");
      out.write("        .radio-inline {\n");
      out.write("            margin-right: 10px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"card-container\">\n");
      out.write("        <div class=\"modal-content news-w3l\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close w3l\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4>Register Now</h4>\n");
      out.write("                <div class=\"login-main wthree\">\n");
      out.write("                    <form action=\"http://localhost:8080/OC/register\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"name\">Name:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"name\" name=\"SNAME\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"email\">Email:</label>\n");
      out.write("                            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"SEMAIL\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Gender:</label>\n");
      out.write("                            <div class=\"radio\">\n");
      out.write("                                <label class=\"radio-inline\">\n");
      out.write("                                    <input type=\"radio\" name=\"SGEN\" value=\"male\" required> Male\n");
      out.write("                                </label>\n");
      out.write("                                <label class=\"radio-inline\">\n");
      out.write("                                    <input type=\"radio\" name=\"SGEN\" value=\"female\" required> Female\n");
      out.write("                                </label>\n");
      out.write("                                <label class=\"radio-inline\">\n");
      out.write("                                    <input type=\"radio\" name=\"SGEN\" value=\"other\" required> Other\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"phoneNumber\">Phone Number (+91):</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"phoneNumber\" name=\"SPHONE\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"address\">Address:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"address\" name=\"SADD\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"password\">Password:</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"SPASS\" required>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\"> Click to Edit </button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
