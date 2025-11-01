// Generated from VectorLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VectorLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VectorLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VectorLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(VectorLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatShow}
	 * labeled alternative in {@link VectorLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatShow(VectorLangParser.StatShowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link VectorLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(VectorLangParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVector}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVector(VectorLangParser.ExprVectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMult}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(VectorLangParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSum}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSum(VectorLangParser.ExprSumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValue(VectorLangParser.ExprValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIntern}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIntern(VectorLangParser.ExprInternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(VectorLangParser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(VectorLangParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link VectorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(VectorLangParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link VectorLangParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(VectorLangParser.VectorContext ctx);
}