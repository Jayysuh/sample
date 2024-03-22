import java.util.*;
public class Task11 {
    public static void main(String[] args) {
        //Task 11: Write some Java code that asks the user how many favorite things they
        //have. Based on their answer, you should create a String array of the correct size.
        //Then ask the user to enter the things and store them in the array you created. Finally,
        //print out the contents of the array.

        System.out.println("How many favorite things do you have?");

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        System.out.println("You have " + num + " favorite things.");

        String[] things = new String[num];

        for (int i = 0; i < num; i++){
            System.out.println("Enter one of your favorite thing: ");
            things[i] = scan.nextLine();
        }

        System.out.println("Your favorite things are:");

        for(String thing : things){
            System.out.print(thing + " ");
        }
    }
}
