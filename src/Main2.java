import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Main2 class connects to a database, retrieves, and displays information
 * from a specific table.
 * It uses JDBC to establish the connection and execute an SQL query.
 */
public class Main2 {

    /**
     * The main method connects to a database, executes a query, and displays the
     * results.
     *
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String args[]) {
        try {
            // Establishes a connection to the 'aerolinea' database on localhost using
            // provided credentials.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aerolinea", "xxxxxx", "xxxxxxxx");

            // Creates a Statement object to execute SQL queries.
            Statement statement = con.createStatement();

            // Defines an SQL query to retrieve all data from the 'pasajeros' table.
            String sql = "SELECT * FROM pasajeros";

            // Executes the SQL query and stores the results in a ResultSet.
            ResultSet result = statement.executeQuery(sql);

            // Obtains metadata from the ResultSet, containing information about the table
            // columns.
            ResultSetMetaData metadata = result.getMetaData();

            // Gets the number of columns in the table.
            int numeroColumnas = metadata.getColumnCount();

            // Prints a header for the 'pasajeros' table output.
            System.out.println("\n");
            System.out.println("PASAJEROS TABLE");
            System.out.println("---------------");
            System.out.println("\n");

            // Iterates over all columns and prints them with specific formatting.
            for (int i = 1; i <= numeroColumnas; i++) {
                String formatted = String.format("%-20s", metadata.getColumnName(i));
                System.out.print(formatted);
            }

            System.out.println("\n");

            // Iterates over each row in the result set.
            while (result.next()) {
                // Iterates over each column in the row to print its data.
                for (int i = 1; i <= numeroColumnas; i++) {
                    String data = result.getString(i);
                    String formatted = String.format("%-20s", data);
                    System.out.print(formatted);
                }

                // Prints a new line at the end of each row.
                System.out.println();
            }

            // Closes the ResultSet, Statement, and the database connection.
            result.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            // Handles any SQL exceptions that may occur during the process.
            e.printStackTrace();
        }
    }
}
