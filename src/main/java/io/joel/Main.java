package io.joel;

import io.joel.helpers.DatabaseManager;
import io.joel.models.Stat;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:stats.db")) {

            DatabaseManager dbm = new DatabaseManager(conn);
            dbm.dropStatTable();
            dbm.createStatTable();
            dbm.insertIntoStatTable("joel", 100, 40);
            ArrayList<Stat> results = dbm.getStats();


        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("We encountered a problem talking to the database");
        }


        System.out.println("It works!");
    }
}
