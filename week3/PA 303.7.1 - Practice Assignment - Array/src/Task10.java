import java.util.*;

public class Task10 {
    public static void main(String[] args) {
        //Task 10: Create an array that includes an integer, 3 strings, and 1 double. Print the
        //array

        Object[] mixedArray = new Object[5];
        Integer int1 = new Integer(5);
        Double double1 = new Double(6.5);
        String name1 = "Jim";
        String name2 = "Kim";
        String name3 = "Paul";

        mixedArray[0] = int1;
        mixedArray[1] = double1;
        mixedArray[2] = name1;
        mixedArray[3] = name2;
        mixedArray[4] = name3;

        System.out.println("Array with an integer, 3 strings, and 1 double:");
        System.out.println(Arrays.toString(mixedArray));

    }
}
