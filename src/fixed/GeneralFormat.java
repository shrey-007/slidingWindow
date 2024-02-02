package fixed;

public class GeneralFormat {
    //this is general format but i have not followed this format for fixed size problems
    public static int func(int arr[],int k){
       int start=0;
       int end=0;
       int windowSize=end-start+1;
       int ans=0;
       while(end<arr.length){

           //calculations

           if (windowSize < k) {
               end++;
           }

           else if(windowSize==k){
               //then this is one of the possible answer so update
               //reomove calculaton for i
               //maintain window size and slide
           }
       }
       return ans;

    }

    public static void main(String[] args) {

    }
}
