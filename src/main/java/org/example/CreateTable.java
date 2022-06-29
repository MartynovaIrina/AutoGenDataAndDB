package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Accounts"
            + "("
            + " ID serial,"
            + " login varchar(20) NOT NULL,"
            + " password varchar(20) NOT NULL,"
            + " email varchar(20) NOT NULL,"
            + " PRIMARY KEY (ID)"
            + ")";

    public static void main(String[] args) {
        createTable();
    }
    static void createTable(){
        // auto close
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/accounts_info", "postgres", "12345678");
             Statement statement = connection.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_CREATE);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}