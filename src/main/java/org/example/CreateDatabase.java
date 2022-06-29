package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    private static final String SQL_CREATE_DB = "CREATE DATABASE accounts_info";

    public static void main(String[] args) {
        createDatabase();
    }
    static void createDatabase(){
        // auto close
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/", "postgres", "12345678");
             Statement statement = connection.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_CREATE_DB);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
