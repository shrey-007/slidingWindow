package variable;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithKUniqueCharacters {
    public static int func(String str,int k){
        //stores unique characters of window
        HashMap<Character,Integer> hashMap=new HashMap<>();
        int ans=0;
        int start=0;
        int end=0;
        while (end<str.length()){
            char curr=str.charAt(end);

            //agar current character already map mai present hai toh uska count badao else uska count 1 krdo
            if(hashMap.containsKey(curr)){hashMap.put(curr,hashMap.get(curr)+1);}
            else{hashMap.put(curr,1);}


            if(hashMap.size()==k){
                //it is possible answer
                ans=Math.max(ans,end-start+1);
                end++;
            }
            else if(hashMap.size()<k){
                end++;
            }
            else{
                char startCharacter=str.charAt(start);
                //increase start and remove it from hashmap
                while(hashMap.size()>k){
                    hashMap.put(startCharacter,hashMap.get(startCharacter)-1);
                    if(hashMap.get(startCharacter)==0){hashMap.remove(startCharacter);}
                    start++;
                }
                end++;
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(func("aabacbebebe",3));
    }
}
