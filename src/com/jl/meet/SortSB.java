package com.jl.meet;

import java.util.Arrays;

/**
 * JL
 * 2020/5/6  12:31
 **/
public class SortSB {

    /**
     * 给你五张牌，判断下是否是顺子，大小鬼可以替换任意一张
     * @param args
     */
    public static void main(String[] args) {
                int[] arr =new int[5];
                // 大鬼
                int max = 10000;
                // 小鬼
                int min = 99999;
                int[] sort = new int[5];
                int index_max = -1;
                int index_min = -1;
                int j = 0;
                for(int i = 0; i < arr.length;i++){
                    if(max == arr[i]){
                        index_max = i;
                        continue;
                    }
                    if(min == arr[i]){
                        index_min = i;
                        continue;
                    }
                    sort[j++] = arr[i];
                }

                for(int i = 0 ; i < sort.length;i++){
                    int temp = i;
                    for(int t = sort.length-1; t>i; t--){
                        if(i!= t && sort[i] == sort[t] ){
                            return ;
                        }else{
                            if(sort[temp] > sort[t]){
                                temp = t;
                            }
                        }
                    }
                    int rr = sort[temp];
                    sort[temp] = sort[i];
                    sort[i] = rr;
                }

                int[] result = new int[5];
                int t = 0;
                for(int i = 0;i < sort.length;i++){
                    if(sort[i] == 0){
                        continue;
                    }
                    if(i < sort.length-1 && sort[i]- sort[i+1] > 2){
                        return;
                    }else if(i < sort.length-1 && sort[i+1]-sort[i] == 1){
                        result[t++] = sort[i];
                        if(index_max >= 0 || index_min >= 0){
                            if(index_max >= 0){
                                result[t++] = arr[index_max];
                                index_max = -1;
                                continue;
                            }
                            if(index_min >= 0){
                                result[t++] = arr[index_min];
                                index_max = -1;
                                continue;
                            }
                        }else{
                            return;
                        }
                    }else if(i < sort.length-1 && sort[i+1]-sort[i] == 2){
                        result[t++] = sort[i];
                        if(index_max >= 0 && index_min >= 0){
                            result[t++] = arr[index_max];
                            index_max = -1;
                            result[t++] = arr[index_min];
                            index_min= -1;
                        }else{
                            return;
                        }
                    }else{
                        result[t++] = sort[i];
                    }
                }
            }
        }
