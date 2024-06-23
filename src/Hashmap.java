import java.util.*;

public class Hashmap {

    // Hashmap doesn't preserve order
    // Find the first non-repeating element of the array (Amazon, Adobe, GS)
    // Input: [8, 2, 8, 3, 1, 2, 6, 5, 3], Output: 3
    // Input: [1, 2, 3, 1, 2, 5], Output: 3

    public static int findFirstNonRepeatingElement(int[] arr)
    {
        if (arr.length == 0)
            return -1;

        System.out.println(Arrays.toString(arr));

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i: arr)
        {
            if (freqMap.containsKey(i))
            {
                freqMap.put(i, freqMap.get(i) + 1);
            }
            else {
//                freqMap.put(i, freqMap.getOrDefault(i, 1));
                freqMap.put(i, 1);
            }

        }

        for (int elem: arr)
        {
            if (freqMap.get(elem) == 1){
                return elem;
            }
        }
//        System.out.println(freqMap);
        return -1;
    }

    // Given an array we have to check if there exists a sub-array with sum = 0
    public static boolean subArrayWithSumZero(int[] arr) {
        if (arr.length == 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int subArraySum = 0;
                for (int k = i; k <= j; k++) {
                    subArraySum += arr[k];
                    if (subArraySum == 0) {
                        System.out.println("\nGot the value");
                        System.out.println(i + " " + j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
