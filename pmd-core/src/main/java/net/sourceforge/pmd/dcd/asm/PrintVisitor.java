/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.dcd.asm;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.SideEffectFree;

public class PrintVisitor {

	private static final String INDENT = "\t";

	private final int level;

	@SideEffectFree
	@Impure
	public PrintVisitor() {
		this(0);
	}

	@SideEffectFree
	@Impure
	public PrintVisitor(PrintVisitor parent) {
		this(parent.level + 2);
	}

	@SideEffectFree
	public PrintVisitor(int level) {
		this.level = level;
	}

	@Impure
	public void println(String s) {
		println(this.level, s);
	}

	@Impure
	public void printlnIndent(String s) {
		println(this.level + 1, s);
	}

	@Impure
	private void println(int level, String s) {
		for (int i = 0; i < level; i++) {
			System.out.print(INDENT);
		}
		System.out.println(s);
	}
}
