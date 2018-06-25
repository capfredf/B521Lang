package org.yahw;

public class B521LangRootNode {
    private B521LangNode[] children;
    public B521LangRootNode(B521LangNode[] children) {
        this.children = children;
    }

    public Object eval(Env e) {
        int last = this.children.length - 1;
        for (int i = 0; i<last; i++) {
            this.children[i].eval(e);
        }
        return this.children[last].eval(e);
    }
}
