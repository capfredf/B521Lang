package org.yahw;

public class ValOfVisitor extends B521LangBaseVisitor<B521LangNode[]>{

    @Override
    public B521LangNode[] visitList(B521LangParser.ListContext ctx) {
        int size = ctx.form().size();
        B521LangNode e1, e2, e3, e4;
        String expr = ctx.form(0).getText();
        B521LangNode result;
        switch (expr) {
            case "define":
                VarNode sym = (VarNode) visit(ctx.form(1))[0];
                B521LangNode val = visit(ctx.form(2))[0];
                result = new DefineNode(sym, val);
                break;
            case "zero?":
                e1 = visit(ctx.form(1))[0];
                result = new isZeroNode(e1);
                break;
            case "+":
                e1 = visit(ctx.form(1))[0];
                e2 = visit(ctx.form(2))[0];
                result = new PlusNode(e1, e2);
                break;
            case "-":
                e1 = visit(ctx.form(1))[0];
                e2 = visit(ctx.form(2))[0];
                result = new MinusNode(e1, e2);
                break;
            case "<=":
                e1 = visit(ctx.form(1))[0];
                e2 = visit(ctx.form(2))[0];
                result = new LessThanEqual(e1, e2);
                break;
            case "if":
                B521LangNode cond = visit(ctx.form(1))[0];
                B521LangNode then = visit(ctx.form(2))[0];
                B521LangNode elset = visit(ctx.form(3))[0];
                result = new IfNode(cond, then, elset);
                break;
            case "lambda":
                B521LangParser.ListContext paramsCtx = (B521LangParser.ListContext) ctx.form(1);
                VarNode param = (VarNode) visit(paramsCtx.form(0))[0];
                B521LangNode body = visit(ctx.form(2))[0];
                result = new LambdaNode(param, body);
                break;
            default:
                B521LangNode rator = visit(ctx.form(0))[0];
                B521LangNode rand = visit(ctx.form(1))[0];
                result = new AppNode(rator, rand);
                break;
        }
        return new B521LangNode[]{result};
    }

    @Override
    public B521LangNode[] visitFile(B521LangParser.FileContext ctx) {
        int size = ctx.form().size();
        B521LangNode[] result = new B521LangNode[ size ];
        for (int i = 0 ; i < size ; i++) {
            result[i] = visit(ctx.form(i))[0];
        }
        return result;
    }

    @Override
    public VarNode[] visitSymbol(B521LangParser.SymbolContext ctx) {
        return new VarNode[]{new VarNode(ctx.getText())};
    }

    @Override
    public IntNode[] visitNumber(B521LangParser.NumberContext ctx) {
        return new IntNode[]{new IntNode(Integer.parseInt(ctx.getText()))};
    }
}
