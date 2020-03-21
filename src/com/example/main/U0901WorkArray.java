package com.example.main;

public class U0901WorkArray <T extends Number> {
    public T[] arrNums;

    public double sum(){
        double doubleWork = 0.0;

        for (Number n : arrNums) {
            doubleWork += n.doubleValue();
        }
        return doubleWork;
    }

    public U0901WorkArray(T[] arrNums) {
        this.arrNums = arrNums;
    }
}
