package org.yahw;

public class B521LangRootNode {
    private B521LangNode[] children;
    public B521LangRootNode(B521LangNode[] children) {
        this.children = children;
    }

    public Object eval(Env e) {
        Object result = null;
        for (int i = 0; i < this.children.length; i++) {
            B521LangNode child = this.children[i];
            if (child instanceof DefineNode) {
                e = ((DefineNode) child).extendEnv(e);
            } else {
                result = child.eval(e);
            }
        }
        return result;
    }
}
