// Generated from TupleNum.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TupleNumParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TupleNumVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TupleNumParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TupleNumParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TupleNumParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(TupleNumParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link TupleNumParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(TupleNumParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link TupleNumParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(TupleNumParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRead(TupleNumParser.ExprReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTuple}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTuple(TupleNumParser.ExprTupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprComma}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComma(TupleNumParser.ExprCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOperation}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOperation(TupleNumParser.ExprOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSlice}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSlice(TupleNumParser.ExprSliceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEmpty}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEmpty(TupleNumParser.ExprEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnary(TupleNumParser.ExprUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(TupleNumParser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(TupleNumParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSignal}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSignal(TupleNumParser.ExprSignalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(TupleNumParser.ExprIDContext ctx);
}