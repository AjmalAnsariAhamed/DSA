package com.gfg;

public class MajorityElementI {
    static int majorityElementI(int [] arr){
        if(arr==null){
            return -1;
        }
        if(arr.length==1){
            return arr[0];
        }

        int elem=-1,count=0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                elem=arr[i];
            }
            if(elem==arr[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return elem;
    }

    public static void main(String[] args) {
        System.out.println(majorityElementI(new int[]{1,2,3,2,2,2,1,1,1,1,1,1,1,3,3,3,3,3}));
    }
}
