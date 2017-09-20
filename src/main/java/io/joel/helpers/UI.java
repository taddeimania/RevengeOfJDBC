package io.joel.helpers;

import io.joel.models.Stat;

import java.util.Scanner;

public class UI {

    public static Stat createStat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of Athlete? ");
        String myName = scanner.nextLine();
        System.out.println("Number of Wins? ");
        int myWins = scanner.nextInt();
        System.out.println("Number of Losses? ");
        int myLosses = scanner.nextInt();

        return new Stat(myName, myWins, myLosses);
    }
}
