import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.yahw.*;

import java.io.IOException;


public class HelloWorld {
    public static void main(String[] args) {
        B521LangNode[] nodes = main2();
        B521LangRootNode rootNode = new B521LangRootNode(nodes);
        System.out.println(rootNode.eval(new Env()));
    }
    private void main1() {
        B521LangNode a, b, c, body, lambda, app;
//        test();
//        a = new IntNode(10);
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
        B521LangNode almostSum = new LambdaNode(new VarNode("self"),
                new LambdaNode(new VarNode("n"),
                        new IfNode(
                                new LessThanEqual(new VarNode("n"), new IntNode(1)),
                                new VarNode("n"),
                                new PlusNode((new AppNode(new VarNode("self"), (new MinusNode(new VarNode("n"), new IntNode(2))))),
                                        (new AppNode(new VarNode("self"), (new PredNode(new VarNode("n")))))))));

        B521LangNode almostSumInLoop = new LambdaNode(new VarNode("self1"),
                new LambdaNode(new VarNode("m"),
                        new IfNode(
                                new isZeroNode(new VarNode("m")),
                                new AppNode(new VarNode("sum"), new IntNode(25)),
                                new Begin2Node(new AppNode(new VarNode("sum"), new IntNode(25)),
                                        (new AppNode(new VarNode("self1"), (new PredNode(new VarNode("m")))))))));

        B521LangNode Ycomb = new LambdaNode(
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
                                                                new VarNode("y")))))));

        LetNode Ycomb2 =
                new LetNode("Y1", Ycomb,
                        new LetNode("sum", new AppNode(new VarNode("Y1"), almostSum),
                                new LetNode("Y2",
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
                                                                                                new VarNode("y2"))))))),
                                                new LetNode("loop-sum", new AppNode(new VarNode("Y2"), almostSumInLoop),
                                                        new LetNode("start", new NowNode(),
                                                                new Begin2Node(new PrintlnNode(new AppNode(new VarNode("sum"), new IntNode(25))),
                                                                        new PrintlnNode(new MinusNode(new NowNode(), new VarNode("start")))))))));


        B521LangRootNode rootNode = new B521LangRootNode(new B521LangNode[]{Ycomb2});
        rootNode.eval(new Env());
    }

    static void test() {
        Env a = new Env();
        Env b = a.extend("a", new IntValue(10));
        Env c = b.extend("b", new IntValue(101));
        assert c.lookUp("a").toString() == "10";
        assert c.lookUp("b").toString() == "101";
        c.lookUp("c");
    }

    static B521LangNode[] main2() {
        B521LangLexer lexer = null;
        try {
            lexer = new B521LangLexer( CharStreams.fromFileName("/Users/phay/IdeaProjects/vanilla-b521-lang/test.b521"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        B521LangParser parser = new B521LangParser( tokens );
        ParseTree tree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk();
        ValOfVisitor vv = new ValOfVisitor();
        return vv.visit(tree);
    }

}