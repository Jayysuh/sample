import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        //Task 7: Write a program where you create an array of 5 elements. Loop through the
        //array and print the value of each element, except for the middle (index 2) element.


        int[] intArray = {0, 1, 2, 3, 4};
        System.out.println("Original array: " + Arrays.toString(intArray));
        System.out.println("Value of each array element except for middle index: ");
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = i;
            if (i == intArray.length/2){
                continue;
            } else{
                System.out.print(intArray[i] + " ");
            }
        }



    }
}
