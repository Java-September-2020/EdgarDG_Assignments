public class GreeterTest {
    public static void main(String[] args) {
        HelloWorld hW = new HelloWorld();
        String greeting - hW.greet();
        String greetingWithName = hW.greet("Edgar");
        if (greeting.equals("Hello World") || greetingWithName.equals("Hello Edgar")) {
            System.out.println("Test successful");
        } else {
            System.out.println("Test Fail");
        }
    }
}