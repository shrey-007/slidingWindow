//package fixed;
//
//import java.util.HashMap;
//
//public class CountNumberOfAnagrams {
//    public static int func(String str,String ptr){
//        int ans=0;
//
//        //isme jo k hoga voh ptr ki length hogi
//        int k=ptr.length();
//
//        //sabse pehle ptr ka hashmap banalo
//        HashMap<Character,Integer> hashMap=new HashMap<>();
//        for (int i = 0; i < ptr.length(); i++) {
//            char curr=ptr.charAt(i);
//            if(hashMap.containsKey(curr)){
//                hashMap.put(curr,hashMap.get(curr)+1);
//            }
//            else{
//                hashMap.put(curr,1);
//            }
//        }
//
//        //ye variable isliye hai jisse baar baar hasmap traverse na krna pade
//        int count=hashMap.size();
//
//        int start=0;
//        int end=0;
//
//        while (end-start+1!=k+1){
//            if(hashMap.containsKey(str.charAt(end))){
//                hashMap.put(str.charAt(end),hashMap.get(str.charAt(end)-1));
//                //count negative nhi hoga coz window size ptr ki lenght hai
//                if(hashMap.get(str.charAt(end))==0){count--;}
//            }
//            end++;
//        }
//
//        while (end<str.length()){
//            if(count==0){ans++;}
//        }
//
//
//
//
//
//
//    }
//    public static void main(String[] args) {
//
//    }
//}
