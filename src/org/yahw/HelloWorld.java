import org.yahw.*;


public class HelloWorld {
    public static void main(String[] args) {
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
        B521LangNode almostSum = new LambdaNode(new VarNode("self"),
                new LambdaNode(new VarNode("n"),
                        new IfNode(
                                new isZeroNode(new VarNode("n")),
                                new IntNode(0),
                                new PlusNode(new VarNode("n"),
                                        (new AppNode(new VarNode("self"), (new PredNode(new VarNode("n")))))))));

        app = new AppNode(new AppNode(Ycomb, almostSum), new IntNode(1000));
        long start = System.currentTimeMillis();
        System.out.println("Result is " + app.eval(new Env()).show());
        System.out.println("Time used: " + (System.currentTimeMillis() - start));
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