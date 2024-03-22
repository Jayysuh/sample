import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        //Task 8: Write a program that creates a String array of 5 elements and swaps the first
        //element with the middle element without creating a new array.

        String[] name = {"Jon", "Sam", "Kim", "Greg", "Amy"};
        System.out.println("Original array: " + Arrays.toString(name));

        String temp = name[0];
        name[0] = name[name.length/2];
        name[name.length/2] = temp;

        System.out.println("New array with first and middle element swapped: ");
        System.out.println(Arrays.toString(name));
    }
}
