import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author Niladri
 */
public class AdmissionPage extends HttpServlet {

    OracleConnection oconn;
    OraclePreparedStatement ost;
    RequestDispatcher dispatcher;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String cid = request.getParameter("CourseId");
            String cname = request.getParameter("CourseName");
            String cfees = request.getParameter("CourseFees");
            String cdur = request.getParameter("CourseDur");
            String sname = request.getParameter("tbName");
            String sdob = request.getParameter("tbDob");
            String sfath = request.getParameter("tbFatherName");
            String sgen = request.getParameter("rbGender");
            String smob = request.getParameter("tbMobile");
            String semail = request.getParameter("tbEmail");
            String sadd = request.getParameter("tbAddress");
            String sdis = request.getParameter("tbDistrict");
            String sstate = request.getParameter("ddlState");
            String squal = request.getParameter("tbQualification");
            String spass = request.getParameter("tbPassingyear");
            String stmarks = request.getParameter("tbTMarks");
            String smarks = request.getParameter("tbMarks");
            String sper = request.getParameter("tbPercentage");
            

            

            try {

                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                oconn = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");

                String q = "INSERT INTO student_details values(S_ID.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                ost = (OraclePreparedStatement) oconn.prepareStatement(q);
                
                //Converting the date:-
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dt.parse(sdob);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
                sdob = dt1.format(date);

                ost.setString(1, cid);
                ost.setString(2, cname);
                ost.setString(3, cfees);
                ost.setString(4, cdur);
                ost.setString(5, sname);
                ost.setString(6, sdob);
                ost.setString(7, sfath);
                ost.setString(8, sgen);
                ost.setString(9, smob);
                ost.setString(10, semail);
                ost.setString(11, sadd);
                ost.setString(12, sdis);
                ost.setString(13, sstate);
                ost.setString(14, squal);
                ost.setString(15, spass);
                ost.setString(16, stmarks);
                ost.setString(17, smarks);
                ost.setString(18, sper);

                int rowCount = ost.executeUpdate();

                if (rowCount > 0) {
//                      response.sendRedirect("admin.html");   
               
               
                    
                    dispatcher = request.getRequestDispatcher("payment.html");
                } else {
                    out.println("<h1 style='color:red'>Registration Unsuccessful!</h1>");
                    //request.setAttribute("regstatus", "failed");
                    //dispatcher = request.getRequestDispatcher("LandingPage.jsp");
                }
                dispatcher.forward(request, response);
            } catch (IOException | SQLException | ServletException ex) {
                out.println(ex);
            }

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
        } catch (ParseException ex) {
            Logger.getLogger(AdmissionPage.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(AdmissionPage.class.getName()).log(Level.SEVERE, null, ex);
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
