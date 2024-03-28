import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = a + b;
        System.out.println(c);
        Apple apple = new Apple();
        apple.testing("Apple Class");
    }
}
class Apple{

    public void testing(String msg){
        System.out.println("Testing for " + msg);
    }
}


