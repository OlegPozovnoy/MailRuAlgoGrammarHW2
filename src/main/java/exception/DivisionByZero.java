package exception;

public class DivisionByZero extends InterpreterException{
    public DivisionByZero(){
        super("Division by Zero occured");
    }
}
