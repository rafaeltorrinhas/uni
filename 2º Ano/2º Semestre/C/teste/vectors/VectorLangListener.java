// Generated from VectorLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VectorLangParser}.
 */
public interface VectorLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VectorLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(VectorLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link VectorLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(VectorLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatShow}
	 * labeled alternative in {@link VectorLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatShow(VectorLangParser.StatShowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatShow}
	 * labeled alternative in {@link VectorLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatShow(VectorLangParser.StatShowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link VectorLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(VectorLangParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link VectorLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(VectorLangParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVector}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVector(VectorLangParser.ExprVectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVector}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVector(VectorLangParser.ExprVectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMult}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(VectorLangParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMult}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(VectorLangParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSum}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSum(VectorLangParser.ExprSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSum}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSum(VectorLangParser.ExprSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprValue(VectorLangParser.ExprValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprValue(VectorLangParser.ExprValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIntern}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIntern(VectorLangParser.ExprInternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIntern}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIntern(VectorLangParser.ExprInternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(VectorLangParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(VectorLangParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesis(VectorLangParser.ExprParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesis(VectorLangParser.ExprParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(VectorLangParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(VectorLangParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link VectorLangParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(VectorLangParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link VectorLangParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(VectorLangParser.VectorContext ctx);
}