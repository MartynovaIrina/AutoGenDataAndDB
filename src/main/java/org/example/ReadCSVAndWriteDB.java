package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.*;

public class ReadCSVAndWriteDB {
    private static final String INSERT_PERSON_QUERY = "INSERT INTO accounts (login, password, email) VALUES (?, ?, ?)";

    public static void main(String[] args) throws Exception{
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/accounts_info", "postgres", "12345678")) {

            try (CSVReader reader = new CSVReader(new FileReader("accounts.txt"));
                 PreparedStatement statement = connection.prepareStatement(INSERT_PERSON_QUERY)) {
                String[] record;
                record = reader.readNext();
                while ((record = reader.readNext()) != null) {
                    statement.setString(1, record[0]);
                    statement.setString(2, record[1]);
                    statement.setString(3, record[2]);
                    statement.executeUpdate();
                }
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}