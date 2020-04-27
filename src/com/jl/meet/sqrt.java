package com.jl.meet;

/**
 * JL
 * 2020/4/22  13:34
 * 对一个数开几次方根
 **/
public class sqrt {

    public static void main(String[] args) {
        int  result=2,num = 2;
        int  total = num;
        int temp = 1;
        int low = 0,high;

        for(int i =2;;i++){
            total = num;
            temp = 1;
            while(total> 0){
                temp *= i;
                total --;
            }
            if(temp == result){
                high = i;
                System.out.println("high="+high);
                break;

            }else if(temp > result ){
                high = i;
                low = i-1;
                break;
            }
        }
        if  (temp == result){
            return;
        }

        Float aFloat1=1.0f;
        Float aFloat =1.0f;
        Float end = 1.0f;

        for(int i = 0;i < 4;i++){
            int  j = 1;

            while(j< 10){
                Float fNum = 1.0f;
                total = num;
                if(i==0){
                    aFloat = Float.valueOf(String.valueOf(low) + "." + j);
                }else{
                    aFloat = Float.valueOf(String.valueOf(end) + j);
                }

                while(total> 0){
                    fNum *= aFloat;
                    --total;
                }
                if(fNum>result){
                    if(i==0){
                        aFloat1 = Float.valueOf(String.valueOf(low) + "." + (j-1));
                    }else{
                        aFloat1 = Float.valueOf(String.valueOf(end) + (j-1));
                    }
                    end = aFloat1;
                    break;
                }else if(fNum == result){
                    aFloat1 = aFloat;
                    end = aFloat1;
                    break;
                }
                j++;
            }//while
        }// for
        System.out.println(end);
    }
}
