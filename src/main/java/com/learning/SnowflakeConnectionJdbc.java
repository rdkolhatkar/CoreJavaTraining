package com.learning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class SnowflakeConnectionJdbc {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // STEP 1: Setup JDBC connection properties
            Properties properties = new Properties();

            // Snowflake requires specific parameters for authentication.
            // Always avoid hardcoding credentials in production. Use environment variables or a secure vault.
            properties.put("user", System.getenv("SNOWFLAKE_USER")); // Snowflake username
            properties.put("password", System.getenv("SNOWFLAKE_PASSWORD")); // Snowflake password
            properties.put("warehouse", "COMPUTE_WH"); // Name of the warehouse
            properties.put("db", "TEST_DB"); // Database name
            properties.put("schema", "PUBLIC"); // Schema name
            properties.put("role", "SYSADMIN"); // Optional: Role for the session

            // STEP 2: Create the JDBC connection string
            // format: jdbc:snowflake://<account>.snowflakecomputing.com
            String connectionUrl = "jdbc:snowflake://<your_account>.snowflakecomputing.com/";

            // STEP 3: Get the connection
            connection = DriverManager.getConnection(connectionUrl, properties);
            System.out.println("✅ Connection established successfully to Snowflake.");

            // STEP 4: Create a statement object for executing SQL queries
            statement = connection.createStatement();

            // STEP 5: Create a table (if not exists)
            String createTable = "CREATE OR REPLACE TABLE USERS ("
                    + "USER_ID INT AUTOINCREMENT, "
                    + "USERNAME STRING, "
                    + "EMAIL STRING)";
            statement.execute(createTable);
            System.out.println("✅ Table USERS created or replaced.");

            // STEP 6: Insert a record
            String insertQuery = "INSERT INTO USERS (USERNAME, EMAIL) VALUES ('Alice', 'alice@example.com')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println("✅ Rows inserted: " + rowsInserted);

            // STEP 7: Query the table
            String selectQuery = "SELECT USER_ID, USERNAME, EMAIL FROM USERS";
            resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int userId = resultSet.getInt("USER_ID");
                String username = resultSet.getString("USERNAME");
                String email = resultSet.getString("EMAIL");
                System.out.println("👤 User: " + userId + " | " + username + " | " + email);
            }

            // STEP 8: Update a record
            String updateQuery = "UPDATE USERS SET EMAIL = 'alice_updated@example.com' WHERE USERNAME = 'Alice'";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            System.out.println("✅ Rows updated: " + rowsUpdated);

            // STEP 9: Delete a record
            String deleteQuery = "DELETE FROM USERS WHERE USERNAME = 'Alice'";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println("✅ Rows deleted: " + rowsDeleted);

        } catch (SQLException e) {
            // STEP 10: Handle SQL exceptions
            System.err.println("❌ SQL Exception: " + e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {
            // Catch all unexpected exceptions
            System.err.println("❌ Unexpected error: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // STEP 11: Close resources in reverse order of creation
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("✅ Connection closed.");
            } catch (SQLException e) {
                System.err.println("❌ Error closing resources: " + e.getMessage());
            }
        }
    }
}
