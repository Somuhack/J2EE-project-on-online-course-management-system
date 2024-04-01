package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Add Image</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"\">\n");
      out.write("        <style>\n");
      out.write("            /* Style for form container */\n");
      out.write("            .container {\n");
      out.write("                text-align: center;\n");
      out.write("                max-width: 400px;\n");
      out.write("                margin: auto;\n");
      out.write("                padding: 20px;\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style for input fields */\n");
      out.write("            input[type=text], select, input[type=file] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 12px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                margin-top: 6px;\n");
      out.write("                margin-bottom: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style for submit button */\n");
      out.write("            #done {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            #done:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style for form labels */\n");
      out.write("            label {\n");
      out.write("                font-size: 18px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .img #logo{\n");
      out.write("                width:50px;\n");
      out.write("                height: 50px;\n");
      out.write("                top:10px;\n");
      out.write("                left:10px;\n");
      out.write("            }\n");
      out.write("            /* Style for error messages */\n");
      out.write("            .error-msg {\n");
      out.write("                color: red;\n");
      out.write("                font-size: 14px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style for success messages */\n");
      out.write("            .success-msg {\n");
      out.write("                color: green;\n");
      out.write("                font-size: 14px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .homediv\n");
      out.write("            {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #home\n");
      out.write("            {\n");
      out.write("                align-content: center;\n");
      out.write("                background-color: #0069d9;\n");
      out.write("                color: white;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 18px;\n");
      out.write("                color: #ffffff;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script >\n");
      out.write("\n");
      out.write("            function imgLoad(event) {\n");
      out.write("\n");
      out.write("                var image = document.getElementById('imgout');\n");
      out.write("                fname = event.target.files[0].name;\n");
      out.write("                ext = fname.replace(/^.*\\./, '');\n");
      out.write("                if (ext === 'png' || ext === 'jpg' || ext === 'jpeg')\n");
      out.write("                {\n");
      out.write("                    image.src = URL.createObjectURL(event.target.files[0]);\n");
      out.write("                    document.getElementById(\"imgerr\").innerHTML = \"\";\n");
      out.write("                    return true;\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"imgerr\").innerHTML = \"Only png, jpg, jpeg types allowed\";\n");
      out.write("                    image.src = \"null/\";\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("            function checkImg()\n");
      out.write("            {\n");
      out.write("                if (document.getElementById('imgout').src === \"C:\\Users\\somna\\Documents\\NetBeansProjects\\OC\") //change this path to your project path\n");
      out.write("                {\n");
      out.write("                    document.getElementById('imgerr').innerHTML = \"Select an Image\";\n");
      out.write("                    return false;\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    document.getElementById('imgerr').innerHTML = \"\";\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function checkName()\n");
      out.write("            {\n");
      out.write("                if (document.getElementById(\"cname\").value === \"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"err\").innerHTML = \"Enter a name\";\n");
      out.write("                    b = false;\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"err\").innerHTML = \"\";\n");
      out.write("                    b = true;\n");
      out.write("                }\n");
      out.write("                return b;\n");
      out.write("            }\n");
      out.write("            function validate()\n");
      out.write("            {\n");
      out.write("\n");
      out.write("                a = checkImg();\n");
      out.write("                b = checkName();\n");
      out.write("                return (a & b);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form onsubmit=\"return validate()\" method=\"POST\" action=\"http://localhost:8080/OC/AddCourse\" enctype=\"multipart/form-data\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>Add Image To Database</h1>\n");
      out.write("                <label for=\"name\">Name:</label>\n");
      out.write("                <input type=\"text\" id=\"name\" name=\"cname\" onblur=\"checkName()\">\n");
      out.write("                <label for=\"fa\">Fees Amount:</label>\n");
      out.write("                <input type=\"text\" id=\"fa\" name=\"cfee\" >\n");
      out.write("                <label for=\"cdu\">Course Duration(In Months):</label>\n");
      out.write("                <input type=\"text\" id=\"cdu\" name=\"cdu\" >\n");
      out.write("                <label for=\"cd\">Course Description :</label>\n");
      out.write("                <textarea id=\"cd\" name=\"cdes\" rows=\"4\" cols=\"50\"></textarea>\n");
      out.write("               \n");
      out.write("\n");
      out.write("                <span id=\"err\" style=\"color:red\"></span>\n");
      out.write("                <div >\n");
      out.write("                    <br>\n");
      out.write("                    <label for=\"Image\">Image</label>\n");
      out.write("                    <input type=\"file\" id=\"image\" name=\"image\" onchange =\"imgLoad(event)\">\n");
      out.write("                    <img id=\"imgout\" width=\"140\" height=\"235\" src=null disabled/>\n");
      out.write("                    <br>\n");
      out.write("                    <span id=\"imgerr\" style=\"color:red\"></span>\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    ");

                        String error = request.getParameter("status");
                        if (error != null && error.equals("success")) {
                            out.println("<span class=\"success-msg\">Added Successfully</span>");
                        } else if (error != null && error.equals("failed")) {
                            out.println("<span class=\"error-msg\">Failed To Add</span>");
                        } else {
                            out.println("<span class=\"error-msg\"></span>");
                        }
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <button  type=\"submit\" name=\"submit\" id=\"done\">Add Image</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("        </form>\n");
      out.write("                    \n");
      out.write("    </div>\n");
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
