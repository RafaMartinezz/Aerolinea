import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The Main4 class is used to insert data into a database table based on user
 * input.
 * It uses JDBC for database connection and manipulation, and Scanner for user
 * input.
 */
public class Main4 {
    /**
     * The main method establishes a connection to the database and allows the user
     * to insert data into the 'vuelos' table.
     * 
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String args[]) {
        Connection con;
        try {
            // Establishes a connection to the 'aerolinea' database on localhost using
            // credentials.
            con = DriverManager.getConnection("jdbc:mysql://localhost/aerolinea", "xxxxx", "xxxxxx");

            // Prepares an SQL statement for inserting data into the 'vuelos' table.
            String query = "INSERT INTO vuelos VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            // Creates a Scanner object to read user input.
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "Enter flight data separated by comma and space in the following order: \nFLIGHT CODE, DEPARTURE TIME, DESTINATION, ORIGIN, SMOKING SEATS, NON-SMOKING SEATS, ECONOMY SEATS, FIRST CLASS SEATS");

            // Reads the flight data input from the user and splits it into an array.
            String[] data = scanner.nextLine().split(", ");

            // Assigns each piece of data to its respective variable, converting data types
            // as needed.
            String cod_vuelo = data[0];
            String hora_salida = data[1];
            String destino = data[2];
            String procedencia = data[3];
            int plazas_fumadores = Integer.parseInt(data[4]);
            int plazas_no_fumadores = Integer.parseInt(data[5]);
            int plazas_turista = Integer.parseInt(data[6]);
            int plazas_primera = Integer.parseInt(data[7]);

            // Sets the parameters in the prepared statement with the data provided by the
            // user.
            preparedStatement.setString(1, cod_vuelo);
            preparedStatement.setString(2, hora_salida);
            preparedStatement.setString(3, destino);
            preparedStatement.setString(4, procedencia);
            preparedStatement.setInt(5, plazas_fumadores);
            preparedStatement.setInt(6, plazas_no_fumadores);
            preparedStatement.setInt(7, plazas_turista);
            preparedStatement.setInt(8, plazas_primera);

            // Executes the update query and prints the number of affected rows.
            String result = preparedStatement.executeUpdate() + " rows inserted";
            System.out.println(result);

            // Closes the Scanner and database resources.
            scanner.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            // Handles any SQL exceptions that may occur during the process.
            e.printStackTrace();
        }
    }
}
