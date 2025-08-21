package com.learning;

import java.sql.*;

public class JdbcJavaConnection {

    /*
    1. Import JDBC package
    2. Load & Register the JDBC driver
    3. Create a connection to the database
    4. Create a statement object
    5. Execute a query
    6. Process the result set
    7. Close the connection
    */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
        // For postgreSQL, use: Class.forName("org.postgresql.Driver");
        // JDBC_URL for different databases:
        // JDBC_URL Syntax: jdbc:<database_type>://<host>:<port>/<database_name>
        // JDBC_URL Syntax: jdbc:<database_type>://<ipAddress>:<port>/<database_name>
        String jdbcUrl = "jdbc:mysql://localhost:3306/employeeapi";
        // For postgreSQL, use: String jdbcUrl = "jdbc:postgresql://localhost:5432/employeeapi";
        // For SQLite, use: String jdbcUrl = "jdbc:sqlite:employeeapi.db";
        // For Oracle, use: String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        // For SQL Server, use: String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=employeeapi";
        // For MongoDB, use: String jdbcUrl = "jdbc:mongodb://localhost:27017/employeeapi";
        // For MariaDB, use: String jdbcUrl = "jdbc:mariadb://localhost:3306/employeeapi";
        // For H2, use: String jdbcUrl = "jdbc:h2:~/employeeapi";
        // For Cassandra, use: String jdbcUrl = "jdbc:cassandra://localhost:9042/employeeapi";
        // For Redis, use: String jdbcUrl = "jdbc:redis://localhost:6379/employeeapi";
        // For Neo4j, use: String jdbcUrl = "jdbc:neo4j://localhost:7687/employeeapi";
        // For HSQLDB, use: String jdbcUrl = "jdbc:hsqldb:hsql://localhost/employeeapi";
        // For Amazon Redshift, use: String jdbcUrl = "jdbc:redshift://localhost:5439/employeeapi";
        // For Apache Spark, use: String jdbcUrl = "jdbc:spark://localhost:10000/employeeapi";
        // For Snowflake, use: String jdbcUrl = "jdbc:snowflake://localhost:443/employeeapi";
        String username = "root";
        String password = "Ratanlord@1409";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Connection established successfully!");
        // Create SQL Statement Using Java
        Statement statement = connection.createStatement();
        // Selecting the data from the table
        String query = "select * from employeedetails;";
        // Inserting data into the table
        String insertQuery = "INSERT INTO employeedetails (employee_id, employee_name, job_role) VALUES ('E004', 'John Doe', 'Software Engineer')";
        // Updating data in the table
        String updateQuery = "UPDATE employeedetails SET employee_name = 'Jane Doe' WHERE employee_id = 'E004'";
        // Deleting data from the table
        String deleteQuery = "DELETE FROM employeedetails WHERE employee_id = 'E004'";
        // Execute the query & store the data into ResultSet
        ResultSet resultSet = statement.executeQuery(query);
        /*
        System.out.println(resultSet.next()); //resultSet.next() -> this will give us boolean value, if this returns true then we can identify if our query is executed successfully or not
        resultSet.next();
        String employeeName = resultSet.getString("employee_name"); // Retrieving the data present in the column called "employee_name"
        System.out.println("Employee Name is " + employeeName);
        */
        // Fetching all the rows
        while (resultSet.next()) {
            // Retrieving the data present in the table
            String employeeId = resultSet.getString("employee_id"); // Retrieving the data present in the column called "employee_id"
            String employeeName = resultSet.getString("employee_name"); // Retrieving the data present in the column called "employee_name"
            String jobeRole = resultSet.getString("job_role"); // Retrieving the data present in the column called "job_role"
            System.out.println("Employee ID: " + employeeId + ", Employee Name: " + employeeName + ", Job Role: " + jobeRole);
        }
        // When we are not sure about the number of rows and columns in the table, we can use the following code to get the metadata of the ResultSet
        // Also when we have to insert data into the table, we can use the following code to get the metadata of the table
        // Crud operations can be performed using the following code
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount(); // Getting the number of columns in the table
        System.out.println("Number of columns in the table: " + columnCount);
        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i); // Getting the name of the column
            String columnType = resultSetMetaData.getColumnTypeName(i); // Getting the type of the column
            System.out.println("Column " + i + ": " + columnName + " (" + columnType + ")");
        }
        // Inserting data into the table
        int rowsAffected = statement.executeUpdate(insertQuery);
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully!");
        } else {
            System.out.println("Data insertion failed!");
        }
        // Executing the query to check if the data is inserted successfully
        resultSet = statement.executeQuery(query);
        // Fetching all the rows after insertion
        while (resultSet.next()) {
            // Retrieving the data present in the table
            String employeeId = resultSet.getString("employee_id"); // Retrieving the data present in the column called "employee_id"
            String employeeName = resultSet.getString("employee_name"); // Retrieving the data present in the column called "employee_name"
            String jobeRole = resultSet.getString("job_role"); // Retrieving the data present in the column called "job_role"
            System.out.println("Employee ID: " + employeeId + ", Employee Name: " + employeeName + ", Job Role: " + jobeRole);
        }
        // Run the update query to update the existing data in the table
        rowsAffected = statement.executeUpdate(updateQuery);
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
        } else {
            System.out.println("Data update failed!");
        }
        // Executing the query to check if the data is updated successfully
        resultSet = statement.executeQuery(query);
        // Fetching all the rows after update
        while (resultSet.next()) {
            // Retrieving the data present in the table
            String employeeId = resultSet.getString("employee_id"); // Retrieving the data present in the column called "employee_id"
            String employeeName = resultSet.getString("employee_name"); // Retrieving the data present in the column called "employee_name"
            String jobeRole = resultSet.getString("job_role"); // Retrieving the data present in the column called "job_role"
            System.out.println("Employee ID: " + employeeId + ", Employee Name: " + employeeName + ", Job Role: " + jobeRole);
        }
        // Delete data from the table
        rowsAffected = statement.executeUpdate(deleteQuery);
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
        } else {
            System.out.println("Data deletion failed!");
        }
        // Executing the query to check if the data is deleted successfully
        resultSet = statement.executeQuery(query);
        // Fetching all the rows after deletion
        while (resultSet.next()) {
            // Retrieving the data present in the table
            String employeeId = resultSet.getString("employee_id"); // Retrieving the data present in the column called "employee_id"
            String employeeName = resultSet.getString("employee_name"); // Retrieving the data present in the column called "employee_name"
            String jobeRole = resultSet.getString("job_role"); // Retrieving the data present in the column called "job_role"
            System.out.println("Employee ID: " + employeeId + ", Employee Name: " + employeeName + ", Job Role: " + jobeRole);
        }
        // Closing the ResultSet and Statement objects
        resultSet.close();
        statement.close();
        System.out.println("ResultSet and Statement closed successfully!");
        // Closing the connection
        connection.close();
        System.out.println("Connection closed successfully!");

    }
}
