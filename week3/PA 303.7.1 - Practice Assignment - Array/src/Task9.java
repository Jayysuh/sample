import java.util.*;
public class Task9 {
    public static void main(String[] args) {
        //Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1,
        //0}. Print the array in ascending order, and print the smallest and the largest
        //element of the array. The output will look like the following:
        //Array in ascending order: 0, 1, 2, 4, 9, 13
        //The smallest number is 0
        //The biggest number is 13

        int[] intArray = {4, 2, 9, 13, 1, 0};
        System.out.println("Original array: " + Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println("Array in ascending order: " + Arrays.toString(intArray));
        System.out.println("The smallest number is " + intArray[0]);
        System.out.println("The biggest number is " + intArray[intArray.length-1]);
    }
}
