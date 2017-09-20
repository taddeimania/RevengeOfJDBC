package io.joel;

import io.joel.helpers.DatabaseManager;
import io.joel.helpers.UI;
import io.joel.models.Stat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Welcome to my stat tracker!");
        Scanner scanner = new Scanner(System.in);
        Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:stats.db")) {

            DatabaseManager dbm = new DatabaseManager(conn);

            while (true) {
                System.out.println("==-=-=--------=====-=-=-=!!! :)");
                System.out.println("What would you like to do? ");
                System.out.println("(1) Add a Stat");
                System.out.println("(2) See all Stats");
                System.out.println("(3) Refresh Data");

                String userChoice = scanner.nextLine();

                if (userChoice.equals("1")) {
                    Stat myStat = UI.createStat();
                    dbm.insertIntoStatTable(myStat);
                } else if (userChoice.equals("2")) {
                    ArrayList<Stat> results = dbm.getStats();

                    for (Stat stat : results) {
                        System.out.println(stat);
                    }
                } else if (userChoice.equals("3")){
                    dbm.dropStatTable();
                    dbm.createStatTable();
                } else {
                    break;
                }
            }


            /*
            Stat myStat = UI.createStat();
            dbm.insertIntoStatTable(myStat);

            */


        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("We encountered a problem talking to the database");
        }


        System.out.println("It works!");
    }
}
