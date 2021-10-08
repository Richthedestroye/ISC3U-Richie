package week2.week4;

public class ifstatementexamples {
    public static void main(String[] args) {
        exampleOne();
       String lettergrade = getlettergrade(87);
    }

    private static String getlettergrade(int mark) {
        if(mark >= 90){
            return "A+";
        }else if (mark >= 80){
            return "A";
        } else if (mark >= 70){
            return "B";
        } else if (mark >= 60){
        return "C";
    } else if (mark >= 50){
        return "D";
    } else {
        return "F";
    }

    private static void exampleOne() {
        int x = 7;

        //check if x is even
        if(x % 2 == 0){ // execute what is in the {} brackets if it is true 
            System.out.println(x + " is even.");
        }else{ // the last thing was not true
System.out.println(x + "is odd.");
        }
    }
}
