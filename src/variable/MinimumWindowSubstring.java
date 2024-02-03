package variable;

import java.util.HashMap;

public class MinimumWindowSubstring {
    //given a string str, and ptr.
    //str ka ek minimum substring ki length return kro jisme ptr ke saare characters aa jaaye(out of order bhi aa skte hai and extra xharacter bhi aa skte hai)
    public static int func(String str,String ptr){
        //create hashmap for ptr
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i <ptr.length(); i++) {
            char curr=ptr.charAt(i);
            if(hashMap.containsKey(curr)){
                hashMap.put(curr,hashMap.get(curr)+1);
            }
            else{
                hashMap.put(curr,1);
            }
        }

        int start=0;
        int end=0;
        int ans=Integer.MAX_VALUE;

        //jisse baar baar hashmap traverse na krna pade

        int count=hashMap.size();
        while (end<str.length()){
            char curr=str.charAt(end);

            //calculations
            //if character is present in map(ptr) then decrease its value if not then do nothing
            if(hashMap.containsKey(curr)){
                //value negative bhi ho skti hai.(which denotes extra character)
                //like t->-1 in given test case passed by main(means ek extra t hai jiski need nhi hai)
                hashMap.put(curr,hashMap.get(curr)-1);
                if(hashMap.get(curr)==0){count--;}
            }


            if(count==0){
                //this is potential answer toh answer update kro
                ans=Math.min(ans,end-start+1);
                //ab try kro window size ko ghatane ke liye coz is question mai minimum window poochi hai baakio mai maximum window poochi thi toh end++ kr dete the
                //tab tak start badao jab tak count==0 ho
                while (count==0){
                    char startChar=str.charAt(start);
                    if(hashMap.containsKey(startChar)){
                        hashMap.put(startChar,hashMap.get(startChar)+1);
                        if(hashMap.get(startChar)>0){count++;}
                    }
                    start++;
                }

            }

            else if(count>0){
                //means ki abhi saare characters nhi aaye toh window ka size badao
                end++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(func("totmtaptat","tta"));

    }
}
