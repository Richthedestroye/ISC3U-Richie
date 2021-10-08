package week2.week3;

public class unittest {
    
    public static void main(String[] args) {
    System.out.println(threecopies("happy", 1));
    System.out.println(threecopies("computer", 3));    
System.out.println(removeChars("happy", 1, 2));
System.out.println(sqrtsum(9999));
    }
    //write a function that accepts a string and a int that represnts an index 
    //obtain 2 characters from that index and return 3 copies of that string 
    public static String threecopies(String str, int index) {
    String s = str.substring(index, index + 2); //gets two characters starting at index
    return s + s + s; 
    }
    public static String removeChars(String str, int index, int n) {
    String front = str.substring(0, index);
    String last = str.substring(index + n);

    return front + last;
    }
    public static double sqrtsum(int number){
        int n1 = number / 1000; //ex 6384 / 1000 = 6
        int n2 = number / 100 % 10; //ex 6384 / 100 % 10 = 3
        int n3 = number /10 % 10; //ex 6384 / 10 % 10 = 8
        int n4 = number % 10; //ex 6384 % 10 = 4

        int sum = n1 + n2 + n3 + n4;

        return Math.sqrt(sum);
    }
}
