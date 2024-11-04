import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The Main3 class is used to execute a parameterized query on a database and
 * display the results.
 * It uses JDBC for database connection and query execution, and Scanner for
 * user input.
 */
public class Main3 {
    /**
     * The main method establishes a database connection, receives a user-defined
     * parameter,
     * executes a parameterized query, and displays the results.
     * 
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String args[]) {
        try {
            // Establishes a connection to the 'aerolinea' database on localhost using
            // credentials.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aerolinea", "xxxx", "xxxxxx");

            // Prepares an SQL query with a parameter (num) to be provided by the user.
            String query = "SELECT * FROM pasajeros WHERE num = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            // Creates a Scanner object to read user input.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the passenger number you want to search for:");
            int numero = scanner.nextInt(); // Reads the passenger number from the user.

            // Sets the parameter in the prepared query using the user-provided number.
            preparedStatement.setInt(1, numero);

            // Executes the query and stores the result in a ResultSet.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Obtains metadata from the ResultSet, containing information about the table
            // columns.
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columnCount = metadata.getColumnCount();

            // Prints the column names of the table.
            for (int i = 1; i <= columnCount; i++) {
                String formatted = String.format("%-20s", metadata.getColumnName(i));
                System.out.print(formatted);
            }

            System.out.println();

            // Iterates over each row in the result set.
            while (resultSet.next()) {
                // Iterates over each column in the row.
                for (int i = 1; i <= columnCount; i++) {
                    String result = resultSet.getString(i);
                    String formatted = String.format("%-20s", result);
                    System.out.print(formatted);
                }

                // Prints a new line at the end of each row.
                System.out.println();
            }

            // Closes the Scanner and database resources.
            scanner.close();
            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            // Handles any SQL exceptions that may occur during the process.
            e.printStackTrace();
        }
    }
}
