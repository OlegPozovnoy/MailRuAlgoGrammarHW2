package interpreter;

import autogenerated.ExpLexer;
import autogenerated.ExpParser;
import complex.Complex;
import exception.InterpreterException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.MyExpBaseVisitor;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Interpreter implements Runnable {
    private MyExpBaseVisitor visitor;
    private InputStream inputStream;

    Interpreter(MyExpBaseVisitor visitor, InputStream inputStream) {
        this.visitor = visitor;
        this.inputStream = inputStream;
    }

    private ParseTree prepareLexer(String str) throws InterpreterException {
        CharStream input = CharStreams.fromString(str);
        ExpLexer lexer = new ExpLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        MyExpBaseVisitor visitor = new MyExpBaseVisitor();
        return parser.stmt();
    }

    public Map<String, Complex> getVariablesState() {
        return visitor.getVarsState();
    }

    @Override
    public void run() {
        String nextCommand ="";
        try {
            InputReader in = new InputReader(inputStream);
            nextCommand = in.next();
            while (nextCommand.length() > 0) {
                visitor.visit(prepareLexer(nextCommand));
                nextCommand = in.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterpreterException e) {
            System.out.println("Statement " + nextCommand + " processing failed");
            System.out.println("Interpreter state:");
            System.out.println(visitor);
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static class InputReader {
        public BufferedReader reader;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String next() throws IOException {
            String str = reader.readLine();
            if (str == null)
                return "";
            else
                return str;
        }
    }
}