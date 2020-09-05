import java.util.Arrays;
import java.util.ArrayList;

public class BasicJava {
    public static void main(String[] args) {
        print255();
        printOdd255();
        printSum255();
        int[] x = {1,3,5,7,9,13};
        iterArray(x);
        int[] x2 = {-3,-5,-7};
        int[] x3 = {1,0,54,-5,-100};
        findMax(x);
        findMax(x2);
        findMax(x3);
        int[] x4 = {2,10,3};
        getAvg(x4);
        oddArray();
        int[] x5 = {1,3,5,7};
        greaterThanY(x5, 3);
        int[] x6 = {1,5,10,-2};
        squareValues(x6);
        noNegativeNancy(x6);
        System.out.println(Arrays.toString(x6));
        int[] x7 = {1,5,10,-2};
        int[] mMA = maxMinAvg(x7);
        System.out.println(Arrays.toString(mMA));
        int[] x8 = {1,5,10,7,-2};
        shiftLeft(x8);
        System.out.println(Arrays.toString(x8));

    }
    public static void print255() {
        for (int i = 0; i <= 255; i++) {
            System.out.println(i);
        }
    }
    public static void printOdd255() {
        for (int i = 1; i < 256; i += 2) {
            System.out.println(i);
        }
    }
    public static void printSum255() {
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum = sum + i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    public static void iterArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void findMax(int[] arr) {
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
            }
        }
        System.out.println(maxNum);
    }
    public static void getAvg(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        int avg = sum / arr.length;
        System.out.println(avg);
    }
    public static void oddArray() {
        int[] y = new int[128];
        int odd = 1;
        for (int i = 0; i <= 127; i++) {
            y[i] = odd;
            odd += 2;
        }
        System.out.println(Arrays.toString(y));
    }
    public static void greaterThanY(int[] arr, int y) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) {
                count = count + 1;
            }
        }
        System.out.println(count);
    }
    public static void squareValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void noNegativeNancy(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
    }
    public static int[] maxMinAvg(int[] arr) {
        int max = 0;
        int min = 0;
        int sum = 0;
        int[] newArr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            sum = sum + arr[i];
            System.out.println(sum);
        }
        int avg = sum / arr.length;
        newArr[0] = max;
        newArr[1] = min;
        newArr[2] = avg;
        return newArr;
    }
    public static void shiftLeft(int[] arr) {
        //go through each value in the array. 
        //start at the 1 slot and set the value equal to one less than its present slot.
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = 0;
    }
}