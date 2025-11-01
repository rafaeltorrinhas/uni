// Generated from TupleNum.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TupleNumParser}.
 */
public interface TupleNumListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TupleNumParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TupleNumParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TupleNumParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TupleNumParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TupleNumParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(TupleNumParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TupleNumParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(TupleNumParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link TupleNumParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(TupleNumParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link TupleNumParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(TupleNumParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link TupleNumParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(TupleNumParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link TupleNumParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(TupleNumParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRead(TupleNumParser.ExprReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRead(TupleNumParser.ExprReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprTuple}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprTuple(TupleNumParser.ExprTupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprTuple}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprTuple(TupleNumParser.ExprTupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprComma}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprComma(TupleNumParser.ExprCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprComma}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprComma(TupleNumParser.ExprCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOperation}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOperation(TupleNumParser.ExprOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOperation}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOperation(TupleNumParser.ExprOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSlice}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSlice(TupleNumParser.ExprSliceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSlice}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSlice(TupleNumParser.ExprSliceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEmpty}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprEmpty(TupleNumParser.ExprEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEmpty}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprEmpty(TupleNumParser.ExprEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(TupleNumParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(TupleNumParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(TupleNumParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(TupleNumParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesis(TupleNumParser.ExprParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesis(TupleNumParser.ExprParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSignal}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSignal(TupleNumParser.ExprSignalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSignal}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSignal(TupleNumParser.ExprSignalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(TupleNumParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link TupleNumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(TupleNumParser.ExprIDContext ctx);
}