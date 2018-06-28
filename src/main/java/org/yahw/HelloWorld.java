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
//        a = VarNodeGen.create("x");
//        b = VarNodeGen.create("x");
//        body = new PlusNode(a, b);
//        lambda = new LambdaNode(VarNodeGen.create("x"), body);
//        outter = new LambdaNode(VarNodeGen.create("x"), lambda);
//        c = new AppNode(outter, new IntNode(10));
//        app = new AppNode(c, new IntNode(30));
        app = new AppNode(
                new AppNode(
                        new LambdaNode(VarNodeGen.create("x"),
                                new LambdaNode(VarNodeGen.create("x"),
                                        PlusNodeFactory.create(VarNodeGen.create("x"), VarNodeGen.create("x"))
                                )
                        ),
                        new IntNode(10)
                ),
                new IntNode(30)
        );

        app = new AppNode(
                    new LambdaNode(VarNodeGen.create("x"),
                            new AppNode(
                                    new LambdaNode(VarNodeGen.create("x"),
                                            PlusNodeFactory.create(VarNodeGen.create("x"), VarNodeGen.create("x"))
                                    ),
                                    new IntNode(10)
                            )
                        ),
                    new IntNode(30)
        );

//        app = new IfNode(
//                (new isZeroNode(new IntNode(0))),
//                new PredNode(new IntNode(20)),
//                new IntNode(10)
//        );

        Ycomb = new DefineNode("Y",
                new LambdaNode(
                        VarNodeGen.create("f"),
                        new AppNode(
                                new LambdaNode(
                                        VarNodeGen.create("z"),
                                    new AppNode(
                                            VarNodeGen.create("f"),
                                            new LambdaNode(
                                                    VarNodeGen.create("y"),
                                                    new AppNode(
                                                            new AppNode(VarNodeGen.create("z"), VarNodeGen.create("z")),
                                                            VarNodeGen.create("y"))))),
                            new LambdaNode(
                                    VarNodeGen.create("x"),
                                    new AppNode(
                                            VarNodeGen.create("f"),
                                            new LambdaNode(
                                                    VarNodeGen.create("y"),
                                                    new AppNode(
                                                            new AppNode(VarNodeGen.create("x"), VarNodeGen.create("x")),
                                                            VarNodeGen.create("y"))))))));

        DefineNode Ycomb2 = new DefineNode("Y2",
                new LambdaNode(
                        VarNodeGen.create("f2"),
                        new AppNode(
                                new LambdaNode(
                                        VarNodeGen.create("z2"),
                                        new AppNode(
                                                VarNodeGen.create("f2"),
                                                new LambdaNode(
                                                        VarNodeGen.create("y2"),
                                                        new AppNode(
                                                                new AppNode(VarNodeGen.create("z2"), VarNodeGen.create("z2")),
                                                                VarNodeGen.create("y2"))))),
                                new LambdaNode(
                                        VarNodeGen.create("x2"),
                                        new AppNode(
                                                VarNodeGen.create("f2"),
                                                new LambdaNode(
                                                        VarNodeGen.create("y2"),
                                                        new AppNode(
                                                                new AppNode(VarNodeGen.create("x2"), VarNodeGen.create("x2")),
                                                                VarNodeGen.create("y2"))))))));

        almostSum = new LambdaNode(VarNodeGen.create("self"),
                new LambdaNode(VarNodeGen.create("n"),
                        new IfNode(
                                new LessThanEqual(VarNodeGen.create("n"), new IntNode(1)),
                                VarNodeGen.create("n"),
//                                new PlusNode(VarNodeGen.create("n"), (new AppNode(VarNodeGen.create("self"), (new PredNode(VarNodeGen.create("n")))))))));
                                PlusNodeFactory.create((new AppNode(VarNodeGen.create("self"), (MinusNodeFactory.create(VarNodeGen.create("n"), new IntNode(2))))),
                                        (new AppNode(VarNodeGen.create("self"), (new PredNode(VarNodeGen.create("n")))))))));

        B521LangNode almostSumInLoop = new LambdaNode(VarNodeGen.create("self1"),
                new LambdaNode(VarNodeGen.create("m"),
                        new IfNode(
                                new isZeroNode(VarNodeGen.create("m")),
                                new AppNode(VarNodeGen.create("sum"), new IntNode(25)),
                                new Begin2Node(new AppNode(VarNodeGen.create("sum"), new IntNode(25)),
                                        (new AppNode(VarNodeGen.create("self1"), (new PredNode(VarNodeGen.create("m")))))))));

        // TODO bug in name collision in variable lookup
        B521LangNode defineSum = new DefineNode("sum", new AppNode(VarNodeGen.create("Y"), almostSum));
        B521LangNode defineLoopSum = new DefineNode("loop-sum", new AppNode(VarNodeGen.create("Y2"), almostSumInLoop));
        app = new PrintlnNode(new AppNode(VarNodeGen.create("sum"),  new IntNode(25)));

        B521LangNode startNode = new DefineNode("start", new NowNode());
        B521LangNode end = new PrintlnNode(MinusNodeFactory.create(new NowNode(), VarNodeGen.create("start")));
//        app = new AppNode(new AppNode(
//                almostSum,
//                new LambdaNode(VarNodeGen.create("x"),
//                        new PredNode(VarNodeGen.create("x")))), new IntNode(10));
//        DefineNode def = new DefineNode("x", new IntNode(10));
        B521LangNode[] allNodes = {Ycomb, Ycomb2, defineSum,
                defineLoopSum,
                new AppNode(VarNodeGen.create("loop-sum"),  new IntNode(6)),
                startNode, app, end};
//        B521LangNode[] allNodes = {app};
        B521LangRootNode rootNode = new B521LangRootNode(allNodes, globalFrameDescriptor);
        long start = System.currentTimeMillis();
        Object res = null;
        RootCallTarget rootTgtCall = Truffle.getRuntime().createCallTarget(rootNode);
        res = rootTgtCall.call(new Object[]{globalFrame.materialize()});

        //Value res = rootNode.execute(globalFrame);
        System.out.println("Result is " + res);
        System.out.println("Time used: " + ((int) System.currentTimeMillis() - (int) start));
//        a.execute(globalFrame);
//        System.out.println("Hello, World!!!!" + c.execute(new Env()).show());
    }
//
//    static void test() {
//        Env a = new Env();
//        Env b = a.extend("a", 10);
//        Env c = b.extend("b", 101);
//        assert c.lookUp("a").show() == "10";
//        assert c.lookUp("b").show() == "101";
//        c.lookUp("c");
//    }

}