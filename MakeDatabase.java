import java.sql.*;

public class MakeDatabase {

    static Statement statement;

    public static void main(String[] argv) {
        try {
            // Load the H2 driver and connect to the database
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/Desktop/myservers/databases/stockdb", "sa", "");

            statement = conn.createStatement();

            // Create the STOCK table
            makeStockTable();
           

  printTable("STOCK", 4);

            // Close the connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printTable(String tableName, int numColumns) throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("\nRows from " + tableName + ":");
        while (rs.next()) {
            StringBuilder row = new StringBuilder("Row: ");
            for (int i = 1; i <= numColumns; i++) {
                row.append(rs.getString(i)).append(" ");
            }
            System.out.println(row);
        }
    }





static void makeStockTable() throws SQLException {
    // Drop the table if it already exists
    String sql = "DROP TABLE IF EXISTS STOCK";
    statement.executeUpdate(sql);

    // Create the STOCK table with the required fields
    sql = "CREATE TABLE STOCK (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "TITLE VARCHAR(100) NOT NULL, " +
            "STATUS VARCHAR(20) NOT NULL, " +
            "NOTE TEXT)";
    statement.executeUpdate(sql);

    // Insert 20 sample records into the STOCK table
    sql = "INSERT INTO STOCK (TITLE, STATUS, NOTE) VALUES " +
            "('Product A', 'Available', 'New shipment arrived'), " +
            "('Product B', 'Out of Stock', 'Next shipment expected next week'), " +
            "('Product C', 'Available', 'Limited stock remaining'), " +
            "('Product D', 'Available', 'Seasonal discount applied'), " +
            "('Product E', 'Out of Stock', 'Discontinued product'), " +
            "('Product F', 'Available', 'New collection added'), " +
            "('Product G', 'Available', 'High demand item'), " +
            "('Product H', 'Out of Stock', 'Awaiting supplier delivery'), " +
            "('Product I', 'Available', 'Special edition'), " +
            "('Product J', 'Available', 'Customer favorite'), " +
            "('Product K', 'Out of Stock', 'Pending stock update'), " +
            "('Product L', 'Available', 'Discount offer valid for 1 week'), " +
            "('Product M', 'Available', 'Online exclusive'), " +
            "('Product N', 'Out of Stock', 'Temporarily unavailable'), " +
            "('Product O', 'Available', 'New arrival in store'), " +
            "('Product P', 'Available', 'Pre-order available'), " +
            "('Product Q', 'Available', 'Special sale item'), " +
            "('Product R', 'Out of Stock', 'Limited edition sold out'), " +
            "('Product S', 'Available', 'Restocked recently'), " +
            "('Product T', 'Available', 'Best-seller product')";
    statement.executeUpdate(sql);
}

}
