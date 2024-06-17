import java.util.*;

public class Task5 {
    public static void main(String[] args) {

        //Task 5: Write a program where you create an integer array with a length of 5. Loop
        //through the array and assign the value of the loop control variable (e.g., i) to the
        //corresponding index in the array.

        int[] intArray = new int[5];
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = i;
        }

        System.out.print("Array filled with loop control variable: ");
        System.out.println(Arrays.toString(intArray));
    }
}
