package variable;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int func(String str){
        int start=0;
        int end=0;
        int ans=0;

        HashSet<Character> hashSet=new HashSet<>();
        while(end<str.length()){

            char curr=str.charAt(end);

            //check whether curr is already in hashmap or not
            if(hashSet.contains(curr)){
                //since hashset contains this curr, so this substring is not our ans
                //so increase start until the substring contains unique character
                while(curr!=str.charAt(start)){
                    hashSet.remove(str.charAt(start));
                    start++;
                }
                start++;
            }
            else{
                //since it is not in hashmap so we have to add it
                hashSet.add(curr);
                //also update the ans
                ans=Math.max(ans,end-start+1);
            }
            end++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(func("aabbcc"));

    }
}
