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


///this is the actual code which is working
//if(s.length()<t.length()){
//        return "";
//        }
//
//        int res = Integer.MAX_VALUE;
//        int i = 0;
//        int j = 0;
//        int count = 0;
//        int jx=-1;
//        int ix=-1;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int x = 0; x < t.length(); x++) {
//        char c = t.charAt(x);
//        if (map.containsKey(c)) {
//        map.put(c, map.get(c) + 1);
//        }
//        else{
//        map.put(c, 1);
//        }
//        }
//        count = map.size();
//        while (j < s.length()) {
//        char c = s.charAt(j);
//        if (map.containsKey(c)) {
//        map.put(c, map.get(c) - 1);
//        if (map.get(c) == 0) {
//        count--;
//        }
//        }
//        if (count != 0) {
//        j++;
//        } else if (count == 0) {
//        while (count == 0) {
//        c = s.charAt(i);
//        if (map.containsKey(c)) {
//        map.put(c, map.get(c)+1);
//        if(map.get(c)>0) {
//        if (res > j - i + 1) {
//        res = j - i + 1;
//        ix = i;
//        jx = j;
//        }
//        count++;
//        }
//        }
//        i++;
//        }
//        j++;
//        }
//        }
//        if(ix==-1){
//        return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int q=ix;q<=jx;q++){
//        sb.append(s.charAt(q));
//        }
//        return sb.toString();
//        }