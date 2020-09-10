import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzle{
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        System.out.println(alphabet);
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(alphabet.get(25));
        ArrayList<String> newArr = new ArrayList<String>();
        newArr.add("aaa");
        newArr.add("bbb");
        newArr.add("ccc");
        newArr.add("ddd");
        System.out.println(newArr);
        Collections.shuffle(newArr);
        System.out.println(newArr);


        int randomNumber = r.nextInt(25);
        System.out.println(alphabet.get(randomNumber));

    }
}