/**
 * An array contains n numbers ranging from 0 to n-2. There is exactly one number duplicated in the array.
 * How do you find the duplicated number? For example, if an array with length 5 contains numbers {0, 2, 1, 3, 2}, the duplicated number is 2.
 */

public class DuplicateFinder {

    private static int findDuplicate ( int[] arr ) {
        int n = arr.length;
        int expectedSum = (n-2) * (n-1) /2;
        int sum = 0;

        for(int num : arr){
            sum += num;
        }
        return sum - expectedSum;
    }

    public static void main ( String[] args ) {
        int[] arr = {0, 2, 1, 3, 2};

        int duplicateArr = findDuplicate(arr);
        System.out.println("The duplicated number is: " + duplicateArr);

    }
}
