package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //exampleone(in);
        exampletwo(in);
        in.close();
    }
    private static void exampletwo(Scanner in) {
System.out.print("Please enter a number: ");
//double num = in.nextDouble();
//use nextline always and parse in the required type 
double num = Double.valueOf(in.nextLine());

double result = Math.pow(num, 2);



System.out.println(result);
}
    private static void exampleone(Scanner input){
System.out.print("please enter your name: ");
        String name = input.nextLine();

System.out.println("hello " + name);
    }
}
