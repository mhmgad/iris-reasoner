/*
 * Integrated Rule Inference System (IRIS):
 * An extensible rule inference system for datalog with extensions.
 * 
 * Copyright (C) 2009 Semantic Technology Institute (STI) Innsbruck, 
 * University of Innsbruck, Technikerstrasse 21a, 6020 Innsbruck, Austria.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.deri.iris.builtins.string;

import static org.deri.iris.factory.Factory.BASIC;

import org.deri.iris.api.basics.IPredicate;
import org.deri.iris.api.terms.IStringTerm;
import org.deri.iris.api.terms.ITerm;
import org.deri.iris.builtins.BooleanBuiltin;
import org.deri.iris.terms.StringTerm;

/**
 * Represents the RIF built-in func:starts-with as described in
 * http://www.w3.org/TR/xpath-functions/#func-starts-with. Restricts the value
 * of collation to Unicode code point collation
 * (http://www.w3.org/2005/xpath-functions/collation/codepoint).
 */
public class StringStartsWithWithoutCollationBuiltin extends BooleanBuiltin {

	private static final IPredicate PREDICATE = BASIC.createPredicate(
			"STRING_STARTS_WITH2", 2);

	/**
	 * Constructor.
	 * 
	 * @param terms The terms, where the term at the first position is the
	 *            <code>haystack</code> and the term at the second position is
	 *            the <code>needle</code>. The <code>haystack</code> is the
	 *            string being searched for the occurrence of the
	 *            <code>needle</code>. The <code>needle</code> is the string to
	 *            be searched for in the <code>haystack</code>.
	 * @throws IllegalArgumentException if one of the terms is {@code null}
	 */
	public StringStartsWithWithoutCollationBuiltin(ITerm... terms) {
		super(PREDICATE, terms);
	}

	@Override
	protected boolean computeResult(ITerm[] terms) {
		String haystack = null;
		String needle = null;

		if (terms[0] instanceof IStringTerm && terms[1] instanceof StringTerm) {
			haystack = ((IStringTerm) terms[0]).getValue();
			needle = ((IStringTerm) terms[1]).getValue();
		} else {
			return false;
		}

		return StringStartsWithBuiltin.startsWith(haystack, needle, null);
	}

}
