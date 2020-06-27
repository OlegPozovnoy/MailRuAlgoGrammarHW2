package visitor;

import autogenerated.ExpBaseVisitor;
import autogenerated.ExpParser;
import complex.Complex;
import exception.NumberIsTooBig;

import java.util.HashMap;
import java.util.Map;

public class MyExpBaseVisitor extends ExpBaseVisitor<Complex> {
    public Map<String, Complex> vars = new HashMap<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (String k : vars.keySet()) {
            result.append(k).append(" = ").append(vars.get(k)).append('\n');
        }
        return result.toString();
    }

    public Map<String, Complex> getVarsState() {
        return vars;
    }

    //stmt: v=Variable Eq e=expr;
    @Override
    public Complex visitStmt(ExpParser.StmtContext ctx) {
        String var = ctx.v.getText();
        Complex value = visit(ctx.e);
        vars.put(var, value);
        return Complex.ONE;
    }

    //expr : (l1=lterm r1=rsum | l2=lterm);
    @Override
    public Complex visitExpr(ExpParser.ExprContext ctx) {
        if (ctx.l1 != null) {
            Complex c1= visit(ctx.l1);
            Complex c2 = visit(ctx.r1);
            return c1.add(c2);
        } else {
            Complex c1= visit(ctx.l2);
            return c1;
        }
    }

    // rsum : (Plus e1=expr|Minus e2=expr);
    @Override
    public Complex visitRsum(ExpParser.RsumContext ctx) {
        if (ctx.e1 != null) {
            return visit(ctx.e1);
        } else {
            Complex tmp = visit(ctx.e2);
            return tmp.negate();
        }
    }

    // lterm : (t1=terminate p1=multdiv | t2=terminate);
    @Override
    public Complex visitLterm(ExpParser.LtermContext ctx) {
        if (ctx.p1 != null) {
            return visit(ctx.t1).mult(visit(ctx.p1));
        } else {
            return visit(ctx.t2);
        }
    }

    //multdiv : (Mult l=lterm | Div d=lterm);
    @Override
    public Complex visitMultdiv(ExpParser.MultdivContext ctx) {
        Complex div = visitChildren(ctx);
        if (ctx.l != null)
            return div;
        else //if (ctx.d != null)
            return Complex.ONE.divide(div);
    }

    //terminate :  (Plus t1=terminate | Minus t2=terminate | v=Variable | n=Number | c=complex |OBracket e=expr CBracker);
    @Override
    public Complex visitTerminate(ExpParser.TerminateContext ctx) {
        if (ctx.t1 != null) {
            return visit(ctx.t1);//Complex.fromDouble(Double.parseDouble(ctx.t1.getText()));
        } else if (ctx.t2 != null) {
            return visit(ctx.t2).negate();//Complex.fromDouble(-Double.parseDouble(ctx.t2.getText()));
        } else if (ctx.v != null) {
            return vars.get(ctx.v.getText());
        } else if (ctx.n != null) {
            checkNumLength(ctx.n.getText());
            return Complex.fromDouble(Double.parseDouble(ctx.n.getText()));
        } else if (ctx.expr() != null) {
            return visit(ctx.expr());
        } else if (ctx.c != null) {
            return visit(ctx.c);
        }
        return Complex.ONE;
    }

    //signed_number: (Plus n1=Number| Minus n2=Number | n3=Number);
    @Override
    public Complex visitSigned_number(ExpParser.Signed_numberContext ctx) {
        if (ctx.n1 != null) {
            checkNumLength(ctx.n1.getText());
            return Complex.fromDouble(Double.parseDouble(ctx.n1.getText()));
        } else if(ctx.n2 != null) {
            checkNumLength(ctx.n2.getText());
            return Complex.fromDouble(-Double.parseDouble(ctx.n2.getText()));
        } else{
            checkNumLength(ctx.n3.getText());
           return Complex.fromDouble(Double.parseDouble(ctx.n3.getText()));
        }
    }

    private void checkNumLength(String str){
        if (str.length()>10)
            throw new NumberIsTooBig("Number " + str + " is too big to process.\n" +
                    "The interpreter may process only numbers 10 characters long");
    }

    //complex: RE re=signed_number IM im=signed_number;
    @Override
    public Complex visitComplex(ExpParser.ComplexContext ctx) {
        Complex re = visit(ctx.re);
        Complex im = visit(ctx.im);

        return new Complex(re.re, im.re);
    }
}
