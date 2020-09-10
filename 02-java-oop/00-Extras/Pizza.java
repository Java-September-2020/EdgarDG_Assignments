import java.util.Arrays;

public class Pizza {
    private String sauce;
    private String[] toppings;
    private char size;
    private double price;
    private int slices;
    
    //Constructor
    public Pizza(String sauce, String[] toppings, char size, double price) {
        this.sauce = sauce;
        this.toppings = toppings;
        this.size = size;
        this.price = price;
        this.slices = 8;

    }

    //Things we can do with the pizza
    public void displayPizza() {
        //display pizza
        System.out.printf("This is a pizza with %s with %s toppings, that costs $%.2f dollars\n", this.sauce, Arrays.toString(this.toppings), this.price);
    }

    //eat a slice
    public void eatASlice(int slices) {

    }

    //getters and setters
    public int getSlices() {
        return this.slices;
    }
    public String getSauce() {
        return this.sauce;
    }
    public String getToppings() {
        return Arrays.toString(this.toppings);
    }
    public char getSize() {
        return this.size;
    }
    public double getPrice(){
        return this.price;
    }
    public void setSlice(int slices) {
        System.out.printf("You have eaten %d slices", slices);
        this.slices -= slices;
        System.out.println("The pizza now has " + slices + " slices.");
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setSauce(String sauce) {
        if (sauce.equals("")) {
            System.out.println("Sauce field cannot be empty");
        } else {
        this.sauce = sauce;
        }
    }
    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }
    public void setSize(char size) {
        this.size = size;
    }
}