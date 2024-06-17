public class PAOperatorsAndNumbers {
    public static void main(String[] args) {
        //Problem 1
        int x = 2;
        System.out.println(Integer.toBinaryString(x));

        x = x << 1;
        //I predict x<<1 = 100 for binary, and 4.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x));

        //1a)9
        x = 9;
        System.out.println(Integer.toBinaryString(x));

        x = x << 1;
        //I predict x<<1 = 10010 for binary, and 18.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x));

        //1b)17
        x = 17;
        System.out.println(Integer.toBinaryString(x));

        x = x << 1;
        //I predict x<<1 = 100010 for binary, and 34.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x));

        //1c)88
        x = 88;
        System.out.println(Integer.toBinaryString(x));

        x = x << 1;
        //I predict x<<1 = 10110000 for binary, and 176.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x)+"\n");



        //Problem 2
        x = 150;
        System.out.println(Integer.toBinaryString(x));

        x = x >> 2;
        //I predict x<<1 = 100101 for binary, and 37.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x));

        //2a) 225
        x = 225;
        System.out.println(Integer.toBinaryString(x));

        x = x >> 2;
        //I predict x<<1 = 111000 for binary, and 56.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x));

        //2b) 1555
        x = 1555;
        System.out.println(Integer.toBinaryString(x));

        x = x >> 2;
        //I predict x<<1 = 110000100 for binary, and 388.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x));

        //2c) 32456
        x = 32456;
        System.out.println(Integer.toBinaryString(x));

        x = x >> 2;
        //I predict x>>2 = 1111110110010 for binary, and 8114.0 for decimal value
        System.out.println((double)x);
        System.out.println(Integer.toBinaryString(x) + "\n");

        //Problem 3
        x = 7;
        int y = 17;
        //I predict bitwise and operation of x and y is = 1

        int z = x & y;
        System.out.println(z);

        //Problem 4
        x = 7;
        y = 17;
        //I predict bitwise and operation of x and y is = 23

        z = x | y;
        System.out.println(z + "\n");

        //Problem 5
        int post = 5;
        System.out.println(post);

        post++;
        System.out.println(post + "\n");

        //Problem 6
        int increment = 5;
        System.out.println(increment);

        increment++;
        System.out.println(increment);

        ++increment;
        System.out.println(increment + "\n");

        //Problem 7
        x = 5;
        y = 8;
        int sum = ++x + y;
        System.out.println(sum);

        //rerun with postfix
        x = 5;
        y = 8;
        sum = x++ + y;
        System.out.println(sum);






    }
}
