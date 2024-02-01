package fixed;

import java.util.HashMap;
//still not solved, passed 50/90 testcases on gfg
public class CountNumberOfAnagrams {
    public static int func(String str,String ptr){
        int ans=0;

        //isme jo k hoga voh ptr ki length hogi
        int k=ptr.length();

        //sabse pehle ptr ka hashmap banalo
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < ptr.length(); i++) {
            char curr=ptr.charAt(i);
            if(hashMap.containsKey(curr)){
                hashMap.put(curr,hashMap.get(curr)+1);
            }
            else{
                hashMap.put(curr,1);
            }
        }

        //ye variable isliye hai jisse baar baar hasmap traverse na krna pade
        int count=hashMap.size();

        int start=0;
        int end=0;

        while (end-start+1!=k+1){
            char curr=str.charAt(end);
            if(hashMap.containsKey(curr) && hashMap.get(curr)==0){}
            else if(hashMap.containsKey(curr)){
                hashMap.put(curr,hashMap.get(curr)-1);
                //count negative nhi hoga coz window size ptr ki lenght hai
                if(hashMap.get(curr)==0){count--;}
            }
            end++;
        }

        //yaha tak aakr
        //start points to start of window
        //end points to the element just after last of window
        //and count mai likha hai ki kitne aur character hi jo abhi tak is particular substring mai nhi aaye


        while (end<str.length()){
            //means there is an substring jo ki ptr ki anagram hai toh ans++
            if(count==0){ans++;}

            char scurr=str.charAt(start);
            char ecurr=str.charAt(end);

            //work on start
            if(hashMap.containsKey(scurr)){
                //means ki current character ptr mai tha and ise remove krege toh hashmap mai iska count badao
                if(hashMap.get(scurr)==0){count++;}
                hashMap.put(scurr,hashMap.get(scurr)+1);
            }

            //work on end
            if(hashMap.containsKey(ecurr)){
                hashMap.put(ecurr,hashMap.get(ecurr)-1);
                //count negative nhi hoga coz window size ptr ki lenght hai
                if(hashMap.get(ecurr)==0){count--;}
            }

            start++;
            end++;
        }
        if(count==0){ans++;}
            return ans;
    }








    public static void main(String[] args) {
        System.out.println(func("aabaabaa","aaba"));
    }
}
