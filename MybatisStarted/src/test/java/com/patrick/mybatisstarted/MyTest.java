package com.patrick.mybatisstarted;

import org.junit.Test;

import java.util.*;

/**
 * @author peicong
 * @date 2018/3/23 0023
 */
public class MyTest {
    @Test
    public void test() {
        int sum = 0;
        for (long i = 1; i <= 100000000; i++) {
            if (judge(i)) {
                ++sum;
            }
        }
        System.out.println(sum);
    }


    public static boolean judge(long i) {
        char[] ans = String.valueOf(i).toCharArray();
        Arrays.sort(ans);
        for (int j = 1; j <= 6; j++) {
            long temp = i * j;
            char[] mytemp = String.valueOf(temp).toCharArray();
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
        deleteBrackets("(1+2-3-(2+3)+5)".toCharArray(), 0, "(1+2-3-(2+3)+5)".length(), true, '1');
//        deleteBrackets("".toCharArray(),0,"".length(),true,'1');
    }


    public void deleteBrackets(char[] res, int index, int size, boolean isPositive, char last) {
        if (index == size - 1) {
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
        if (res[index] == ')') {
            if (isPositive) {
                deleteBrackets(res, index + 1, size, isPositive, ')');
            } else {
                isPositive = true;
                deleteBrackets(res, index + 1, size, isPositive, ')');
            }
            return;
        }
        if (res[index] >= '0' && res[index] <= '9') {
            System.out.print(res[index]);
            deleteBrackets(res, index + 1, size, isPositive, res[index]);
            return;
        }
        if (res[index] == '+') {
            if (isPositive) {
                System.out.print("+");
                deleteBrackets(res, index + 1, size, isPositive, '+');
            } else {
                System.out.print("-");
                deleteBrackets(res, index + 1, size, isPositive, '+');
            }
            return;
        }
        if (res[index] == '-') {
            if (isPositive) {
                System.out.print("-");
                deleteBrackets(res, index + 1, size, isPositive, '-');
            } else {
                System.out.print("+");
                deleteBrackets(res, index + 1, size, isPositive, '-');
            }
            return;
        }
    }

    @Test
    public void testMyPrint() {
        int[] a = {0, 0, 5, 1, 0, 1, 4};
        myPrint(a, 1);
    }

    public static void myPrint(int[] a, int parent) {
        System.out.print("{" + parent);
        for (int i = 1; i < a.length; i++) {
            if (a[i] == parent) {
                System.out.print("[");
                myPrint(a, i);
                System.out.print("]");
            }
        }
        System.out.print("}");
    }

    @Test
    public void testRepeatCombination() {
        int a[] = {2, 3, 1};
    }

    public static void f(int[] data, int goal, int k, int[] x) {
        if (k == x.length) {
            if (goal == 0) {
                printCombination(x);
            }
            return;
        }
        for (int i = 0; i <= Math.min(data[k], goal); ++i) {
            x[k] = i;
            f(data, goal - i, k + 1, x);
        }
        x[k] = 0;
    }

    public static void printCombination(int[] x) {

    }

    @Test
    public void testComparator() {
        String[] list = {"a", "bc", "abcd", "ad", "bcd"};
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String my : list) {
            System.out.println(my);
        }
    }

    @Test
    public void testLambda() {
        String[] list = {"a", "bc", "abcd", "ad", "bcd"};
        Arrays.sort(list, ((o1, o2) -> o2.length() - o1.length()));
        for (String my : list) {
            System.out.println(my);
        }
    }

    class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    @Test
    public void testMove() {
        Scanner scanner = new Scanner(System.in);
        int arryNum = scanner.nextInt();
        int moveNum = scanner.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arryNum; i++) {
            list.add(scanner.nextInt());
        }
        while (moveNum-- != 0) {
            int temp = list.get(0);
            list.remove(0);
            list.add(temp);
        }
        for (int i = 0; i < arryNum - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print(list.get(arryNum - 1));
    }

}
