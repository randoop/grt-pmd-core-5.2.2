/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.util.filter;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import java.util.ArrayList;
import java.util.List;

/**
 * A base class for Filters which implements behavior using a List of other
 * Filters.
 * 
 * @param <T>
 *            The underlying type on which the filter applies.
 */
public abstract class AbstractCompoundFilter<T> implements Filter<T> {

	protected List<Filter<T>> filters;

	@SideEffectFree
	public AbstractCompoundFilter() {
		filters = new ArrayList<Filter<T>>(2);
	}

	@Impure
	public AbstractCompoundFilter(Filter<T>... filters) {
		this.filters = new ArrayList<Filter<T>>(filters.length);
		for (Filter<T> filter : filters) {
			this.filters.add(filter);
		}
	}

	@Pure
	public List<Filter<T>> getFilters() {
		return filters;
	}

	@Impure
	public void setFilters(List<Filter<T>> filters) {
		this.filters = filters;
	}

	@Impure
	public void addFilter(Filter<T> filter) {
		filters.add(filter);
	}

	@Pure
	protected abstract String getOperator();

	@Impure
	public String toString() {
		
		if (filters.isEmpty()) { return "()"; }
		
		StringBuilder builder = new StringBuilder();
		builder.append('(').append(filters.get(0));
		
		for (int i = 1; i < filters.size(); i++) {
			builder.append(' ').append(getOperator()).append(' ');
			builder.append(filters.get(i));
		}
		builder.append(')');
		return builder.toString();
	}
}
