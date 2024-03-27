package PA_PolymorphismAndInterface;

public class LibraryInterfaceDemo {
    public static void main(String[] args) {
        //Test Case 1
        System.out.println("Kid1 (Age = 10, BookType = Kids):");
        KidUser kid1 = new KidUser();
        kid1.setAge(10);
        kid1.registerAccount();
        kid1.setBookType("Kids");
        kid1.requestBook();
        System.out.println();

        System.out.println("Kid2 (Age = 18, BookType = Fiction):");
        KidUser kid2 = new KidUser();
        kid2.setAge(18);
        kid2.registerAccount();
        kid2.setBookType("Fiction");
        kid2.requestBook();
        System.out.println();

        //Test Case 2
        System.out.println("Adult1 (Age = 5, BookType = Kids):");
        AdultUser adult1 = new AdultUser();
        adult1.setAge(5);
        adult1.setBookType("Kids");

        adult1.registerAccount();
        adult1.requestBook();
        System.out.println();

        System.out.println("Adult2 (Age = 23, BookType = Fiction):");
        AdultUser adult2 = new AdultUser();
        adult2.setAge(23);
        adult2.setBookType("Fiction");

        adult2.registerAccount();
        adult2.requestBook();
    }
}
