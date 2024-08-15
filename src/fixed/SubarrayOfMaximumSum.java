package fixed;

/** K size ke saare subarrays ke sum mai se max sum batana hai or
 * find sum of subarray of size k having maximum sum

 */
public class SubarrayOfMaximumSum {
    //start is the start of window
    //end is the end of window
    //window size=end-size+1 and question mai window size k diya hoga
    //number of total windows=arr.size-k+1

    /** code by me*/

    static int func(int arr[],int k){
        int start=0;
        int end=0;
        int ans=0;

        //tum bologe ki directly start=0 and end=k-1 kiu nhi rakha. Vesa bhi kr skte the but start se end tak sum chaiye
        // tha, uske liye 3rd pointer lete usse accha end ko tab tak badao jab tak window k size na ho jaaye and sum bhi
        //krte jaao and jese hi k size ki ho jaaegi window fir uska size maintain kro
        while(end-start+1!=k+1){
            ans=ans+arr[end];
            end++;
        }

        //yaha pr aakr ans mai first window ka sum store hai. start is at 0(starting of first window)
        //and end(end of window ke baad vala index hai , end of window nhi h)
        //ans mai first window ka sum hai(this is important thing)


        while(end<arr.length-1){
            ans=Math.max(ans,ans-arr[start]+arr[end]); //window ke start element ko hata do and aage vaale ko add krdo
            //thing to note is start is part of window but end is not.end window ke lat element ke baad ka element hai.
            start++;
            end++;
        }

        return ans;
    }

    /** code given by youtuber*/

    static int func2(int arr[],int k){
        int start=0;
        int end=0;
        int ans=Integer.MIN_VALUE;

        int sum=0;
        while (end<arr.length){
            // do work
            sum=sum+arr[end];

            // window is smaller than increase its size
            if(end-start+1<k){end++;}

            // window reached its size
            else if(end-start+1==k){
                // jaise hi window apne size pr pahuch jaaye vese hi answer update kro
                ans=Math.max(ans,sum);
                sum=sum-arr[start];
                start++;
                end++;
                // older start ko sum se abhi nikaal diya but end ko sum mai agle iteration mai add include karege
            }


        }

        return ans;
    }

    /** code by chatgpt */
    public static int maxSumSubarray(int[] arr, int k) {
        // Check for invalid input
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Initialize the sum of the first window
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        // Initialize the current sum as the sum of the first window
        int currentSum = maxSum;

        // Slide the window over the array
        for (int i = k; i < arr.length; i++) {
            // Update the current sum by sliding the window
            currentSum += arr[i] - arr[i - k];
            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int arr[]={2,3,5,2,9,7,1};

        System.out.println(func(arr,3));
        System.out.println(func2(arr,3));

    }
}
