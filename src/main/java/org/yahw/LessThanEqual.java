package org.yahw;


import com.oracle.truffle.api.frame.VirtualFrame;

public class LessThanEqual extends B521LangNode {
    @Child private B521LangNode left, right;

    public LessThanEqual(B521LangNode left, B521LangNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        int l = (int)this.left.execute(frame);
        int r = (int)this.right.execute(frame);
        return l <= r;
    }
}
