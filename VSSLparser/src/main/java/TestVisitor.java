// Generated from D:/Klasser/Discrete Mathematics/VSSLparser/src/main\Test.g4 by ANTLR 4.8
package main.java;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(TestParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(TestParser.NameContext ctx);
}