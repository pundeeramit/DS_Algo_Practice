import java.util.*;
public class TwoPointer {
    public static int countPairsOfSum(ArrayList<Integer> A, int B)
    {
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
                i ++; j--;
                count ++;
            }
        }//end-of-while

        return count;
    }//end-of-method
}
