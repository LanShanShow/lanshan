package com.ls.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangzhuang
 * @Date: 2019/1/30 17:11
 * @Description: 基数排序
 */
public class CardinalNumberSort {

    private static Map<Integer, Integer[]> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(345 % 10);
        System.out.println(389 / 10%10);
        System.out.println(10 );

        cardinalNumber(new Integer[]{999,85,8,53,336,9,883,12,415,19,15,166,122,155,265,263,832,356,215,6,9,2,19,88,26});
    }

    public static void cardinalNumber(Integer[] numbers) {
        //初始化
        init(numbers.length);
        //位数
        int index = 1;
        for (int i = 0; i < numbers.length; i++) {
            int div = 1;
            int iii = 10;
            while (numbers[i]/iii>0){
                div++;
                iii*=10;
            }
            if(div>index){
                index= div;
            }
        }
        System.out.println(index);
        for (int i=0; i<index;i++){
            cardinal(numbers,i);
            out();
            numbers =get(numbers.length);
            init(numbers.length);
        }
    }

    private static void cardinal(Integer[] numbers,int index){
        int div =1;
        for(int f = 0;f<index;f++){
            div*=10;
        }
        for (int i = 0; i < numbers.length; i++) {
            Integer[] ii = map.get(numbers[i]/div%10);
            for (int j =0;j<ii.length;j++){
                if(ii[j]==null){
                    ii[j]=numbers[i];
                    break;
                }
            }
        }
    }
    private static void init(int length) {
        for (int i = 0; i < 10; i++) {
            map.put(i, new Integer[length]);
        }
    }
    private static Integer[] get(int length) {
        Integer[] re = new Integer[length];
        int ind = 0;
        for (int i = 0; i < 10; i++) {
            Integer[] s = map.get(i);
            for(int j=0;j<s.length;j++){
                if(s[j]!=null){
                    re[ind]=s[j];
                    ind++;
                }
            }
        }
        return re;
    }
    private static void out(){
        map.forEach((k,v)->{System.out.print("k:"+k+" v:");
        Arrays.stream(v).filter(vv ->vv!=null).forEach(vvv ->System.out.print(vvv+" "));
        System.out.println();});
        map.forEach((k,v)-> Arrays.stream(v).filter(vv->vv!=null).forEach(vvv->System.out.print(vvv+" ")));
        System.out.println();
    }
}
