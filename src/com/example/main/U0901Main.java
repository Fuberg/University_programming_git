package com.example.main;

import java.util.Random;

public class U0901Main {
    public static void main(String[] args){
        Integer intArr[] = {10,20,15};
        Float floatArr[] = new Float[6];

        for (int i = 0; i < floatArr.length; i++) {
            floatArr[i] = new Random().nextFloat();
            System.out.println(floatArr[i]);
        }

        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<Integer>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<Float>(floatArr);

        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());



    }
}
