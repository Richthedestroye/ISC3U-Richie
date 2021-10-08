package week2.week3;

public class extraquestions {
    public static void main(String[] args) {
       question1(); 
       question2();
       question3();
      //System.out.println(question4(finalnum,20, 10); 
       String str = question5(" this is a sentance");
       System.out.println(str);
       System.out.println(question6("fred he is fat", "fat"));
        System.out.println(question7("fat", "fred"));
      //System.out.println(question8(2, 4, 4, 8));
    //System.out.println(question9(5, 6));
  
       double slope = question8(1,2,4,5); // (1,2) and (4,5)
System.out.println(question10("this is a sentance"));

    }
    private static String question10(String string) {
     int index = (int)(Math.random() * string.length() + 0);
     String first = string.substring(0, index);
     String last = string.substring(index + 1);
     return first + last;
    }
    // obtains and displays a integer between 1 and 100
    public static void question1(){
        int num = (int)(Math.random()* 100) + 1;
        //(int)(math.random()* number of possibilites) + start 
        System.out.println(num);
    }
    public static void question2(){
        int num = (int)(Math.random()* 101) + -50;
        //(int)(math.random()* number of possibilites) + start 
        System.out.println(num);
    }
    public static void question3(){
        int num = (int)(Math.random()* 6) + 1;
        System.out.println("you rolled a " + num);
    }
   /* public static void question4(int big, int small){
    int num = (int)(Math.random()* big) + small;
          return num;
    
    }
    */
   public static String question5(String string){
   int index = string.indexOf("e");
   String first = string.substring(0, index);
   String last = string.substring(index + 1);
   return first + last;
   }

    public static String question6(String str, String string){
int index = str.indexOf(string);
        String front = str.substring(0, index);
        String back = str.substring(index + str.length());
        return front + back;
    }
     public static int question7(String str, String str1){
int answer = str.length() + str1.length();
return answer;
    }
    
    public static double question8(int x1, int x2, int y1, int y2){
    //slope = (deltay / deltax)
        int deltay = y2 - y1;
        int deltax = x2 - x1;
        return (double)deltay / deltax;
        
    
    }
    
   public static void question9(int r, int h){
    double volume_of_a_cylinder = Math.PI * (r * r) * h;

}

}
