import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class register extends HttpServlet 
{
    String SNAME,SEMAIL, SGEN, SPHONE, SADD,SPASS;
    
    // STEP 1: DECLARING ORACLE OBJECTS
    OracleConnection oconn;
    OraclePreparedStatement ops;
    ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Register</title>");
            out.println("<body>");
            out.println("<h1>ServletRegister</h1>");
            SNAME = request.getParameter("SNAME");
            SEMAIL = request.getParameter("SEMAIL");
            SGEN = request.getParameter("SGEN");
            SPHONE = request.getParameter("SPHONE");
            SADD = request.getParameter("SADD");
            SPASS = request.getParameter("SPASS");
            out.println("<h1>Printing the HTML Form values in this servlet....</h1>");
            out.println("<h2>SLNO : " + SNAME + "</h2>");
          
            try 
            {
                // STEP 2: REGISTERING THE ORACLE DRIVER WITH THIS SERVLEt
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                
                // STEP 3: INSTANTIATING THE ORACLE CONNECTION OBJECT
                oconn = (OracleConnection) DriverManager.getConnection
        ("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
                
                // STEP 4: INSTANTIATING THE ORACLE PREPARED STATEMENT OBJECT
                ops = (OraclePreparedStatement) 
                        oconn.prepareCall
        ("INSERT INTO STUDENT(SNAME,SEMAIL,SGEN,SPHONE,SADD,SPASS) values(?,?,?,?,?,?)");
                
              
                
                //STEP 6: FILLING UP THE BLANK QUERY PARAMETERS (?)
                ops.setString(1, SNAME);
                ops.setString(2, SEMAIL);
                ops.setString(3, SGEN);
                ops.setString(4, SPHONE);
                ops.setString(5, SADD);
                ops.setString(6, SPASS);
                
                // STEP 7: EXECUTING THE QUERY
                  
                rs = ops.executeQuery();
                  if(rs.next())  
                  {  
                        pw.println("<h3>Login this form....</h3>");  
                        RequestDispatcher rd1=request.getRequestDispatcher("./login.html");  
                        rd1.include(request,response);  
                        //or  
                        //response.sendRedirect("./home.html");  
                        pw.println("<form method=\"post\" action=\"register.html\">");  
                        pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");  
                        pw.println("</form>");  
                          
                  }  
                  else  
                  {  
                        pw.println("<center><h3>invalid username/password Enter Correct username/password</h3></center>");  
                        RequestDispatcher rd2=request.getRequestDispatcher("./register.html");  
                        rd2.include(request,response);  
                        //or  
                        //response.sendRedirect("./Login.html");  
                  }  
                
                //STEP 8: CLOSING THE ORACLE OBJECTS
                ops.close();
                oconn.close();
                
            } 
            
                //STEP 9: FORMATTING THE CATCH CLAUSE
            catch (SQLException ex) 
            {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                out.println("<h2 style='color:red'> Error is : " + ex.toString() + "</h2>");
            }
            
            out.println("</head>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}