package week6;

public class whileloops {
    public static void main(String[] args) {
        exampleone();
        exampletwo();
    }

    private static void exampletwo() {
        int num1 = 1;

        while(num1 <= 100){
            System.out.println(num1);
            num1*num1;
        }
    }

    private static void exampleone() {
        // purpose of a loop to repeat code 
        int num = 1;

        while(num < 10){
            System.out.println(num);
            num++;
        }


    }
}
