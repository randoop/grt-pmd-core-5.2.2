/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.util.filter;
import org.checkerframework.dataflow.qual.Impure;

/**
 * A Filter interface, used for filtering arbitrary objects.
 * 
 * @param <T>
 *            The underlying type on which the filter applies.
 */
public interface Filter<T> {
	@Impure
	boolean filter(T obj);
}
