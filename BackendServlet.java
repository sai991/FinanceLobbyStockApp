import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.*;

public class BackendServlet extends HttpServlet {
    private static Connection conn;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(
                "jdbc:h2:~/Desktop/myservers/databases/stockdb", 
                "sa", 
                ""
            );
            System.out.println("BackendServlet: Connection to DB successful.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Database connection failed.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            String sql = "SELECT ID, TITLE, STATUS, NOTE FROM STOCK LIMIT 10";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Gson gson = new Gson();
            JsonArray stockArray = new JsonArray();

            while (rs.next()) {
                JsonObject stock = new JsonObject();
                stock.addProperty("id", rs.getInt("ID"));
                stock.addProperty("title", rs.getString("TITLE"));
                stock.addProperty("status", rs.getString("STATUS"));
                stock.addProperty("note", rs.getString("NOTE"));
                stockArray.add(stock);
            }

            out.print(gson.toJson(stockArray));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
