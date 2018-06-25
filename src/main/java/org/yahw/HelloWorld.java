import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import org.yahw.*;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;


public class HelloWorld {

    public static void main(String[] args) {
        B521LangNode app, Ycomb, almostSum;
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

        app = new IfNode(
                (new isZeroNode(new IntNode(0))),
                new PredNode(new IntNode(20)),
                new IntNode(10)
        );

        Ycomb = new DefineNode("Y",
                new LambdaNode(
                        new VarNode("f"),
                        new AppNode(
                                new LambdaNode(
                                        new VarNode("z"),
                                    new AppNode(
                                            new VarNode("f"),
                                            new LambdaNode(
                                                    new VarNode("y"),
                                                    new AppNode(
                                                            new AppNode(new VarNode("z"), new VarNode("z")),
                                                            new VarNode("y"))))),
                            new LambdaNode(
                                    new VarNode("x"),
                                    new AppNode(
                                            new VarNode("f"),
                                            new LambdaNode(
                                                    new VarNode("y"),
                                                    new AppNode(
                                                            new AppNode(new VarNode("x"), new VarNode("x")),
                                                            new VarNode("y"))))))));

        DefineNode Ycomb2 = new DefineNode("Y2",
                new LambdaNode(
                        new VarNode("f2"),
                        new AppNode(
                                new LambdaNode(
                                        new VarNode("z2"),
                                        new AppNode(
                                                new VarNode("f2"),
                                                new LambdaNode(
                                                        new VarNode("y2"),
                                                        new AppNode(
                                                                new AppNode(new VarNode("z2"), new VarNode("z2")),
                                                                new VarNode("y2"))))),
                                new LambdaNode(
                                        new VarNode("x2"),
                                        new AppNode(
                                                new VarNode("f2"),
                                                new LambdaNode(
                                                        new VarNode("y2"),
                                                        new AppNode(
                                                                new AppNode(new VarNode("x2"), new VarNode("x2")),
                                                                new VarNode("y2"))))))));

        almostSum = new LambdaNode(new VarNode("self"),
                new LambdaNode(new VarNode("n"),
                        new IfNode(
                                new isZeroNode(new VarNode("n")),
                                new IntNode(0),
                                new PlusNode(new VarNode("n"),
                                        (new AppNode(new VarNode("self"), (new PredNode(new VarNode("n")))))))));

        B521LangNode almostSumInLoop = new LambdaNode(new VarNode("self1"),
                new LambdaNode(new VarNode("m"),
                        new IfNode(
                                new isZeroNode(new VarNode("m")),
                                new AppNode(new VarNode("sum"), new IntNode(500)),
                                new Begin2Node(new AppNode(new VarNode("sum"), new IntNode(500)),
                                        (new AppNode(new VarNode("self1"), (new PredNode(new VarNode("m")))))))));

        // TODO bug in name collision in variable lookup
        B521LangNode defineSum = new DefineNode("sum", new AppNode(new VarNode("Y"), almostSum));
        B521LangNode defineLoopSum = new DefineNode("loop-sum", new AppNode(new VarNode("Y2"), almostSumInLoop));
        app = new PrintlnNode(new AppNode(new VarNode("sum"),  new IntNode(500)));

        B521LangNode startNode = new DefineNode("start", new NowNode());
        B521LangNode end = new PrintlnNode(new MinusNode(new NowNode(), new VarNode("start")));
//        app = new AppNode(new AppNode(
//                almostSumIn,
//                new LambdaNode(new VarNode("x"),
//                        new PredNode(new VarNode("x")))), new IntNode(10));
        DefineNode def = new DefineNode("x", new IntNode(10));
        B521LangNode[] allNodes = {Ycomb, Ycomb2, defineSum, defineLoopSum,
                new AppNode(new VarNode("loop-sum"),  new IntNode(6)),
                startNode, app, end};
        B521LangRootNode rootNode = new B521LangRootNode(allNodes, globalFrameDescriptor);
        long start = System.currentTimeMillis();
        Value res = null;
        RootCallTarget rootTgtCall = Truffle.getRuntime().createCallTarget(rootNode);
        res = (Value) rootTgtCall.call(new Object[]{globalFrame.materialize()});

        //Value res = rootNode.execute(globalFrame);
        // System.out.println("Result is " + res.show());
        System.out.println("Time used: " + ((int) System.currentTimeMillis() - (int) start));
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