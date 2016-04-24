package com.company;

/**
 * Created by siddharthmolleti on 1/15/16.
 */
public class ProductOfFirstKLargestElementsInArray {
    public static int getProductOfFirstK(int[] num, int productSize) {
        //int product = 0;
        for (int i = 0; i < productSize; i++) {
            for (int j = i; j < num.length - i; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        return num[0] * num[1] * num[3];
    }

    public static int returnProductOfFirstK(int[] num, int prod) {
        for (int i = 0; i < prod; i++) {
            for (int j = i; j <num.length -i; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = num[i];
                }
            }
        }

        int product = num[0];

        for (int i = 1; i < prod; i++) {
            product = product * num[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] num = {4, 6, 2, 7 , 21, 32};
        System.out.println(getProductOfFirstK(num, 3));
    }
}
