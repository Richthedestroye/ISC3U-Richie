package week8;

public class Die {
    // attributes - defines the state of the object
    // the attributes should be private 
    //private means -> visible(accessable) in this class
    private int numSides; 
    private int topSide; 
    /*
    constructor
    has the same name as the class
    you should create at least 1
    they are used to obtain (contruct an instance of this class)
    in this case it will give a die
    purpose is to initialise the state (attrivutes)
    */
public Die(){
    // constructor initialises the attributtes 
    numSides = 6;
    topSide = (int) (Math.random() * numSides) + 1;
}
public Die(int numSides){
    numSides = numSides;
    topSide = (int) (Math.random() * numSides) + 1;
    roll(); 
}
public void roll(){
    topSide = (int) (Math.random() * numSides) + 1;
}
}
