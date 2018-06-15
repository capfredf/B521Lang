import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import org.yahw.*;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;


public class HelloWorld {
    public static void main(String[] args) {
        B521LangNode app;
        FrameDescriptor globalFrameDescriptor = new FrameDescriptor();
        VirtualFrame globalFrame = Truffle.getRuntime().createVirtualFrame(null,
                globalFrameDescriptor);

//        test();
//        a = new IntNode(10);
//        b = new IntNode(20);
//        c = new PlusNode(a, b);
//        a = new VarNode("x");
//        b = new VarNode("x");
//        body = new PlusNode(a, b);
//        lambda = new LambdaNode(new VarNode("x"), body);
//        outter = new LambdaNode(new VarNode("x"), lambda);
//        c = new AppNode(outter, new IntNode(10));
//        app = new AppNode(c, new IntNode(30));
        app = new AppNode(
                new AppNode(
                        new LambdaNode(new VarNode("x"),
                                new LambdaNode(new VarNode("x"),
                                        new PlusNode(new VarNode("x"), new VarNode("x"))
                                )
                        ),
                        new IntNode(10)
                ),
                new IntNode(30)
        );

        app = new AppNode(
                    new LambdaNode(new VarNode("x"),
                            new AppNode(
                                    new LambdaNode(new VarNode("x"),
                                            new PlusNode(new VarNode("x"), new VarNode("x"))
                                    ),
                                    new IntNode(10)
                            )
                        ),
                    new IntNode(30)
        );

        B521LangNode[] allNodes = {app};
        B521LangRootNode rootNode = new B521LangRootNode(allNodes, globalFrameDescriptor);
        long start = System.currentTimeMillis();
        RootCallTarget rootTgtCall = Truffle.getRuntime().createCallTarget(rootNode);
        Value res = (Value) rootTgtCall.call(new Object[] {globalFrame.materialize()});
//        Value res = rootNode.execute(globalFrame);
        System.out.println("Result is " + res.show());
        System.out.println("Time used: " + (System.currentTimeMillis() - start));
//        a.execute(globalFrame);
//        System.out.println("Hello, World!!!!" + c.execute(new Env()).show());
    }

    static void test() {
        Env a = new Env();
        Env b = a.extend("a", new IntValue(10));
        Env c = b.extend("b", new IntValue(101));
        assert c.lookUp("a").show() == "10";
        assert c.lookUp("b").show() == "101";
        c.lookUp("c");
    }

}