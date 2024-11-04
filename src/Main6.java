import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The Main6 class is used to update records in a database table.
 * It uses JDBC for database connection and manipulation.
 */
public class Main6 {
    /**
     * The main method establishes a connection to the database and updates records
     * in the 'vuelos' table.
     * 
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        try {
            // Establishes a connection to the 'aerolinea' database on localhost using
            // provided credentials.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aerolinea", "xxxxx", "xxxxx");

            // Prepares an SQL statement to update records in the 'vuelos' table.
            String sqlString = "UPDATE vuelos SET plazas_fumador = plazas_no_fumador";
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);

            // Executes the update query and stores the number of affected rows.
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println(numberOfRows + " rows updated");

            // Closes the PreparedStatement and the database connection.
            preparedStatement.close();
            con.close();

        } catch (SQLException e) {
            // Handles any SQL exceptions that may occur during the process.
            e.printStackTrace();
        }
    }
}
