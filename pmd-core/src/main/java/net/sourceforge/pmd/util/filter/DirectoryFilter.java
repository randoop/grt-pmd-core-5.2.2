/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.util.filter;

import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import java.io.File;

/**
 * Directory filter.
 */
public final class DirectoryFilter implements Filter<File> {
	public static final DirectoryFilter INSTANCE = new DirectoryFilter();

	@SideEffectFree
	private DirectoryFilter() {
	}

	@SideEffectFree
	public boolean filter(File file) {
		return file.isDirectory();
	}
	
	@Pure
	public String toString() {
	    return "is Directory";
	}
}
