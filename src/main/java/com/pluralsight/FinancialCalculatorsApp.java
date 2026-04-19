package com.pluralsight;
import java.util.Scanner;

public class FinancialCalculatorsApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        welcomeUser(input);

        boolean isRunning = true;
        while (isRunning) {
            int choice = menu(input);
            switch (choice) {
                case 1:
                    mortgageCalculatorMenu(input);
                    break;
                case 2:
                    futureValueCalculatorMenu(input);
                    break;
                case 3:
                    presentValueCalculatorMenu(input);
                    break;
                case 4:
                    isRunning = quitApp();
                    break;
                default:
                    System.out.println("Invalid input please try again.\n");
            }
        }
        input.close();
    }


    public static void welcomeUser(Scanner input) {
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.println("Hello, " + name + "! I'll help you with your financial calculations.\n");
    }

    public static int menu(Scanner input) {
        System.out.println("""
                ============================================
                    Financial Calculator
                ============================================
                (1) Mortgage Calculator
                (2) Future Value Calculator
                (3) Present Value Calculator (Annuity)
                (4) Exit
                ============================================
                Enter your choice:""");
        return input.nextInt();
    }


    public static boolean quitApp() {
        System.out.println("\nThank you for using the Financial Calculator!");
        return false;
    }


    public static void mortgageCalculatorMenu(Scanner input) {
        System.out.println("\n========== Mortgage Calculator ==========\n");

        double principal = getPrincipal(input);
        double interest = getInterestRate(input);
        double loanTermInYears = getLoanTermInYears(input);

        double monthlyRate = monthlyInterestRateMortgage(interest);
        double numOfPayments = 12 * loanTermInYears;
        double monthlyPayment = monthlyPaymentFormula(monthlyRate, principal, numOfPayments);
        double totalInterestRate = totalInterestRateMortgage(principal, numOfPayments, monthlyPayment);

        displayMortgageResults(monthlyPayment, totalInterestRate);
    }

    public static double getPrincipal(Scanner input) {
        System.out.print("What is the principal (P) on the loan? $");
        return input.nextDouble();
    }

    public static double getInterestRate(Scanner input) {
        System.out.print("Enter the nominal annual interest rate in decimal form (e.g. 0.07625): ");
        return input.nextDouble();
    }

    public static double getLoanTermInYears(Scanner input) {
        System.out.print("How many years does this loan last? ");
        return input.nextDouble();
    }

    public static double monthlyInterestRateMortgage(double interest) {
        return interest / 12;
    }

    public static double monthlyPaymentFormula(double monthlyRate, double principal, double numOfPayments) {
        return principal * ((monthlyRate * Math.pow((monthlyRate + 1), numOfPayments)) /
                (Math.pow((monthlyRate + 1), numOfPayments) - 1));
    }

    public static double totalInterestRateMortgage(double principal, double numberOfPayments, double monthlyPayment) {
        return (monthlyPayment * numberOfPayments) - principal;
    }

    public static void displayMortgageResults(double monthlyPayment, double totalInterestRate) {
        System.out.println("\n========== Results ==========");
        System.out.println("The monthly payment: $" + String.format("%.2f", monthlyPayment));
        System.out.printf("The total interest is: $%.2f\n\n", totalInterestRate);
    }
    public static void futureValueCalculatorMenu(Scanner input) {
        System.out.println("\n========== Future Value Calculator ==========\n");

        double principalDeposit = getPrincipalDeposit(input);
        double annualInterestRate = getAnnualInterestRateDeposit(input) / 100;
        int numberOfYears = getNumberOfYearsAnnuity(input);

        double futureValue = futureRateCalculator(principalDeposit, annualInterestRate, numberOfYears);
        double totalInterestEarned = totalInterest(futureValue, principalDeposit);

        displayFutureValueResults(numberOfYears, futureValue, totalInterestEarned);
    }

    public static double getPrincipalDeposit(Scanner input) {
        System.out.print("Enter the principal of the deposit: $");
        return input.nextDouble();
    }

    public static double getAnnualInterestRateDeposit(Scanner input) {
        System.out.print("Enter the annual interest rate (in percentage): ");
        return input.nextDouble();
    }

    public static double futureRateCalculator(double principalDeposit, double annualInterestRate, int numberOfYears) {
        return principalDeposit * (Math.pow((1 + (annualInterestRate / 365)), 365 * numberOfYears));
    }

    public static double totalInterest(double futureValue, double principalDeposit) {
        return futureValue - principalDeposit;
    }

    public static void displayFutureValueResults(int numberOfYears, double futureValue, double totalInterestEarned) {
        System.out.println("\n========== Results ==========");
        System.out.printf("The future value of the deposit in %d years is: $%.2f%n", numberOfYears, futureValue);
        System.out.printf("The total interest earned will be: $%.2f\n\n", totalInterestEarned);
    }


    public static void presentValueCalculatorMenu(Scanner input) {
        System.out.println("\n========== Present Value Calculator (Annuity) ==========\n");

        double monthlyPayout = getMonthlyPayout(input);
        double expectedInterestRate = getExpectedInterestRate(input);
        int numberOfYears = getNumberOfYearsAnnuity(input);

        double monthlyInterestRate = monthlyInterestRateAnnuity(expectedInterestRate);
        double totalNumberOfPayments = totalNumberOfPayments(numberOfYears);
        double presentValue = presentValue(monthlyInterestRate, totalNumberOfPayments, monthlyPayout);

        displayPresentValueResults(monthlyPayout, presentValue);
    }

    public static double getMonthlyPayout(Scanner input) {
        System.out.print("Enter the accepted monthly payout of the ordinary annuity: $");
        return input.nextDouble();
    }

    public static double getExpectedInterestRate(Scanner input) {
        System.out.print("Enter the expected annual interest rate (in decimal form, e.g. 0.06): ");
        return input.nextDouble();
    }

    public static int getNumberOfYearsAnnuity(Scanner input) {
        System.out.print("Enter the number of years it takes for the payout: ");
        return input.nextInt();
    }

    public static double monthlyInterestRateAnnuity(double expectedInterestRate) {
        return expectedInterestRate / 12;
    }

    public static double totalNumberOfPayments(int numberOfYears) {
        return (double) numberOfYears * 12;
    }

    public static double presentValue(double monthlyInterestRate, double totalNumberOfPayments, double monthlyPayout) {
        return monthlyPayout * ((1 - Math.pow((1 + monthlyInterestRate), -totalNumberOfPayments)) / monthlyInterestRate);
    }

    public static void displayPresentValueResults(double monthlyPayout, double presentValue) {
        System.out.println("\n========== Results ==========");
        System.out.printf("Monthly payout: $%.2f%n", monthlyPayout);
        System.out.printf("The present value for monthly annuity you will need is: $%.2f\n\n", presentValue);
    }
}
