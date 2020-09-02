public class Pythagorean {
    public static void main(String[] args) {
        System.out.println(calculateHypotenuse(6,8));
    }
    static double calculateHypotenuse(int legA, int legB) {
        return Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
    }
}