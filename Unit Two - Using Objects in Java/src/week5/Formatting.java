package week5;

public class Formatting {
   public static void main(String[] args) {
    //5:3.272 => 5 : 3.272
    //5:03.272
    int minutes = 5;
    double seconds = 3.272676786;
    
    //what i want is this: 5:03.272

    //place holders
    // %d -> use for ints 
    // %f -> floating point numbers (double)
    //System.out.printf("blah%dtest %f", minutes, seconds);
    //%06.3f -> 6 width 0 the padding to make if it isnt long enough put 0 3 = decimal places
    System.out.printf("%d:%06.3f", minutes, seconds);
    String temp = String.format("%d:%06.3f", minutes, seconds);
   } 
}
