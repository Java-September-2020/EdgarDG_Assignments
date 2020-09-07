import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class PuzzleJava { 
    public static void main (String[] args) {
        int[] x = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(Arrays.toString(sumShowBig(x)));
        String[] x2 = {"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"};
        System.out.println(Arrays.toString(shuffleShowName(x2)));
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }
        shuffleAndShow(alphabet);
        randomNumSequence();
        rdmArr();
        randomString();
        tenRandoString();
        


    } 


    public static Object[] sumShowBig(int[] arr) { 
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int i =0; i < arr.length; i++){
        sum = arr[i] + sum;
        if(arr[i] > 10)
        newArr.add(arr[i]);
    }
        System.out.println(sum);
        return newArr.toArray();
    }
    public static Object[] shuffleShowName(String[] arr) {
        ArrayList<String> newArr = new ArrayList<String>();
        List<String> strLst = new ArrayList<String>();
        Collections.addAll(strLst, arr);
        Collections.shuffle(strLst);
        for (int i = 0; i < strLst.size(); i++) {
            System.out.println(strLst.get(i));
            if (strLst.get(i).length() > 5) {
                newArr.add(strLst.get(i));
            }
        }
        return newArr.toArray();
    }
    public static void shuffleAndShow(ArrayList<Character> arr) {
        Collections.shuffle(arr);
        System.out.println(arr.get(arr.size() - 1));
        System.out.println(arr.get(0));
        if ((arr.get(0) == 'a') || (arr.get(0) == 'e') || (arr.get(0) == 'i') || (arr.get(0) == 'o') || (arr.get(0) == 'u')) {
            System.out.println("It's a vowel!!");
        }
    }
    public static void randomNumSequence() {
        Random num = new Random();
        for (int i = 0; i < 10; i++) {
            int ranNum = num.nextInt(100 - 55) + 55;
            System.out.println(ranNum);
        }
    }
    public static void rdmArr() {
        //create array of 10 random numbers.
        //Sort array from low to high
        //Print organized numbers 
        //Print Lowest value (First in array)
        //Print Highest value (Last in array)
        Random num = new Random();
        ArrayList<Integer> randomArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int ranNum = num.nextInt(100 - 55) + 55;
            randomArray.add(ranNum);
        }
        Collections.sort(randomArray);
        System.out.println(randomArray);
        for (Integer nums : randomArray) {
            System.out.println(nums);
        }
        System.out.println(randomArray.get(0));
        System.out.println(randomArray.get(9));
    }
    public static void randomString() {
        Random random = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        ArrayList<Character> randFiveStr = new ArrayList<Character>();
        StringBuilder str = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }
        for (int i = 0; i < 5; i++) {
            randFiveStr.add(alphabet.get(random.nextInt(25)));
        }
        char[] charArray = new char[randFiveStr.size()];
        for (int i = 0; i < randFiveStr.size(); i++) {
            charArray[i] = randFiveStr.get(i);
        }
        str.append(charArray);
        System.out.println(charArray);
    }
    public static void tenRandoString() {
        ArrayList<String> tenStrings = new ArrayList<String>();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        Random r = new Random();
    for (int a = 0; a < 10; a++) {
            for (char i = 'a'; i <= 'z'; i++) {
                alphabet.add(i);
            }
            String z = "";
            for (int i = 0; i < 5; i++) {
            char c = alphabet.get(r.nextInt(25));  
            String s = String.valueOf(c);
            z = z + s;
            }
            tenStrings.add(z);
        }
        System.out.println(tenStrings);
    }
}