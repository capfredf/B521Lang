package org.yahw;

public class IntValue extends Value {
    private int val;
    public IntValue(int initVal) { val = initVal;}

    public int getVal() {
        return val;
    }

    @Override
    public String show() {
        return String.format("%d", val);
    }
}
