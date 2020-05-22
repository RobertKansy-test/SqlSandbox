import java.sql.*;

public class SqlServerConnection {

    public static void main(String...args) {

        try {

            String driver = "net.sourceforge.jtds.jdbc.Driver";
            String dbUrl = "jdbc:jtds:sqlserver://localhost/BookSales;instance=MSSQLSERVER";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dbUrl, "root", "");

            String query = "Select * From BikeStores.production.brands";
            Statement st = con.createStatement();

            ResultSet res = st.executeQuery(query);

            while (res.next()) {

                String id = res.getString("brand_id");
                String name = res.getString("brand_name");

                System.out.format("%s" + ": " + " %s ", id, name);
            }
            st.close();
        }
        catch (Exception e) {
            System.out.format("Error: %s, %s", e.getMessage(), e.getCause());

        }
    }
}
