/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.util.filter;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;

/**
 * A base class for Filters which implements behavior using delegation
 * to an underlying filter.
 * 
 * @param <T>
 *            The underlying type on which the filter applies.
 */
public abstract class AbstractDelegateFilter<T> implements Filter<T> {
	protected Filter<T> filter;

	@SideEffectFree
	public AbstractDelegateFilter() {
	}

	@SideEffectFree
	public AbstractDelegateFilter(Filter<T> filter) {
		this.filter = filter;
	}

	@Pure
	public Filter<T> getFilter() {
		return filter;
	}

	@Impure
	public void setFilter(Filter<T> filter) {
		this.filter = filter;
	}

	// Subclass should override to do something other the simply delegate.
	@Impure
	public boolean filter(T obj) {
		return filter.filter(obj);
	}

	// Subclass should override to do something other the simply delegate.
	@SideEffectFree
	public String toString() {
		return filter.toString();
	}
}
