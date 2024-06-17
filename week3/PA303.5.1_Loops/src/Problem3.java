public class Problem3 {
    public static void main(String[] args) {

        int tuition = 10000;
        int goal = 20000;
        int years = 0;

        while (tuition < goal){
            tuition *= 1.07;
            years++;
        }

        System.out.println("In " + years + " years, tuition will be: " + tuition);
    }
}
