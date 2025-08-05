/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.util.filter;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.Impure;

/**
 * A logical AND of a list of Filters.  This implementation is short circuiting.
 * 
 * @param <T>
 *            The underlying type on which the filter applies.
 */
public class AndFilter<T> extends AbstractCompoundFilter<T> {

	@SideEffectFree
	@Impure
	public AndFilter() {
		super();
	}

	@Impure
	public AndFilter(Filter<T>... filters) {
		super(filters);
	}

	@Impure
	public boolean filter(T obj) {
		boolean match = true;
		for (Filter<T> filter : filters) {
			if (!filter.filter(obj)) {
				match = false;
				break;
			}
		}
		return match;
	}

	@Pure
	@Override
	protected String getOperator() {
		return "and";
	}
}
