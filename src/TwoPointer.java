import java.util.*;
public class TwoPointer {
    public static int countPairsOfSum(ArrayList<Integer> A, int B)
    {
        System.out.println(A);
        int i = 0, j = A.size() - 1;

        int count = 0;
        while (i < j)
        {
            int sum = A.get(i) + A.get(j);

            if (sum > B)
                j --;
            else if(sum < B)
                i ++;
            else {
                System.out.printf("Pair Element at Index %d %d %n",i, j);
                i ++; j--;
                count ++;
            }
        } //end-of-while
        return count;
    } //end-of-method

    public static int pairDifference(ArrayList<Integer> A, int B)
    {
        // TODO: TBC
        return -1;
    }

    public static int threeSumClosestBruteForce(ArrayList<Integer> arr, int B)
    {
        int potentialAnswer = Integer.MAX_VALUE;
        int diff;
        int globalDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - 2; i++)
        {
            for (int j = 0; j < arr.size() - 1; j++)
            {
                for (int k = 0; k < arr.size(); k++)
                {
                    int sum = arr.get(i) + arr.get(j) + arr.get(k);
                    diff = Math.abs(B - sum);

                    if (B == sum)
                        return sum;
                    if (globalDiff > diff)
                    {
                        globalDiff = diff;
                        potentialAnswer = sum;
                    }
                }
            }
        } // outermost-for-loop
        return potentialAnswer;
    }

    public static int threeSumClosestBinarySearch(ArrayList<Integer> arr, int B)
    {
        Collections.sort(arr);
        int diff, globalDiff = Integer.MAX_VALUE;
        int potentialAnswer = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - 2; i ++)
        {
            for (int j = i + 1; j < (arr.size() - 1); j++)
            {
                int low = j + 1, high = arr.size() - 1;
                while (low <= high)
                {
                    int mid = low + (high - low)/2;

                    int sum = arr.get(i) + arr.get(j) + arr.get(mid);
                    diff = Math.abs(B - sum);

                    if (B == sum)
                        return sum;
                    if (globalDiff > diff)
                    {
                        globalDiff = diff;
                        potentialAnswer = sum;
                    }
                    if (sum > B)
                    {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        } // outermost-loop

        return potentialAnswer;
    }

    public static int threeSumUsingTwoPointer(ArrayList<Integer> arr, int B)
    {
        Collections.sort(arr);
        int diff, globalDiff = Integer.MAX_VALUE;
        int potentialAnswer = Integer.MAX_VALUE;

        for(int i = 0; i < arr.size(); i ++)
        {
            int B2 = B - arr.get(i);
            int j = i + 1, k = arr.size() - 1;
            while (j < k)
            {
                int sum = arr.get(j) + arr.get(k) + arr.get(i);
                if(B == sum)
                {
                    return sum;
                }
                diff = Math.abs(B - sum);
                if (globalDiff > diff)
                {
                    globalDiff = diff;
                    potentialAnswer = sum;
                }

                if (sum < B)
                {
                    j ++;
                } else {
                    k --;
                }
            } // end-of-while-loop
        } // end-of-for-loop

        return potentialAnswer;
    }

}
