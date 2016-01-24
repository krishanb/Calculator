package com.krishan;

import java.util.Scanner;

public class InputUtil {

    private static Scanner input = new Scanner(System.in);

    public static double getNumberFromUser() {
        boolean numberIsLegal = false;
        double number = 0;
        while (!numberIsLegal) {
            try {
                number = input.nextDouble();
                input.nextLine(); // Needed to flush line buffer
                numberIsLegal = true;
            } catch (Exception e) {
                System.out.println("I said give me a number!");
                input.next();
            }
        }
        return number;
    }

    public static String getOperatorFromUser() {
        boolean operatorIsLegal = false;
        String operator = "";
        while (!operatorIsLegal) {
            operator = getStringFromUser();
            if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
                System.out.println("Stop being silly, Choose from: +, -, *, /");
            } else {
                operatorIsLegal = true;
            }
        }
        return operator;
    }

    public static String getStringFromUser() {
        return input.nextLine();
    }
}
