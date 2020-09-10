public class Greeter {
    private String createGreeting(String toBeGreeted) {
        return "Greetings " + toBeGreeted;
    }
    public String greet(String name) {
        return createGreeting("World");
    }
    public String greet(String firstName, String lastName) {
        return createGreeting(firstName + " " + lastName);
    }
}