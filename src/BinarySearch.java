import java.util.*;

class BinarySearch {
    // How many times the array is rotated
    public static int howManyTimesRotated(ArrayList<Integer> arr)
    {
        if (arr.isEmpty()) // Array is empty
            return -1;
        int lastIndex = arr.size() - 1;
        int high = arr.size() - 1;
        if(arr.get(0) < arr.get(high))
        {
            return -1;// Array is already sorted
        }

        int low = 0;

        while (low <= high)
        {
            int mid = low + (high-low)/2;
            int midValue = arr.get(mid);

            if(midValue < arr.get(lastIndex)) // On the right hand side
            {
                high = mid - 1;
            }
            else { // We're on the left hand side
                low = mid + 1;
            }
        }
        System.out.println(Arrays.toString(arr.toArray()));
        System.out.println(high);
        return 0;
    }

    public static int uniqueElementByBinarySearch(ArrayList<Integer> arr)
    {
        if (arr.size()%2 == 0)
            return -1;

        if(arr.size() == 1)
            return arr.getFirst();

        int low = 0, high = arr.size() - 1;

        System.out.println("Starting");
        while (low <= high)
        {
// This wouldn't work without Length
//            int mid = low + (high - low)/2;
//            boolean leftEqual = false, rightEqual = false;
//
//            // check if it's unique
//            if ( ( mid > 0 && arr.get(mid) == arr.get(mid-1) ) )
//            {
//                leftEqual = true;
//            } else if ( (mid < arr.size() - 1 && arr.get(mid) == arr.get(mid+1)) )
//            {
//                rightEqual = true;
//            }
//            else {
//                return arr.get(mid);
//            }
//
//            if (leftEqual) {
//                if ((mid & 1) == 1) {
//                    System.out.println("This is even " + mid);
//                    low = mid + 1;
//                } else {
//                    System.out.println("This is odd " + mid);
//                    high = low - 1;
//                }
//            }
            int mid = low + (high - low) / 2;

            boolean leftCond = (mid > 0 && arr.get(mid) != arr.get( mid - 1 ));
            boolean rightCond = (mid < arr.size() - 1 && arr.get(mid) != arr.get(mid + 1));

            if ( leftCond  && rightCond ) {
                System.out.printf("Final index %s and value %s%n", mid, arr.get(mid));
                return arr.get(mid);
            }

            int firstOccurance = mid;

            if ( leftCond )
            {
                firstOccurance = mid;
            } else {
                firstOccurance = mid - 1;
            }

            if ((firstOccurance & 1) == 0) {
                low = mid + 1;
            } else {
              high = firstOccurance - 1;
            }
       }
        return -1;
    }

    public static int maxSubArraySumOfLengthN(ArrayList<Integer> arr, int N)
    {
        int curSum = 0, maxSum = 0;
        int low = 0;
        for (low = 0; low < N; low++)
        {
            maxSum += arr.get(low);
        }
        curSum = maxSum;

        while (low < arr.size())
        {
            curSum = curSum + (arr.get(low) - arr.get(low-N));

            if (curSum > maxSum)
                maxSum = curSum;
            low ++;
        } // end-of-while
        return maxSum;
    } // end-of-method

    public static int maxSubArraySumLessThanK(ArrayList<Integer> arr, int K)
    {
        if(arr.isEmpty())
        {
            return -1;
        }

        int low = 1, high = arr.size();
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            int curSum = maxSubArraySumOfLengthN(arr, mid);
            if (curSum <= K)
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.printf("subarray size %s%n",high);
        return high;
    }

    public static boolean isSubArrayComplete(HashMap<Character, Integer> map)
    {
        ArrayList<Character> set = new ArrayList<>(Arrays.asList('a','b','c'));
        for (Character character : set) {
            if (map.getOrDefault(character, 0) == 0)
                return false;
        }
        return true;
    }

    // Return 'True' if a, b, c exists
    public static boolean isMyDictionaryComplete(String str, int size)
    {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        int i = 0;
        for (i = 0; i < size; i++)
        {
            Character currentChar = str.charAt(i);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0)+1);
        } // end-of-for-loop

        if(isSubArrayComplete(freqMap))
        {
            return true;
        }

        while (i < str.length())
        {
            Character leftChar = str.charAt(i-size);
            Character rightChar = str.charAt(i);

            freqMap.put(leftChar, freqMap.get(leftChar) - 1);
            if ( freqMap.containsKey(rightChar) )
            {
                freqMap.put(rightChar, freqMap.get(rightChar) + 1);
            } else {
                freqMap.put(rightChar, 1);
            }

            if (isSubArrayComplete(freqMap))
            {
                return true;
            }

            i++;
        } // end-of-while

        return false;
    }

    public static int subArrayWithMinLength(String str)
    {
        if(str.isEmpty())
            return 0;

        int low = 1, high = str.length();

        while ( low <= high )
        {
            int mid = low + (high - low)/2;

            if(isMyDictionaryComplete(str, mid))
            {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        } // end-of-while

        System.out.printf("The answer is subarray of size min %s%n",low);
        return low;
    }

    public static int findPeak(ArrayList<Integer> arr)
    {
        if(arr.size() == 1)
            return arr.getFirst();

        int low = 0, high = arr.size() - 1;


        while (low <= high)
        {
            int mid = low + (high - low)/2;

            boolean leftCond = (mid > 0) ? (arr.get(mid-1) < arr.get(mid)) : true;
            boolean rightCond = (mid < arr.size() -1) ? (arr.get(mid) < arr.get(mid + 1)) : true;

            if (leftCond && rightCond){
                System.out.printf("Final value of ans %s%n", mid);
                return mid;
            }

            if (mid < arr.size() - 1 && arr.get(mid) < arr.get(mid + 1))
            {
                low = mid + 1;
            } else if (0 < mid && arr.get(mid) > arr.get(mid+1)){
                high = mid - 1;
            }
        }

        return 0;
    }

    public static int findSqrt(int A)
    {
        if(A==0) return 0;

        int low = 1, high = A;

        while (low <= high)
        {
            int mid = (int)Math.floor(low + ( high - low)/2);
//1152921504606846976, 288230376151711744
            long currSqrt = (long) mid * mid;
            if(currSqrt == A)
            {
                System.out.printf("mid value is %s%n", currSqrt);
                return mid;
            }

            if (currSqrt < A)
            {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        } // end-of-while
        return high;
    } // end-of-method

    public static double findMedian(final ArrayList<Integer> a)
    {
        if (a.size() % 2 == 0)
        {
            // System.out.println("*****************************");
            return (double) (a.get(a.size()) + a.get(a.size() - 1)) / 2;
        } else
        {
            return (double) a.get(a.size() - 1) / 2;
        }
    }//end-of-method

    public static double findMedianSortedArrays(final ArrayList<Integer> a, final ArrayList<Integer> b)
    {

        if (a.isEmpty())
        {
            return findMedian(b);
        }

        if (b.isEmpty())
        {
            return findMedian(a);
        }

        if (a.size() > b.size())
            return findMedianSortedArrays(b, a);

        int low = 0, high = a.size() - 1;
        int lenA = a.size() - 1, lenB = b.size() - 1;

        while (low <= high)
        {
            int partitionX = low + (high - low)/ 2;
            int partitionY = (lenA + lenB)/2 - partitionX;

            int maxLeftX = a.get(partitionX);
            int minRightX = (partitionX == a.size() - 1) ? Integer.MAX_VALUE : a.get(partitionX + 1);

            int maxLeftY = b.get(partitionY);
            int minRightY = (partitionY == b.size() - 1) ? Integer.MAX_VALUE : b.get(partitionY + 1);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                if((lenA + lenB) % 2 == 0)
                {
                    return Math.min(minRightX, minRightY) + Math.max(maxLeftX, maxLeftY) / 2.0;
                } else {
                    return (double)Math.max(maxLeftY, maxLeftX);
                }
            } else if (maxLeftX > minRightY)
            {
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        } // end-of-while
        return -1;
    } //end-of-method

    public static int findInBiotonicArray(ArrayList<Integer> A, int B) {

        int low = 0, high = A.size() - 1;

        int top = -1;

        //find bio tonic point
        while (low <= high)
        {
            int mid = low + (high - low)/2;

            System.out.printf("low %d, mid %d, high %d%n", low, mid, high);
            boolean leftCond = mid > 0 && A.get(mid - 1) < A.get(mid);
            boolean rightCond = mid < (A.size() - 1) && A.get(mid) > A.get(mid + 1);

            if(leftCond && rightCond)
            {
                System.out.printf("Biotonic Peak %d %n", mid);
                top = mid;
                break;
            }

            if (leftCond)
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }// end-of-while

        System.out.println("starting left part");
        //search on the left part
        low = 0;
        high = top;
        while (low <= high)
        {
            int mid = low + (high - low)/2;

            if (A.get(mid) == B)
            {
                System.out.println("Left part " + mid);
                return mid;
            }
            if (A.get(mid) < B)
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } // end-of-while

        low = top + 1;
        high = A.size() - 1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if (A.get(mid) == B)
            {
                System.out.println("Right part " + mid);
                return mid;
            }
            if (A.get(mid) < B)
            {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Not found");
        return -1;

    }//end-of-main

    public static boolean ifPossible(long workers, ArrayList<Integer> workArray, int timeallocated, long sum)
    {
        long totalWork = 0;
        int iter = 0;
        for(int i = 0; i < workers; i++)
        {
            long currentWork = 0;


            while(iter < ( workArray.size() ) && (currentWork + workArray.get(iter)) <= timeallocated)
            {
                currentWork += workArray.get(iter);
                iter ++;
            }

            totalWork += currentWork;
            if (iter == workArray.size() || totalWork >= sum)
                return true;

        } // end-of-for

        return false;
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {

        long low = Collections.max(C), high = C.stream().mapToInt(Integer::intValue).sum();

        for (int number : C) {
            high += number;
        }

        long sum = high;
        // System.out.printf("low %d, high %d%n", low, high);
        while (low <= high)
        {
            int mid = (int) (low + (high - low)/2);
            // System.out.printf("mid %d%n",mid);
            if(ifPossible(A, C, mid, sum))
            {
                // System.out.printf("ans: %d%n",mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            // return low;//indefinate break
        } // end-of-while


        return (int)(((low%10000003)*(B%10000003))%10000003);
    }   // end-of-paint-method
}
