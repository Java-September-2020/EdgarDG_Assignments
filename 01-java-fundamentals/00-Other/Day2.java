import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2{
    public static void main (String[] args) {
//        String name = "jeremy";
//        String name2 = "jeremy";
//
//        System.out.println(name == name2);
//
//        String name3 = new String("jeremy");
//        String name4 = new String("jeremy");
//        System.out.println(name3 == name4);
//        System.out.println(name3.equals(name4));
        //Array
        String[] people = {"Matthew", "Jeremy", "Edgar"};
//        people[3] = "Justin" returns erorr (out of bounds)
        String[] newPeople = new String[10];
//        String[0] = "String"
//        continue for each --- not recommended.
        int[] numbers = new int[10];
        for(int i =0; i < newPeople.length; i++){
            numbers[i] = i + 1;
        }
        //Arrays with different data types
        Object[] myObjectArr = {"matthew", 13, "c"};


        //Way to print out array.
        System.out.println(Arrays.toString(numbers));

        //Arrays in JS:
        //var arr = [1,2,3,4,5]
        //arr.push(6);
        //arr [1,2,3,4,5,6]

        //Collection Superclass

        //Array Lists
        ArrayList<String> numberSpelledOut = new ArrayList<String>();
        numberSpelledOut.add("one");
        numberSpelledOut.add("two");
        numberSpelledOut.add("three");
        numberSpelledOut.add("four");
        System.out.println(numberSpelledOut);
        System.out.println(people[2]); //gets Edgar
        System.out.println(numberSpelledOut.get(2)); //gets "three"

        //Iterate through array list
        for(int i = 0; i < numberSpelledOut.size(); i++){
            System.out.println(numberSpelledOut.get(i));
        }

        //Enhanced FOR loop -- For each loop
        for(String num : numberSpelledOut){
            System.out.println(num);
        }

        //Hash Map
//        {Key: value}
HashMap<String, String> ourHobbies = new HashMap<String, String>();
ourHobbies.put("Edgar", "Video Games");
ourHobbies.put("Justin", "Making Wine");
ourHobbies.put("Jeremy", "Cryptocurrency");
ourHobbies.put("Frank", "Sleep");
ourHobbies.put("Ozair", "Travelling");
ourHobbies.put("Taylor", "Running");
ourHobbies.put("Matt", "Photography");
ourHobbies.put("Zach", "WebFun");
//Prints like an object but it has key=value pairs instead of methods
System.out.println(ourHobbies);
//notice that pairs will be in a random order

//gets value == "Video Games"
System.out.println(ourHobbies.get("Edgar"));

for(String name : ourHobbies.keySet()){
    System.out.println(name);
}
for(String name : ourHobbies.values()){
    System.out.println(name);
}

for (HashMap.Entry<String, String> nameHobbies : ourHobbies.entrySet()) {
    System.out.println("Key: " + nameHobbies.getKey() + ", Value: " + nameHobbies.getValue());
}

//Methods
//Get Max Value
int[] someNum = {1, 13, 33, 19, 102, 40, 9};

System.out.println(getMaxValue(someNum));



    }

    public static int getMaxValue(int[] numbers){
        //Create a Max Value Variable to hold the first of the array
        //Create a for loop, loop the array
        //campare if the iterator value is greater than max value, replace max value with new value
        //return max value
        int greatestValue = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] > greatestValue) {
                try{
                greatestValue = numbers[i];
                } catch (ArrayIndexOutOfBoundsException e){
//                    System.out.printlm("e");
                }
            }

        }
        return greatestValue;
    } 
}

