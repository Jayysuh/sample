package PA_PolymorphismAndInterface;

public class KidUser implements LibraryUser{
    int age;
    String bookType;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void registerAccount(){
        if (age > 11){
            System.out.println("Sorry, age must be less than 12 to register as a kid.");
        } else if (age <= 11){
            System.out.println("You have successfully registered under a Kids Account.");
        }
    }
    public void requestBook(){
        if (bookType.equals("Kids")){
            System.out.println("Book Issued successfully, please return the book within 10 days");
        } else {
            System.out.println("Oops, you are allowed to take only kids books.");
        }
    }
}
