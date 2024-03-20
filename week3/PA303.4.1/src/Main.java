import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Problem 1
        int x = 7;
        if (x < 10) {
            System.out.println("Less than 10");
        }
        x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        }

        //Problem 2
        x = 7;
        if (x < 10) {
            System.out.println("Less than 10");
        } else {
            System.out.println("Greater than 10");
        }
        x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        } else {
            System.out.println("Greater than 10");
        }

        //Problem 3
        x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if ((x > 10) && (x < 20)) {
            System.out.println("Between 10 and 20");
        } else if (x >= 20) {
            System.out.println("Greater than or equal to 20");
        }
        x = 50;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if ((x > 10) && (x < 20)) {
            System.out.println("Between 10 and 20");
        } else if (x >= 20) {
            System.out.println("Greater than or equal to 20");
        }

        //Problem 4
        x = 15;
        if ((x < 10) || (x > 20)) {
            System.out.println("Out of range");
        } else {
            System.out.println("In range");
        }
        x = 5;
        if ((x < 10) || (x > 20)) {
            System.out.println("Out of range");
        } else {
            System.out.println("In range");
        }

        //Problem 5
        Scanner scan = new Scanner(System.in);
        System.out.println("Input a grade 0 - 100");

        int grade = scan.nextInt();

        if ((grade >= 90) && (grade <= 100)) {
            System.out.println("A");
        } else if ((grade >= 80) && (grade <= 89)) {
            System.out.println("B");
        } else if ((grade >= 70) && (grade <= 79)) {
            System.out.println("C");
        } else if ((grade >= 60) && (grade <= 69)) {
            System.out.println("D");
        } else if (grade <= 60) {
            System.out.println("F");
        } else {
            System.out.println("Score out of range");
        }

        //Problem 6
        System.out.println("Input a number 1 - 7");
        int day = scan.nextInt();

        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Out of range");
                break;
        }

        //Problem 7
        System.out.println("Input filing status: Single, Married Filing Jointly, Married Filing Separately, or Head of Household");
        scan.nextLine();
        String userStatus = scan.nextLine();
        System.out.println("Input income");
        int userIncome = scan.nextInt();

        tax(userStatus, userIncome);
    }

//method for Problem 7
public static void tax(String status, int income){

        double taxAmount = 0.0;

        switch(status){
            case "Single":
                if ((income > 0) && (income <= 8350)){
                    taxAmount = (income * 0.1);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 8351) && (income <= 33950)){
                    taxAmount = (income * 0.15);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 33951) && (income <= 82250)){
                    taxAmount = (income * 0.25);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 82251) && (income <= 171550)){
                    taxAmount = (income * 0.28);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 171551) && (income <= 372950)){
                    taxAmount = (income * 0.33);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else {
                    taxAmount = (income * 0.35);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                }
                break;

            case "Married Filing Jointly":
                if ((income > 0) && (income <= 16700)){
                    taxAmount = (income * 0.1);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 16701) && (income <= 67900)){
                    taxAmount = (income * 0.15);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 67901) && (income <= 137050)){
                    taxAmount = (income * 0.25);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 137051) && (income <= 208850)){
                    taxAmount = (income * 0.28);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 208851) && (income <= 372950)){
                    taxAmount = (income * 0.33);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else {
                    taxAmount = (income * 0.35);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } break;

            case "Married Filing Separately":
                if ((income > 0) && (income <= 8350)){
                    taxAmount = (income * 0.1);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 8351) && (income <= 33950)){
                    taxAmount = (income * 0.15);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 33951) && (income <= 68525)){
                    taxAmount = (income * 0.25);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 68526) && (income <= 104425)){
                    taxAmount = (income * 0.28);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 104426) && (income <= 186475)){
                    taxAmount = (income * 0.33);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else {
                    taxAmount = (income * 0.35);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } break;

            case "Head of Household":
                if ((income > 0) && (income <= 11950)){
                    taxAmount = (income * 0.1);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 11951) && (income <= 45500)){
                    taxAmount = (income * 0.15);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 45501) && (income <= 117450)){
                    taxAmount = (income * 0.25);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 117451) && (income <= 190200)){
                    taxAmount = (income * 0.28);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else if ((income >= 190201) && (income <= 372950)){
                    taxAmount = (income * 0.33);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } else {
                    taxAmount = (income * 0.35);
                    System.out.printf("Tax Amount = $%.2f", taxAmount);
                } break;
            default:
                System.out.println("Incorrect Filing Status and/or Income Entered");
        }
    }
}
