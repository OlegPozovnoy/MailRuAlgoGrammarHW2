package autogenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(ExpParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(ExpParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExpParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExpParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#lterm}.
	 * @param ctx the parse tree
	 */
	void enterLterm(ExpParser.LtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#lterm}.
	 * @param ctx the parse tree
	 */
	void exitLterm(ExpParser.LtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#rsum}.
	 * @param ctx the parse tree
	 */
	void enterRsum(ExpParser.RsumContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#rsum}.
	 * @param ctx the parse tree
	 */
	void exitRsum(ExpParser.RsumContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#multdiv}.
	 * @param ctx the parse tree
	 */
	void enterMultdiv(ExpParser.MultdivContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#multdiv}.
	 * @param ctx the parse tree
	 */
	void exitMultdiv(ExpParser.MultdivContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#terminate}.
	 * @param ctx the parse tree
	 */
	void enterTerminate(ExpParser.TerminateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#terminate}.
	 * @param ctx the parse tree
	 */
	void exitTerminate(ExpParser.TerminateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#signed_number}.
	 * @param ctx the parse tree
	 */
	void enterSigned_number(ExpParser.Signed_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#signed_number}.
	 * @param ctx the parse tree
	 */
	void exitSigned_number(ExpParser.Signed_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#complex}.
	 * @param ctx the parse tree
	 */
	void enterComplex(ExpParser.ComplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#complex}.
	 * @param ctx the parse tree
	 */
	void exitComplex(ExpParser.ComplexContext ctx);
}