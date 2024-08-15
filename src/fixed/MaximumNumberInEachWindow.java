package fixed;

import java.util.ArrayList;

public class MaximumNumberInEachWindow {
    /**
     * Heap se solve ni hoga
     * List se hi krna padega
     * */
    public static int[] func(int arr[],int k){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int ans[]=new int[arr.length-k+1];
        int start=0;
        int end=0;


        while(end-start+1!=k+1){
            //check whether current element is bigger or smaller than list last item
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

    /**
     *  arr={1,3,2,1,5}
     *
     *  First window pr aaye toh - [1,3,2] dikha toh 3 max hua
     *
     *  Second window pr aaye toh - [3,2,1] dikha toh ya toh vaapis se max nikaalo ya fir bas ye dekh lo ki jo number
     *  gaya hai[1] vo max toh nhi tha and jo new number aaya hai[1] vo max toh nhi hai. Max abhi bhi 3 hi hai
     *
     * Third window pr aaye toh - [2,1,5] dikha toh since jo number abhi gaya hai vahi max tha toh ab mujhe iterate krna
     * padega is window mai new max nikaalne ke liye. Toh ye na krna pade isliye arraylist use krege
     *
     * DRY RUN-:
     index= 0 1  2  3 4 5 6 7
     * arr={1,3,-1,-3,5,3,6,7}    (end)currentElement=1      list=1   (1 maybe max ho skta hai)   (window not reached)
     * arr={1,3,-1,-3,5,3,6,7}    (end)currentElement=3      list=3   (1 paaka kabhi max nhi ho skta kiuki 1 nikal gaya toh 3 hai and agar 3 nikala toh 1 already chuka hai)   (window not reached)
     * arr={1,3,-1,-3,5,3,6,7}    (end)currentElement=-1      list=3,-1   (-1 maybe max ho skta hai agar 3 nikal jaaye)   (window reached)
     * arr={1,3,-1,-3,5,3,6,7}    (end)currentElement=-3      list=3,-1,-3   (Ab window size reach ho gya hai toh start++ krna padega but dekh lo ki max element(list[0]) start hi toh nhi hai, start is pointing 1 and max is 3 toh nhi hai toh directly start++ krdo also -1 agar chala gaya toh -3 max ban skta hai toh use list mai add kro)   (window reached)
     * arr={1,3,-1,-3,5,3,6,7}    (end)currentElement=5     list=5   (5 aagya hai toh 3,-1,-1 kabhi bhi max nhi ho skte ab tum sochoge ki agar 5 chala gya toh , ha toh agar 5 chala gaya toh uske baad vaalo mai se koi max bangega uske pehle vaalo mai se nhi nhi banega)   (window not reached)
     * */

    public static int [] func2(int arr[],int k){

        int ans[]=new int[arr.length-k+1];
        ArrayList<Integer> list=new ArrayList<>();

        int start=0;
        int end=0;

        while (end<arr.length){

            // do work
            while(!list.isEmpty() && list.get(list.size()-1)<arr[end]){
                list.remove(list.size()-1);
            }
            list.add(arr[end]);

            // if window size is smaller toh increase kro
            if(end-start+1<k){
                end++;
            }

            // maintain window size
            else if(end-start+1==k){
                // update ans
                ans[start]=list.get(0);
                // window ko slide kro
                //start++ krne se pehle dekhlo start hi max toh nhi hai
                if(list.get(0)==arr[start]){list.remove(0);}
                start++;
                end++;
            }
        }

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
        print(func2(arr,3));
    }
}
