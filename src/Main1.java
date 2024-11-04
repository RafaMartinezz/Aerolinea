import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

/**
 * The Main1 class connects to a database and retrieves metadata about it.
 * It uses JDBC to establish the connection and access database metadata.
 */
public class Main1 {

    /**
     * The main method establishes a connection to the database and retrieves
     * information about it.
     *
     * @param args Command-line arguments (not used in this case).
     * @throws Exception May throw an exception if an error occurs during connection
     *                   or data retrieval.
     */
    public static void main(String[] args) throws Exception {
        try {
            // Establishes a connection to the 'aerolinea' database on localhost using
            // provided credentials.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aerolinea", "xxxxx", "xxxxxxx");

            // Obtains database metadata through the established connection.
            DatabaseMetaData dbmd = con.getMetaData();

            // Retrieves specific metadata and stores it in variables.
            String nombre = dbmd.getDatabaseProductName(); // Database product name
            String driver = dbmd.getDriverName(); // JDBC driver name
            String url = dbmd.getURL(); // Database connection URL
            String usuario = dbmd.getUserName(); // Username used for the connection

            // Prints the retrieved database information.
            System.out.println("DATABASE INFORMATION:");
            System.out.println("-----------------------------------");
            System.out.printf("Name    : %s %n", nombre);
            System.out.printf("Driver  : %s %n", driver);
            System.out.printf("URL     : %s %n", url);
            System.out.printf("User    : %s %n", usuario);
            System.out.println();
        } catch (SQLException e) {
            // Handles any SQL exceptions that may occur during the process.
            e.printStackTrace();
        }
    }
}
