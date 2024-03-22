import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) {

        Long[] array = new Long[28566];

        for (int i = 0; i <= 16930; i++) {
            array[i] = (i + 1L);
        }

        for (int i = 0; i <= 10085; i++) {
            array[i + 16931] = 16932L;
        }

        for (int i = 27017; i <= 28565; i++) {
            array[i] = array[i-1] + 1;
        }
        //System.out.println(Arrays.toString(array));
        Pair par = findRepeating(array, array.length);

        System.out.println(par.x + " " + par.y);
    }
    static class Pair{
         long x;
         long y;
         
         Pair(long x, long y){
             this.x = x;
             this.y = y;
         }
     }
    //Function to find repeated element and its frequency.
    public static Pair findRepeating(Long arr[],int n)
    {
        long repeated = getRepeating(arr, n);
        if (repeated == -1) {
            return new Pair(-1, -1);
        }
        
        int first = findFirstOccur(arr, n, repeated);
        int last = findLastOccur(arr, n, repeated);
        
        return new Pair(repeated, (last-first+1));
        
    }
    
    private static long getRepeating(Long arr[], int n) {
        
        if(n == 1) {
            return -1;
        }
        
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if((mid == 0 || arr[mid].equals(arr[mid-1]))
            || (mid != n-1 && arr[mid].equals(arr[mid+1]))) {
                return arr[mid];
            } else {
                int indexDiff = mid - low;
                long valueDiff = arr[mid] - arr[low];
                
                if(indexDiff == valueDiff) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
        }
        
        return -1;
    }
    
    private static int findFirstOccur(Long arr[], int n, long target) {
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(target <= arr[mid]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private static int findLastOccur(Long arr[], int n, long target) {
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(target >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        
        return high;
    }
    
}