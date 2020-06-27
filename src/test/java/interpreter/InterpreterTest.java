package interpreter;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import visitor.MyExpBaseVisitor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    void checkBasic(){
        MyExpBaseVisitor visitor= new MyExpBaseVisitor();
        String initialString = "a = 1 + 6";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Interpreter interpreter= new Interpreter(visitor, targetStream);
        interpreter.run();
        System.out.println(interpreter.getVariablesState());
    }

    @Test
    void checkComplex(){
        MyExpBaseVisitor visitor= new MyExpBaseVisitor();
        StringBuilder commands = new StringBuilder();
        commands.append("a = 2").append('\n');
        commands.append("b = 3").append('\n');
        commands.append("c = 2 * 5").append('\n');
        commands.append("d = c - a").append('\n');
        commands.append("e = d/0").append('\n');
        String initialString = commands.toString();
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Interpreter interpreter= new Interpreter(visitor, targetStream);
        interpreter.run();
        System.out.println(interpreter.getVariablesState());
    }

    @Test
    void checkBigNum(){
        MyExpBaseVisitor visitor= new MyExpBaseVisitor();
        StringBuilder commands = new StringBuilder();
        commands.append("a = 2").append('\n');
        commands.append("b = 3").append('\n');
        commands.append("c = 2 * 5").append('\n');
        commands.append("d = c - a").append('\n');
        commands.append("e = d+100000000000").append('\n');
        String initialString = commands.toString();
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Interpreter interpreter= new Interpreter(visitor, targetStream);
        interpreter.run();
        System.out.println(interpreter.getVariablesState());
    }
}