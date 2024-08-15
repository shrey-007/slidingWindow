package fixed;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * find First negative integer in every window of size k
 * */
public class FirstNegativeNumberInEveryWindow {
    public static int [] func(int arr[],int k){
        //to give ans
        int ans[]=new int[arr.length-k+1];

        //to store negative number in FIFO order.
        Deque<Integer> queue=new ArrayDeque<>();

        int start=0;
        int end=0;

        while (end-start+1!=k+1){
            //agar negative element hai toh unhe queue mai add kro
            if(arr[end]<0){queue.add(arr[end]);}
            end++;
        }

        //yaha aane ke baad start is on start of window and end is just after the last element of window
        //ans and queue mai first window ke saare negative elements aa gye
        while (end<arr.length){
            //first negative element of current window is head of queue
            ans[start]=queue.peek();

            // start ko hatane se pehle agar start ka element queue mai hai toh use hatao.
            //and vo queue mai tabhi hoga agar vo negative hoga and vo head pr hoga toh hume head remove krna hai.
            if(arr[start]<0){
                queue.poll();
            }
            //check whether end is negative or not
            if(arr[end]<0){queue.add(arr[end]);}
            start++;
            end++;
        }
        return ans;
    }

    public static int[] func2(int arr[],int k){

        int ans[]=new int[arr.length-k+1];

        Deque<Integer> queue=new ArrayDeque<>();

        int start=0;
        int end=0;
        while (end<arr.length){

            // do work
            if(arr[end]<0){queue.add(arr[end]);}

            // if window size is less
            if(end-start+1<k){
                end++;
            }

            // if window size hits
            else if(end-start+1==k){
                // update ans
                if(!queue.isEmpty()){ans[start]=queue.peek();}
                else{ans[start]=0;}
                // start ko aage badana hai
                if(arr[start]<0){queue.poll();}
                start++;
                end++;
            }
        }
        return ans;
    }

    public static void print(int arr[]){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[]={12,-1,-7,8,-15,30,13,28};
        print(func(arr,3));
        print(func2(arr,3));
    }
}
