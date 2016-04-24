package com.company;

/**
 * Created by siddharthmolleti on 1/13/16.
 */
public class BitManipulation {
    public static int[] decimalToBinary(int num) {
        int[] bits  = new int[10];
        for (int c: bits) {
            c = 0;
        }
        int remainder = 0;
        //int dividend = 0;
        int index =0;
        while (num != 0) {
            remainder = num % 2;
            bits[index] = remainder;
            num = num/2;
            index++;
        }

        return bits;
    }

    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        System.out.println("Allones" + Integer.toBinaryString(allOnes));
        int left = allOnes << (j + 1);
        System.out.println("Allones with left shited j + 1 positions" + Integer.toBinaryString(left));
        int right = ((1 << i) - 1);
        System.out.println("Allones with left shited i positions" + Integer.toBinaryString(right));
        int mask = left | right;
        System.out.println("final" + Integer.toBinaryString(mask));


        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }





    public static void main(String[] args) {
        /*
        int[] test = decimalToBinary(45);
        for (int i: test) {
            System.out.print(i);
        }

        System.out.println(1 << 3);
        System.out.println(Integer.toBinaryString(1 << 3));
        System.out.println(Integer.toBinaryString(16));
        int b = (16 | (1 << 3));
        System.out.println(Integer.toBinaryString(b));

        b = b & ~(1 << 3);

        System.out.println(Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(1 << 6));
        System.out.println(Integer.toBinaryString((1 << 6) - 1) );
        System.out.println(Integer.toBinaryString(~((1 << 6) - 1)) );
        System.out.println(Integer.toBinaryString(~((1 << 6) - 1) << 4) );

       // System.out.println(Integer.toBinaryString(~((1 << 6) - 1)));


       // System.out.println(4 ^ 4);
        //System.out.
        */

        System.out.println(updateBits(Integer.parseInt("10000000000000", 2), Integer.parseInt("1011", 2), 2, 6));
    }
}
