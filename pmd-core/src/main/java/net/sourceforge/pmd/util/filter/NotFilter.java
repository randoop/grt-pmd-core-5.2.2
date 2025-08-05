/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.util.filter;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.Impure;

/**
 * A logical NEGATION of a Filter.
 * 
 * @param <T>
 *            The underlying type on which the filter applies.
 */
public class NotFilter<T> extends AbstractDelegateFilter<T> {
	@SideEffectFree
	@Impure
	public NotFilter() {
		super();
	}

	@SideEffectFree
	@Impure
	public NotFilter(Filter<T> filter) {
		super(filter);
	}

	@Impure
	public boolean filter(T obj) {
		return !filter.filter(obj);
	}

	@Pure
	public String toString() {
		return "not (" + filter + ")";
	}
}
