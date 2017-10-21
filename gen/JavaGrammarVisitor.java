// Generated from /home/mikhailkongoev/IdeaProjects/MT_hw3/JavaGrammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(JavaGrammarParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(JavaGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(JavaGrammarParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(JavaGrammarParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(JavaGrammarParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolNumber(JavaGrammarParser.BoolNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolAtom(JavaGrammarParser.BoolAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolUnary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolUnary(JavaGrammarParser.BoolUnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(JavaGrammarParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolMultiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolMultiplication(JavaGrammarParser.BoolMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolComparison(JavaGrammarParser.BoolComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(JavaGrammarParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(JavaGrammarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#expressionAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssign(JavaGrammarParser.ExpressionAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#operationAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationAssign(JavaGrammarParser.OperationAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#leftIncrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftIncrement(JavaGrammarParser.LeftIncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#rightIncrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightIncrement(JavaGrammarParser.RightIncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(JavaGrammarParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(JavaGrammarParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#forAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAssign(JavaGrammarParser.ForAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(JavaGrammarParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(JavaGrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(JavaGrammarParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(JavaGrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#thenPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenPart(JavaGrammarParser.ThenPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePart(JavaGrammarParser.ElsePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(JavaGrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(JavaGrammarParser.ReadContext ctx);
}