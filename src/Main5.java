import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The Main5 class is used to delete related records from two tables in a
 * database.
 * It uses JDBC for database connection and manipulation, and Scanner for user
 * input.
 */
public class Main5 {
    /**
     * The main method establishes a connection to the database and allows the user
     * to delete related records
     * in the 'pasajeros' and 'vuelos' tables.
     * 
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        Connection con;
        try {
            // Establishes a connection to the 'aerolinea' database on localhost using
            // credentials.
            con = DriverManager.getConnection("jdbc:mysql://localhost/aerolinea", "xxxx", "xxxxx");

            // Prepares SQL statements for deleting records in the 'pasajeros' and 'vuelos'
            // tables.
            String deletePassengers = "DELETE FROM pasajeros WHERE cod_vuelo = ?";
            String deleteFlights = "DELETE FROM vuelos WHERE cod_vuelo = ?";
            PreparedStatement preparedStatement1 = con.prepareStatement(deletePassengers);
            PreparedStatement preparedStatement2 = con.prepareStatement(deleteFlights);

            // Creates a Scanner object to read user input.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which flight do you want to delete?");
            String flightCode = scanner.next();

            // Disables auto-commit to handle the transaction manually.
            con.setAutoCommit(false);

            try {
                // Sets the parameter in both prepared statements and executes the updates.
                preparedStatement1.setString(1, flightCode);
                preparedStatement2.setString(1, flightCode);
                String result1 = preparedStatement1.executeUpdate() + " rows affected in the Passengers table";
                String result2 = preparedStatement2.executeUpdate() + " rows affected in the Flights table";
                System.out.println(result1);
                System.out.println(result2);

                // Commits the transaction if both deletions were successful.
                con.commit();
            } catch (SQLException e) {
                // In case of an error, rolls back the transaction and shows an error message.
                System.out.println("Transaction did not execute successfully.");
                con.rollback();
            }

            // Restores auto-commit behavior.
            con.setAutoCommit(true);

            // Closes the Scanner and database resources.
            scanner.close();
            preparedStatement1.close();
            preparedStatement2.close();
            con.close();
        } catch (SQLException e) {
            // Handles any SQL exceptions that may occur during the process.
            e.printStackTrace();
        }
    }
}
