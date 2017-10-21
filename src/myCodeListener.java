import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import static resources.Bytecode.*;


class myCodeListener extends JavaGrammarBaseListener {
    private int ind = 0;

    private static ArrayList<String> code = new ArrayList<>();
    private static HashMap<String, Integer> var = new HashMap<>();
    private static Stack<Integer> lineRef = new Stack<>();
    private static Stack<Integer> linePos = new Stack<>();
    private static Stack<Integer> forPos = new Stack<>();

    static ArrayList<String> getAnswer() {
        return code;
    }

    @Override
    public void exitCode(JavaGrammarParser.CodeContext ctx) {
        code.add(Return.V());
    }

    @Override
    public void exitNumber(JavaGrammarParser.NumberContext ctx) {
        if (ctx.NUMBER() != null) {
            code.add(Push.V() + " " + ctx.NUMBER().getText());
        } else if (ctx.VARIABLE() != null) {
            code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
        }
    }

    @Override
    public void exitExpression(JavaGrammarParser.ExpressionContext ctx) {
        if (ctx.getChildCount() > 1) {
            String sign = ctx.getChild(1).getText();
            switch (sign) {
                case "+":
                    code.add(Add.V());
                    break;
                case "-":
                    code.add(Sub.V());
                    break;
            }
        }
    }

    @Override
    public void exitMultiplication(JavaGrammarParser.MultiplicationContext ctx) {
        if (ctx.getChildCount() > 1) {
            String sign = ctx.getChild(1).getText();

            switch (sign) {
                case "*":
                    code.add(Mul.V());
                    break;
                case "/":
                    code.add(Div.V());
                    break;
                case "%":
                    code.add(Mod.V());
                    break;
            }
        }
    }

    @Override
    public void exitUnary(JavaGrammarParser.UnaryContext ctx) {
        if (ctx.getChildCount() > 1) {
            code.add(Invert.V());
        }
    }

    @Override
    public void exitBoolNumber(JavaGrammarParser.BoolNumberContext ctx) {
        if (ctx.BOOLCONST() != null) {
            String bool = ctx.BOOLCONST().getText();

            if (bool.equals("true")) {
                code.add(Push.V() + " 1");
            } else if (bool.equals("false")) {
                code.add(Push.V() + " 0");
            }
        } else if (ctx.VARIABLE()!= null) {
            int num = var.get(ctx.VARIABLE().getText());
            code.add(Push.V() + " " + num);
        }
    }

    @Override
    public void exitBoolExpression(JavaGrammarParser.BoolExpressionContext ctx) {
        if (ctx.getChildCount() > 1) {
            String sign = ctx.getChild(1).getText();
            switch (sign) {
                case "||":
                    code.add(Or.V());
                    break;
                case "^":
                    code.add(Xor.V());
                    break;
            }
        }
    }

    @Override
    public void exitBoolMultiplication(JavaGrammarParser.BoolMultiplicationContext ctx) {
        if (ctx.getChildCount() > 1) {
            String sign = ctx.getChild(1).getText();

            switch (sign) {
                case "&&":
                    code.add(And.V());
                    break;
            }
        }
    }

    @Override
    public void exitBoolUnary(JavaGrammarParser.BoolUnaryContext ctx) {
        if (ctx.getChildCount() > 1) {
            code.add(BoolInv.V());
        }
    }

    @Override
    public void exitBoolComparison(JavaGrammarParser.BoolComparisonContext ctx) {
        String sign = ctx.getChild(1).getText();

        switch (sign) {
            case "==":
                code.add(Eq.V());
                break;
            case "!=":
                code.add(NE.V());
                break;
            case "<":
                code.add(LT.V());
                break;
            case ">":
                code.add(GT.V());
                break;
            case "<=":
                code.add(LE.V());
                break;
            case ">=":
                code.add(GE.V());
                break;
        }
    }

    @Override
    public void exitLeftIncrement(JavaGrammarParser.LeftIncrementContext ctx) {
        code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
        code.add(Push.V() + " 1");
        if (ctx.getChild(0).getText().equals("++")) {
            code.add(Add.V());
        } else if (ctx.getChild(0).getText().equals("--")) {
            code.add(Sub.V());
        }
        code.add(Store.V() + " " + var.get(ctx.VARIABLE().getText()));
        code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
    }

    @Override
    public void exitRightIncrement(JavaGrammarParser.RightIncrementContext ctx) {
        code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
        code.add(Clone.V());
        code.add(Push.V() + " 1");
        if (ctx.getChild(1).getText().equals("++")) {
            code.add(Add.V());
        } else if (ctx.getChild(1).getText().equals("--")) {
            code.add(Sub.V());
        }
        code.add(Store.V() + " " + var.get(ctx.VARIABLE().getText()));
    }

    @Override
    public void exitExpressionAssign(JavaGrammarParser.ExpressionAssignContext ctx) {
        code.add(Store.V() + " " + var.get(ctx.VARIABLE().getText()));
        code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
    }

    @Override
    public void exitOperationAssign(JavaGrammarParser.OperationAssignContext ctx) {
        code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
        String op = ctx.getChild(1).getText();
        switch (op) {
            case "+=":
                code.add(Add.V());
                break;
            case "-=":
                code.add(Sub.V());
                break;
            case "*=":
                code.add(Mul.V());
                break;
            case "/=":
                code.add(Div.V());
                break;
            case "%=":
                code.add(Mod.V());
                break;
        }
        code.add(Store.V() + " " + var.get(ctx.VARIABLE().getText()));
        code.add(Load.V() + " " + var.get(ctx.VARIABLE().getText()));
    }

    @Override
    public void enterDeclaration(JavaGrammarParser.DeclarationContext ctx) {
        String varName = ctx.VARIABLE().getText();
        var.put(varName, ind++);
    }

    @Override
    public void exitDeclaration(JavaGrammarParser.DeclarationContext ctx) {
        if (ctx.getChildCount() > 3) {
            code.add(Store.V() + " " + var.get(ctx.VARIABLE().getText()));
        }
    }

    @Override
    public void enterForAssign(JavaGrammarParser.ForAssignContext ctx) {
        code.add(Load.V() + " " + ind);
        forPos.push(code.size());
    }

    @Override
    public void exitForAssign(JavaGrammarParser.ForAssignContext ctx) {
        int ref = code.size() + forPos.size() + 1; // adding goto after body;
        code.add(forPos.pop(), IfEZ.V() + " " + ref);
    }

    @Override
    public void exitBody(JavaGrammarParser.BodyContext ctx) {
        code.add(Push.V() + " 1");
        code.add(Store.V() + " " + ind++);
        int ref = code.size() + linePos.size() + 1; // adding goto after body;
        code.add(linePos.pop(), IfEZ.V() + " " + ref);
        code.add(Jump.V() + " " + lineRef.pop());
    }

    @Override
    public void enterCondition(JavaGrammarParser.ConditionContext ctx) {
        code.add(Push.V() + " 0");
        code.add(Store.V() + " " + ind++);
        lineRef.push(code.size());
    }

    @Override
    public void exitCondition(JavaGrammarParser.ConditionContext ctx) {

        linePos.push(code.size());
    }

    @Override
    public void enterThenPart(JavaGrammarParser.ThenPartContext ctx) {
        linePos.push(code.size());
    }

    @Override
    public void exitThenPart(JavaGrammarParser.ThenPartContext ctx) {
        int ref = code.size() + linePos.size();

        if (ctx.getParent().getChildCount() > 5) {
            ref++;
        }

        code.add(linePos.pop(), IfEZ.V() + " " + ref);
    }

    @Override
    public void enterElsePart(JavaGrammarParser.ElsePartContext ctx) {
        linePos.push(code.size());
    }

    @Override
    public void exitElsePart(JavaGrammarParser.ElsePartContext ctx) {
        int ref = code.size() + linePos.size();
        code.add(linePos.pop(), Jump.V() + " " + ref);
    }

    @Override
    public void exitPrint(JavaGrammarParser.PrintContext ctx) {
        code.add(Print.V());
    }

    @Override
    public void exitRead(JavaGrammarParser.ReadContext ctx) {
        code.add(Read.V());
    }
}