## NEED

```java
int arr[]={2,3,5,2,9,7,1};
```
3 size ke saare subarrays ka sum nikaalo-:
```java

for(int i=0;i<arr.length;i++){
    int sum=0;
    for(int j=0;j<3;j++){
        sum=sum+arr[j];
        }
}
```
But ye repetetive kaam hai coz steps ye hai-:
1) 2,3,5 ka sum hua first iteration mai
2) 3,5,2 ka sum hua second iteration mai
3) 5,2,9 ka sum hua second iteration mai  
 - But ye krne ka baar baar koi sense nhi hai since 1st step mai 2,3,5 ka sum ho chuka tha toh 2nd ka sum nikaal ne ke liye vaapis sum ni krna 2 ko hata hai and 2 ko laana hai
 - Similarly jab 2nd iteration mai 3,5,3 ka sum pata hai toh 3rd step ka sum scratch se nikaalne se achha 2nd sum mai se 3 ko subtract kro and 9 ko add kro

## IDENTIFICATION
1) Array/String ke question
2) subarray/substring
3) min/max
4) k(window size), sometimes it is not given(variable size)
