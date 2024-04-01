import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215) // for max 16 MB images

public class AddCourse extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
         String cfee = request.getParameter("cfee");
          String cdu = request.getParameter("cdu");
           String cdes = request.getParameter("cdes");
         
        Connection conn = null;

        try {
                // Register JDBC driver
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Open a connection
                conn = DriverManager.getConnection("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");

                // Insert the movie into the database
                String sql = "INSERT INTO COURSES VALUES (C_ID.NEXTVAL,?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, cname);
                statement.setString(2, cfee);
                statement.setString(3, cdu);
                statement.setString(4, cdes);
                Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">
                InputStream fileContent = filePart.getInputStream();
                String fileName = filePart.getSubmittedFileName();
                long fileSize = filePart.getSize();
                statement.setBinaryStream(5, fileContent, (int) fileSize);

                    int row = statement.executeUpdate();

                    if (row > 0) {
                        System.out.println(cname);
                        response.sendRedirect("http://localhost:8080/OC/AddCourse.jsp?status=success");

                    }
                    else
                    {
                        response.sendRedirect("http://localhost:8080/OC/AddCourse.jsp?status=failed");
                    }
        }catch (SQLException ex) {
            Logger.getLogger( AddCourse.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ClassNotFoundException ex) {
              Logger.getLogger( AddCourse.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}