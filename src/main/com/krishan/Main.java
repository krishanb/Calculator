package com.krishan;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        boolean calcWillRun = true;
        System.out.println("Welcome to Krishan's calculator, version 1.0. Enter yo'self a command: calc, hist, exit.");

        while(calcWillRun) {
            String command = InputUtil.getStringFromUser();

            switch(command){
                case "calc":
                    calc.performCalculation();
                    break;
                case "hist":
                    System.out.println("Here are your previous equations:" +calc.getPreviousExpressions());
                    break;
                case "exit":
                    calcWillRun = false;
                    break;
                default:
                    System.out.println("Please enter a command: calc, hist, exit.");
            }
        }
    }
}
//WE GOT A NULL POINTER EXCEPTION DO NOT USE THIS CODE THIS CODE IS BROKEN