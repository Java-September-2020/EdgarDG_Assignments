public class StringManipulatorController {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld 
    char letter = 'o';
    Integer a = manipulator.getIndexOrNull("Coding", letter);
    Integer b = manipulator.getIndexOrNull("Hello World", letter);
    Integer c = manipulator.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null
    String sWord = "Hello";
    String subString = "llo";
    String notSubString = "world";
    Integer d = manipulator.sGetIndexOrNull(sWord, subString);
    Integer e = manipulator.sGetIndexOrNull(sWord, notSubString);
    System.out.println(d); // 2
    System.out.println(e); // null
    String concatWord = manipulator.concatSubstring("Hello", 1, 2, "world");
    System.out.println(concatWord); // eworld
    }
}