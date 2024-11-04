# Database Operations Project

This project demonstrates various database operations using JDBC, including connecting to a database, executing queries, updating records, and managing transactions. Each class performs a specific operation such as retrieving metadata, performing parameterized queries, deleting related records, or updating existing records in the database.

## Project Structure

- **Main1**: Connects to a database and retrieves metadata such as the database name, driver, URL, and user information.
- **Main2**: Executes a query to retrieve all records from the `pasajeros` table and formats the output as a table.
- **Main3**: Prompts the user for a passenger number and performs a parameterized search in the `pasajeros` table, displaying the matching records.
- **Main4**: Collects flight data from the user and inserts a new record into the `vuelos` table.
- **Main5**: Deletes records related to a specific flight code in both `pasajeros` and `vuelos` tables, handling the operation as a transaction.
- **Main6**: Updates the `vuelos` table, setting the value of `plazas_fumador` equal to `plazas_no_fumador` for all rows.

## Technologies Used

- **Java JDBC**: Used for connecting to and interacting with the database.
- **MySQL**: Database used for storing and managing `aerolinea` data.
- **Scanner**: Captures user input for dynamic query operations.

## Classes and Descriptions

### 1. Main1
- **Function**: Connects to the database and retrieves metadata.
- **Details**: Prints database information, including product name, driver, URL, and user.

### 2. Main2
- **Function**: Retrieves and displays all data from the `pasajeros` table.
- **Details**: Formats output in a table-like structure based on column names and values.

### 3. Main3
- **Function**: Conducts a parameterized search in the `pasajeros` table.
- **Details**: Prompts the user for a passenger number and retrieves records matching that ID.

### 4. Main4
- **Function**: Inserts a new flight record into the `vuelos` table.
- **Details**: Gathers flight information from the user and populates a new entry in the database.

### 5. Main5
- **Function**: Deletes records with a specific flight code in `pasajeros` and `vuelos`.
- **Details**: Implements a transaction to ensure both deletions succeed or fail together. Rolls back if an error occurs.

### 6. Main6
- **Function**: Updates `plazas_fumador` in the `vuelos` table to match `plazas_no_fumador`.
- **Details**: Executes a bulk update on the `vuelos` table, affecting all rows.

## Requirements

- **Java Development Kit (JDK)**: Version 8 or above.
- **MySQL Database**: Ensure a MySQL instance is running with a database named `aerolinea`.
- **JDBC Driver**: Include the MySQL JDBC driver in the classpath for database connectivity.