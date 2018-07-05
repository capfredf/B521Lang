// Generated from /Users/phay/IdeaProjects/vanilla-b521-lang/src/org/yahw/B521Lang.g4 by ANTLR 4.7
package org.yahw;



import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link B521LangParser}.
 */
public interface B521LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link B521LangParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(B521LangParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link B521LangParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(B521LangParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code list}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void enterList(B521LangParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code list}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void exitList(B521LangParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quote}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void enterQuote(B521LangParser.QuoteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quote}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void exitQuote(B521LangParser.QuoteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void enterNumber(B521LangParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void exitNumber(B521LangParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void enterBool(B521LangParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void exitBool(B521LangParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void enterString(B521LangParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void exitString(B521LangParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code symbol}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(B521LangParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code symbol}
	 * labeled alternative in {@link B521LangParser#form}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(B521LangParser.SymbolContext ctx);
}