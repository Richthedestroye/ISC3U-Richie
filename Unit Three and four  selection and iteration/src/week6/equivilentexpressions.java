package week6;

public class equivilentexpressions {
    public static void main(String[] args) {
        // boolean expressions evaluate to true / false
        int x = 7;
        System.out.println(x > 3); //(x > 7) => true
        

        //equivilant expressions are a different way to write the expression but evalute to the same values

        // !(x >=3) && ( x <= 7) ( diagram in onenote - not the blue part)
        // (x < 3) || ( x > 7) ( diagram in onenote - red part)
    
        // DeMorgan's law 
        // !(A || B)   = !A && !B                   A and B refer to simple expressions like x > 8 
        // !(A &&n B)   = !A || !B                   A and B refer to simple expressions like x > 8 

    }
}
