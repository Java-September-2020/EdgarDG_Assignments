public class FizzBuzz {
    public String fizzBuzz (int number) {
        if ((number % 3 == 0) && (number % 5 == 0)) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
        return "I don't know what I'm doing.";
    }
    public static void main(String[] args) {
        FizzBuzz myObj = new FizzBuzz();
        myObj.fizzBuzz(3);
        myObj.fizzBuzz(5);
        myObj.fizzBuzz(15);
        myObj.fizzBuzz(2);
    }
}