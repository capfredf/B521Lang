import org.yahw.*;


public class HelloWorld {
    public static void main(String[] args) {
        B521LangNode a, b, c, body, lambda, app;
//        test();
//        a = new IntNode(10);
        a = new VarNode("x");
        b = new IntNode(10);
        body = new PlusNode(a, b);
        lambda = new LambdaNode("x", body);
        c = new AppNode(lambda, new IntNode(10));
        System.out.println("Hello, World!!!!" + c.eval(new Env()).show());
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