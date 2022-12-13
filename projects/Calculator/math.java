package Calculator;

public class math {
    public static double operate(double a,double b,char c){
        return switch (c) {
            case '+' -> a+b;
            case '-' -> a-b;
            case '*' -> a*b;
            case '/' -> a/b;
            default -> 0;
        };
    }
}
