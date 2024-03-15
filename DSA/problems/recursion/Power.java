package recursion;

//find the a^b given a and b using recursion
public class Power {
    // VIDEO NO #9

    public static int pow(int a, int b) {
        if (b == 0)
            return 1;

        return a * pow(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println(pow(2,10));
    }
}
