public class JavaBasicsClass {


    public static void main(String[] args){
        //Problem 1
        int int1 = 1;
        int int2 = 2;
        int intSum = int1 + int2;


        System.out.println(intSum);


        //Problem 2
        double double1 = 1.5;
        double double2 = 2.5;
        double doubleSum = double1 + double2;


        System.out.println(doubleSum);


        //Problem 3 (mixSum must be type double)
        int int3 = 3;
        double double3 = 3.5;
        double mixSum = int3 + double3;


        System.out.println(mixSum);


        //Problem 4
        //Error when dividing double by int
        int int4 = 4;
        int int5 = 5;
        int divideInts = int5 / int4;


        System.out.println(divideInts);


        //must change their sum to type double if changing larger variable to type double
        int int6 = 4;
        double double4 = 5.5;
        double divideInts2 = double4 / int6;


        System.out.println(divideInts2);


        //Problem 5
        double double5 = 5.5;
        double double6 = 6.5;
        double doublesSum = double6 / double5;


        System.out.println(doublesSum);
        System.out.println((int)doublesSum);


        //Problem 6
        int x = 5;
        int y = 6;
        int q = y / x;


        System.out.println(q);


        //New q with casting y
        double q2 = (double)y / x;
        System.out.println(q2);


        //Problem 7
        final int NAMED_CONSTANCE = 1;
        int sum = NAMED_CONSTANCE + 10;


        System.out.println(sum);


        //Problem 8
        int coffee = 6;
        int cappuccino = 7;
        int tea = 5;


        int subtotal;
        double totalSale;


        int order1 = 3 * coffee;
        int order2 = 4 * cappuccino;
        int order3 = 2 * tea;


        subtotal = order1 + order2 + order3;


        final double SALES_TAX = 0.05;

        totalSale = subtotal + (subtotal * SALES_TAX);

        System.out.printf("$" + "%.2f", totalSale);

    }
}
