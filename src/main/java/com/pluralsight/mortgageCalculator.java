package com.pluralsight;
import java.util.Scanner;
public class mortgageCalculator {
    public static void main(String[] args) {
        double monthlyPayment;
        double monthlyRate;
        double totalInterestRate;
        Scanner input=new Scanner(System.in);
        System.out.println("What is your name?");
        String name=input.nextLine();
        System.out.println("Hello,"+name+" I'll help you with your morgage calculations.");
        System.out.println("What is the principal(P) on the loan?");
        double principal = input.nextFloat();
        System.out.println("The nominal annual interest rate in decimal form.\n" +
                "(e.g. 7.625% = 0.07625)");
        double interest=input.nextFloat();
        System.out.println("How many years does this loan last?(Loan Term in Years (y))");
        double loanTermInYears= input.nextFloat();
       // System.out.println("What is the number of payments per year?(Number of Monthly Payments (n):)");
        //double numMonthlyPayments = input.nextInt();
        double numOfPayments = 12 * loanTermInYears;


        monthlyRate = monthlyInterestRate(interest);  // ← CAPTURE the return value

        monthlyPayment = monthlyPaymentFormula(monthlyRate, principal,numOfPayments);
        totalInterestRate = totaInterestRate(principal,numOfPayments,monthlyPayment);
        System.out.println("The monthly payment: $" + String.format("%.2f", monthlyPayment));
        System.out.printf("The total interest is: $%.2f",totalInterestRate);
    }
    public static double monthlyInterestRate(double interest) {
        System.out.println("The monthly interest rate is: ");
        double monthlyRate = interest / 12;
        System.out.printf("%.2f", monthlyRate * 100);
        System.out.println("%");
        return monthlyRate;  // ← RETURN it
    }
    /*public static float totalInterestRate(float principal,int numMonthlyPayments){
        /* float totalInterest=
        return principal;
    }*/
    public static double monthlyPaymentFormula(double monthlyRate, double principal,double numOfPayments) {
        double monthlyPayment;
        monthlyPayment = (float) (principal * ((monthlyRate * Math.pow((monthlyRate + 1), numOfPayments)) / (Math.pow((monthlyRate + 1), numOfPayments) - 1)));
        return monthlyPayment;
    }
    public static double totaInterestRate(double principal,double numberOfPayments,double monthlypayment){
        double totalInterest;
        totalInterest=(monthlypayment*numberOfPayments)-principal;
        return totalInterest;
    }
    }



//Calculator 1: A mortgage calculator - it is used to calculate out how
//much a monthly payment for a loan would be (minus any insurance or
//        taxes), as well as how much interest you would pay over the life of the
//loan.
//a. It would accept the principal, interest rate, and loan length from
//the user
//b. It would display the expected monthly payment and total interest
//paid
//Example: A $53,000 loan at 7.625% interest for 15 years would have a
//$495.09/mo payment with a total interest of $36,115.99
//This calculator would use a compounded interest formula.
//M = P × (i * (1 + i)^n / ( (1 + i)^n ) - 1)
//        • Monthly Payment (M) =
//o Principal (P):
//        - This is the total amount of the loan.
//o Annual Interest Rate (r):
//        - The nominal annual interest rate in decimal form.
//        (e.g. 7.625% = 0.07625)
//o Loan Term in Years (y):
//        - How many years the loan lasts.
//o Number of Monthly Payments (n):
//        - This is 12 × y (Because there are 12 monthly payments per year.)
//o Monthly Interest Rate (i):
//        • This is the annual interest rate divided by 12, i.e. r/12
//Total Interest = (M×n)−P
