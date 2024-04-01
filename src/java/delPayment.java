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

public class delPayment extends HttpServlet 
{
    String SEMAIL;
    
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
           
           
            SEMAIL = request.getParameter("id");
           
           
            
          
            try 
            {
                // STEP 2: REGISTERING THE ORACLE DRIVER WITH THIS SERVLEt
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                
                // STEP 3: INSTANTIATING THE ORACLE CONNECTION OBJECT
                oconn = (OracleConnection) DriverManager.getConnection
        ("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
                
                // STEP 4: INSTANTIATING THE ORACLE PREPARED STATEMENT OBJECT
                ops = (OraclePreparedStatement)  oconn.prepareCall("DELETE FROM PAYMENTS WHERE C_EMAIL = ?");
                      //STEP 6: FILLING UP THE BLANK QUERY PARAMETERS (?)
               
                ops.setString(1, SEMAIL);
               
                // STEP 7: EXECUTING THE QUERY
                  
                rs = ops.executeQuery();
                  if(rs.next())  
                  {  
                        pw.println("<h3>Delete Successfully....</h3>");  
                        RequestDispatcher rd1=request.getRequestDispatcher("./payment_t5.jsp");  
                        rd1.include(request,response);  
                        //or  
                        //response.sendRedirect("./home.html");  
//                        pw.println("<form method=\"post\" action=\"register.html\">");  
//                        pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");  
//                        pw.println("</form>");  
                          
                  }  
                  else  
                  {  
                        pw.println("<center><h3>Delete Unsuccessfull....</center>");  
                        RequestDispatcher rd2=request.getRequestDispatcher("./payment_t5.jsp");  
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