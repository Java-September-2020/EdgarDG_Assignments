public class FizzBuzz {
    public String fizzBuzz (int val) {
        if (val % 3 == 0 && val % 5 == 0) {
            return "FizzBuzz";
        } else if (val % 3 == 0) {
            return "Fizz";
        } else if (val % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(val);
        }
    }

public void fizzBuzzCounter(){
    for (int i = 1; i <= 100; i++){
        String result = fizzBuzz(i);
        System.out.println("Number: " + i + " is " + result);
    }
}
//    public static void main(String[] args) {
//        FizzBuzz myObj = new FizzBuzz();
//        myObj.fizzBuzz(3);
//        myObj.fizzBuzz(5);
//        myObj.fizzBuzz(15);
//        myObj.fizzBuzz(2);
//    }
}