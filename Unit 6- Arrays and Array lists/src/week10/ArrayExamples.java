package week10;

public class ArrayExamples {
    public static void main(String[] args) {
        primitivearray();
        arrayobjectexample();
    }

    private static void arrayobjectexample() {
        Animal[] animals = new Animal[3];
        animals[0] = new Animal();
    }

    private static void primitivearray() {
        int [] arr = new int[5];
        arr[0] = 12;
        arr[1] = 12;
        arr[2] = 12;
        arr[3] = 12;
        arr[4] = 12;
        System.out.println(arr[2]);
        }
}
