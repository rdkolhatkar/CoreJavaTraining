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
    }
}
