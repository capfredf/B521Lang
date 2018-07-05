// Generated from /Users/phay/IdeaProjects/vanilla-b521-lang/src/org/yahw/B521Lang.g4 by ANTLR 4.7
package org.yahw;



import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link B521LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface B521LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link B521LangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(B521LangParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code list}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(B521LangParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quote}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(B521LangParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(B521LangParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(B521LangParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(B521LangParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code symbol}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(B521LangParser.SymbolContext ctx);
}