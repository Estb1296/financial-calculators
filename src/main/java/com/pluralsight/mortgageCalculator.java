package com.pluralsight;
import java.util.Scanner;
public class mortgageCalculator {
    public static void main(String[] args) {
        float monthlyPayment;
        float monthlyRate=0;
        int loanTermInYears=0;
        Scanner input=new Scanner(System.in);
        System.out.println("What is your name?");
        String name=input.nextLine();
        System.out.println("Hello,"+name+" I'll help you with your morgage calculations.");
        System.out.println("What is the principal(P) on the loan?");
        float principal=input.nextFloat();
        System.out.println("The nominal annual interest rate in decimal form.\n" +
                "(e.g. 7.625% = 0.07625)");
        float interest=input.nextFloat();

        System.out.println("What is the number of payments per year?(Number of Monthly Payments (n):)");
        int numMonthlyPayments = input.nextInt();
        System.out.println("How many years does this loan last?(Loan Term in Years (y))");
        loanTermInYears= input.nextInt();
        float numOfPayments=12*loanTermInYears;
        System.out.println("Number of payments " + numOfPayments);//this is not the number of payments per year

        monthlyInterestRate(interest,monthlyRate,loanTermInYears);
        System.out.println(numMonthlyPayments);
        System.out.println((loanTermInYears));
        monthlyPayment=(monthlyPaymentFormula(monthlyRate,principal,loanTermInYears))/((numMonthlyPayments*loanTermInYears));
        System.out.println("This is the monthly payment: "+  monthlyPayment);
        input.close();
    }
    public static void monthlyInterestRate(float interest,float monthlyRate,float loanTermInYears){
        System.out.println("The monthly interest rate is: ");
       monthlyRate=interest/12;
        System.out.printf("%.2f",monthlyRate*100);
        System.out.println("%");

        //System.out.println(numMonthlyPayments);

    }
    /*public static float totalInterestRate(float principal,int numMonthlyPayments){
        /* float totalInterest=
        return principal;
    }*/
    public static float monthlyPaymentFormula(float monthlyRate,float principal,float numOfPayments){
        float monthlyPayment;
        // replace numMonthlyPayments by numOfpayments
        monthlyPayment = (float) (principal * ((monthlyRate * Math.pow(1 + monthlyRate, numOfPayments)) / (Math.pow(1 + monthlyRate, numOfPayments) - 1)));
        return monthlyPayment;
    }


}
