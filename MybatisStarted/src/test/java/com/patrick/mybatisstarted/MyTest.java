package com.patrick.mybatisstarted;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author peicong
 * @date 2018/3/23 0023
 */
public class MyTest {
    @Test
    public void test() {
        int sum = 0;
        for (long i = 1; i <= 100000000 ; i++) {
            if (judge(i)) {
                ++sum;
            }
        }
        System.out.println(sum);
    }


    public static boolean judge(long i) {
        char[] ans = String.valueOf(i).toCharArray();
        Arrays.sort(ans);
        for (int j = 1; j <= 6 ; j++) {
            long temp = i * j;
            char[] mytemp=String.valueOf(temp).toCharArray();
            Arrays.sort(mytemp);
            if (Arrays.equals(ans, mytemp)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testDeleteBrackets() {
        deleteBrackets("(1+2-3-(2+3)+5)".toCharArray(),0,"(1+2-3-(2+3)+5)".length(),true,'1');
//        deleteBrackets("".toCharArray(),0,"".length(),true,'1');
    }


    public void deleteBrackets(char[] res,int index,int size,boolean isPositive,char last) {
        if (index==size-1) {
            return;
        }
        if (res[index] == '(') {
            if (last == '-') {
                isPositive = false;
                deleteBrackets(res, index + 1, size, isPositive, '(');
            } else {
                deleteBrackets(res, index + 1, size, isPositive, '(');
            }
            return;
        }
        if (res[index]==')') {
            if (isPositive) {
                deleteBrackets(res, index + 1, size, isPositive,')');
            } else {
                isPositive = true;
                deleteBrackets(res, index + 1, size, isPositive,')');
            }
            return;
        }
        if (res[index] >= '0'&&res[index]<='9') {
            System.out.print(res[index]);
            deleteBrackets(res,index+1,size,isPositive,res[index]);
            return;
        }
        if (res[index] == '+') {
            if (isPositive) {
                System.out.print("+");
                deleteBrackets(res,index+1,size,isPositive,'+');
            } else {
                System.out.print("-");
                deleteBrackets(res,index+1,size,isPositive,'+');
            }
            return;
        }
        if (res[index] == '-') {
            if (isPositive) {
                System.out.print("-");
                deleteBrackets(res,index+1,size,isPositive,'-');
            } else {
                System.out.print("+");
                deleteBrackets(res,index+1,size,isPositive,'-');
            }
            return;
        }
    }

    @Test
    public void testMyPrint() {
        int[] a = {0, 0, 5, 1, 0, 1, 4};
        myPrint(a,1);
    }

    public static void myPrint(int[] a,int parent) {
        System.out.print("{"+parent);
        for (int i = 1; i < a.length; i++) {
            if (a[i] == parent) {
                System.out.print("[");
                myPrint(a,i);
                System.out.print("]");
            }
        }
        System.out.print("}");
    }
}
