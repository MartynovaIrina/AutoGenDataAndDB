package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static org.example.CreateDatabase.createDatabase;
import static org.example.CreateTable.createTable;


public class Main {
    public static void main(String[] args) {
        DataAutoGeneration();
        createDatabase();
        createTable();

    }
        static void DataAutoGeneration() {
            String login = "user";
            String password = "password";
            String email;
            String text;
            int numberOflines = 100;
            try (BufferedWriter BufferfileWriter = new BufferedWriter(new FileWriter("accounts.txt"))) {
                for (int i = 0; i <= numberOflines; i++) {
                    if (i == 0) {
                        text = "login" + "," + "password" + "," + "email"; //creating table header
                    } else { //filling the table with data
                        email = login + i + "@mail.ru";
                        text = login + i + "," + password + i + "," + email;
                    }
                    BufferfileWriter.write(text + "\n");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }