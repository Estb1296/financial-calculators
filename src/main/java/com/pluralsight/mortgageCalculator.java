package com.pluralsight;
import java.util.Scanner;
public class mortgageCalculator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("What is your name?");
        String name=input.nextLine();
        System.out.println("What is the principal(P) on the loan?");
        float principal=input.nextFloat();
        System.out.println("The nominal annual interest rate in decimal form.\n" +
                "(e.g. 7.625% = 0.07625)");
        float interest=input.nextFloat()*100;
        System.out.println("What is the number of payments per year?(Number of Monthly Payments (n):)");
        int numMonthlyPayments=input.nextInt();
        System.out.println("How many years does this loan last?(Loan Term in Years (y))");
        int loanTermInYears= input.nextInt();
        System.out.println("The monthly interest rate is: ");
        System.out.printf("%s, the monthly interest rate is: %.2f%%n",name,monthlyInterestRate(input,interest));
    }
    public static float monthlyInterestRate(Scanner input,float interest){
        //interest=input.nextFloat();
        return (interest/12);
    }
}
