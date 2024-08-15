package variable;


import java.util.HashMap;

public class LongestSubArrayOfSumK {
    public static int func(int arr[],int targetSum){
        //start of window
        int start=0;
        //end of window(it is not like fixed vala end, usme last ka next element hota tha end isme end hi end hai)
        int end=0;
        //to store sum of current window
        int sum=0;
        //ans
        int ans=0;

        while(end<arr.length){
            sum=sum+arr[end];
            if(sum==targetSum){
                //it is one of the possible answers
                ans=Math.max(ans,end-start+1);
                end++;
            }
            else if(sum<targetSum){
                //since sum chota hai toh window ka size badao toh end ko badao
                end++;
            }
            else{
                //means ki sum bada hai toh window ka size ghatao toh start badaoa and tab tak badao jab tak sum target
                // se bada na ho jaaye
                //is beech mai esa time bhi aaega jab sum=targetSum ke equal ho jaaega but vo ans incude nhi krege kiuki
                //vo tab bana hai jab start++ kiya hai means window size chota kra hai, toh vo ans ho hi nhi skta
                while(sum>targetSum){
                    sum=sum-arr[start];
                    start++;
                }
                //ye loop tab tak chalegi jab tak sum>targetSum ke toh is loop ke end mai aakr sum==TargetSum hoga(lekin answer ye nhi hoga)
                //ya fir sum<targetSum hoga toh isliye tum end bada do
                end++;
            }
        }
        return ans;
    }

    //now comes the important part of question
    /*Q. Will the discussed approach work with negative numbers in the array?
      Ans.= No.
      Reason= Because let's say in the given array [4,1,1,1,2,3,5] when we found the sum within the window to be greater
      than the desired value 5 (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by doing i++.
      Here we assumed that once the sum of elements within the window becomes greater than 5 then increasing the window
      size will just add to the sum and hence we will not attain the sum 5 again. This is true when all the element are
      positive and hence reducing the window size by doing i++ makes sense. But this might not be true if array also
      contains negative numbers. Consider the array [4,1,1,-2,1,5], here we would have found the sum to be greater than
      5 for i=0, j=2 and if we would have now started reducing the window size by doing i++, we would have missed the
      potential subarray (i=0, j=4).
      In short, the discussed approach will not work with array having negative numbers.*/
    //so we have to use Map in that case


    public static int func2(int arr[],int target){

        HashMap<Integer,Integer> hashMap=new HashMap<>(); //prefix sum-> index

        int prefixSum=0;
        int ans=0;

        for (int i = 0; i <arr.length ; i++) {
            //add current element to prefix sum
            prefixSum=prefixSum+arr[i];

            if(prefixSum==target){
                ans=i+1;
            }
            else if(prefixSum>target){
                if(hashMap.containsKey(prefixSum-target)){
                    ans=Math.max(ans,i-hashMap.get(prefixSum-target)+1);
                }
            }

            //store current prefixSum in hashmap(this needa to be modified see below)
            if(!hashMap.containsKey(prefixSum))hashMap.put(prefixSum,i);
        }

        return ans;
    }

    //this method is same as 2 sum, usme hume 2 elements nikaal ne the jinka sum target ke equal ho isliye usme hashmap
    //mai elements store krte the and target-currentElement dhoondte the hashmap mai
    //but here we want a subarray jiska sum target ho toh hashmap mai prefix sum store kr rhe hai and currentPrefixSum-target
    // ko dhoond rhe hai.
    //the only problem here is we want biggest subarray, toh agar koi index x hai jispe prefixSUm target ke equal ho rha hai
    // and koi  index y(y>x) hai jispr vaapis prefixSum target ke equal ho rha hai toh hashmap usko override kr dega toh
    // subarray ka size kam ho jaaega toh agar koi prefixSum already exists krta hai toh usko update mt kro
    public static void main(String[] args) {
        int arr[]={4,1,1,1,2,3,5};
        System.out.println(func(arr,5));



    }
}
