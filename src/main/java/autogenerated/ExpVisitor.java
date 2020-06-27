package autogenerated;
// Generated from Exp.g by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(ExpParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExpParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#lterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLterm(ExpParser.LtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#rsum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRsum(ExpParser.RsumContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#multdiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultdiv(ExpParser.MultdivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#terminate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminate(ExpParser.TerminateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#signed_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_number(ExpParser.Signed_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#complex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex(ExpParser.ComplexContext ctx);
}