package com.jl.meet.delete;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * JL
 * 2020/4/27  14:46
 * 删除元素注意元素相对位置的移动
 **/
public class DeleteListNode {

    public static void main(String[] args) {
        LinkedList<User> userL = new LinkedList<User>();
        userL.add(new User(21));
        userL.add(new User(21));
        userL.add(new User(17));
        userL.add(new User(21));
        userL.add(new User(16));
        removeList( userL);
        System.out.println(userL);
    }



    public static void removeList(List<User> userList){
        int i = 1;
        int index = 0;
        int[] arr = new int[userList.size()];
        System.out.println(Arrays.toString(arr));
        for(User user:userList){
            if(user.getAge() > 20){
              arr[index++] = i;
            }
            i++;
        }
        // 请勿忘记考虑删除元素的前移，导致错误删除数据
        int s = 0;
        for(int t = 0;arr[t] > 0;t++){
            userList.remove(arr[t]-1-s);
            s++;
        }
        System.out.println(userList);
    }
}
