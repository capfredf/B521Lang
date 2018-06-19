package org.yahw;

public class BoolValue extends Value {
    private boolean val = false;
    public BoolValue(boolean val) {
        this.val = val;
    }
    public boolean isTrue() {
        return val==true;
    }
    @Override
    public String show() {
        return String.format("%b", this.val);
    }
}
