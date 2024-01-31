package fixed;

public class SubarrayOfMaximumSum {
    //start is the start of window
    //end is the end of window
    //window size=end-size+1 and question mai window size k diya hoga
    //number of total windows=arr.size-k+1

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

        //yaha pr aakr sum mai first window ka sum store hai. start is at 0(starting of first window)
        //and end(end of window ke baad vala index hai , end of window nhi h)


        while(end<arr.length-1){
            ans=Math.max(ans,ans-arr[start]+arr[end]); //window ke start element ko hata do and aage vaale ko add krdo
            //thing to note is start is part of window but end is not.end window ke lat element ke baad ka element hai.
            start++;
            end++;
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[]={2,3,5,2,9,7,1};

        System.out.println(func(arr,3));
    }
}
