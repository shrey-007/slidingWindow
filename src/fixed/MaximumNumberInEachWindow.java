package fixed;

import java.util.ArrayList;

public class MaximumNumberInEachWindow {
    public static int[] func(int arr[],int k){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int ans[]=new int[arr.length-k+1];
        int start=0;
        int end=0;


        while(end-start+1!=k+1){
            //check whether current elment is bigger or smaller than list last item
            while(arrayList.size()>0 && arrayList.get(arrayList.size()-1)<arr[end]){
                arrayList.remove(arrayList.size()-1);
            }
            //add current element
            arrayList.add(arr[end]);
            end++;
        }

        //yaha pr aakr start is at 0(starting of first window)
        //and end is at (end of window ke baad vala index hai , end of window nhi h)
        //arraylist ka head(0th index) is having maximum of window

        while(end<arr.length){
            //store max of current window
            ans[start]=arrayList.get(0);
            //start work
            //kiuki hume window ka first element hatana hai toh hatane se pehle dekhlo kahi vo max toh nhi
            if(arr[start]==arrayList.get(0)){
              //remove the first element
              arrayList.remove(0);
            }

            //end work
            //same as above code
            while(arrayList.size()>0 && arrayList.get(arrayList.size()-1)<arr[end]){
                arrayList.remove(arrayList.size()-1);
            }
            //add current element
            arrayList.add(arr[end]);

            //slide window
            start++;
            end++;
        }
        ans[start]=arrayList.get(0);
        return ans;
    }

    public static void print(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={2,3,5,2,9,7,1};
           print(func(arr,3));
    }
}
