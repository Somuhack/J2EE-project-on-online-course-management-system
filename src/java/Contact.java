import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class Contact extends HttpServlet 
{
    String vMESSAGE, vNAME, vEMAIL;
    
    // STEP 1: DECLARING ORACLE OBJECTS
    OracleConnection oconn;
    OraclePreparedStatement ops;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>THANK YOU FOR YOUR PRECIOUS ENQUIRY.</title>");
            out.println("<body>");
            out.println("<h1>THANK YOU FOR YOUR PRECIOUS ENQUIRY.</h1>");
            vMESSAGE = request.getParameter("Message");
            vNAME = request.getParameter("Name"); 
            vEMAIL = request.getParameter("Email");
            
            out.println("<h1>WE WILL CONNECT YOU WITHIN 24 HOURS....</h1>");
            out.println("<h3>Name : " + vNAME + "</h3>");
         
            try 
            {
                // STEP 2: REGISTERING THE ORACLE DRIVER WITH THIS SERVLEt
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                
                // STEP 3: INSTANTIATING THE ORACLE CONNECTION OBJECT
                oconn = (OracleConnection) DriverManager.getConnection
        ("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl", "TIITA", "DATABASE");
                
                // STEP 4: INSTANTIATING THE ORACLE PREPARED STATEMENT OBJECT
                ops = (OraclePreparedStatement) 
                        oconn.prepareCall
        ("INSERT INTO Contacts(SMASSEGE,SNAME,SEMAIL) values(?,?,?)");
                
                
                
                //STEP 6: FILLING UP THE BLANK QUERY PARAMETERS (?)
                ops.setString(1, vMESSAGE);
                ops.setString(2, vNAME);
                ops.setString(3, vEMAIL);
                                
                
                // STEP 7: EXECUTING THE QUERY
                int x = ops.executeUpdate();
                
                if(x > 0)
                {
                    out.println("<h2 style='color:green'> Record inserted successfully...");
                }
                else
                {
                    out.println("<h2 style='color:brown'> Record could not be added...");
                }
                
                //STEP 8: CLOSING THE ORACLE OBJECTS
                ops.close();
                oconn.close();
                
            } 
            
                //STEP 9: FORMATTING THE CATCH CLAU        

            catch (SQLException ex)
            {
                Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
