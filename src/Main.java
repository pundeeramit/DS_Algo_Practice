import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//    }
//        int[] arr = {8,1,2,8, 5, 2, 5};
//        System.out.println(Hashmap.findFirstNonRepeatingElement(arr));

        int[] arr = {1, 2, 5, -4, -2, -1, 6, -3};
        Hashmap.subArrayWithSumZero(arr);

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(7, 11, 14, 19, 23, 27, -20, -14, -8, -4, 1, 2, 4));
        BinarySearch.howManyTimesRotated(arrayList);

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 4, 2, 2, 1, 3, 3, 5, 5));
        int x = BinarySearch.uniqueElementByBinarySearch(arr2);
        System.out.println("Final Index " + x);

        ArrayList<Integer> arrayList22 = new ArrayList<>(Arrays.asList(3, 2, 5, 4, 6, 3, 7, 5));
        x = BinarySearch.maxSubArraySumLessThanK(arrayList22, 20);

        System.out.printf("Max Size of Sub-Array: %s%n", x);

        x = BinarySearch.subArrayWithMinLength("aababbccbba");
        System.out.printf("Subarray with min length %s",x);

        ArrayList<Integer> arr123 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        x = BinarySearch.findPeak(arr123);

        BinarySearch.findSqrt(2147483647);

        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(-50, -41, -40, -19, 5, 21, 28, 29, 33));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(-50, -21, -10));

        double ans1 = BinarySearch.findMedianSortedArrays(al1, al2);
        System.out.println("Median: "+ans1);

        ArrayList<Integer> bioArray = new ArrayList<>(Arrays.asList(1, 20, 50, 40, 10));
        x = BinarySearch.findInBiotonicArray(bioArray, 1);
        System.out.printf("Bio Index %d%n", x);

        // Painters Partition Problem
        int noOfWorkers = 4;
        int costToUnitWork = 10;
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(658, 786, 531, 47, 169, 297, 914));
        x = BinarySearch.paint(noOfWorkers, costToUnitWork, tasks);

        System.out.printf("Minimum amount of time to complete the tasks %d%n", x);
    }
}