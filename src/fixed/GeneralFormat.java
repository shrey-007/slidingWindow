package fixed;

public class GeneralFormat {
    //this is general format but i have not followed this format for fixed size problems
    public static int func(int arr[],int k){
       int start=0;
       int end=0;
       int windowSize=end-start+1;
       int ans=0;
       while(end<arr.length){

           //calculations(do work)

           if (windowSize < k) {
               end++;
           }

           else if(windowSize==k){
               //then this is one of the possible answer so update ans

               //remove calculaton for i
               start++;
               end++;
               // yaha par start ka removal kara and start ko bada diya, end ko badaya but end ko anwer mai include nhi
               // kiya vo agli iteration mai (do work) vaale section mai hoga toh usme end se related kaam hoga
           }
       }


       return ans;

    }

    public static void main(String[] args) {

    }
}
