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
package org.deri.iris.builtins.date;

import static org.deri.iris.factory.Factory.TERM;
import junit.framework.TestCase;

import org.deri.iris.EvaluationException;
import org.deri.iris.api.basics.ITuple;
import org.deri.iris.api.terms.ITerm;
import org.deri.iris.factory.Factory;

/**
 * Test for TimezonePartBuiltin.
 */
public class TimezonePartBuiltinTest extends TestCase {

	private static ITerm X = Factory.TERM.createVariable("X");

	private static final ITerm Y = TERM.createVariable("Y");

	public TimezonePartBuiltinTest(String name) {
		super(name);
	}

	public void testTimezoneFromTime() throws EvaluationException {
		ITerm time = Factory.CONCRETE.createTime(8, 55, 23, -3, -30);
		ITerm duration = Factory.CONCRETE.createDuration(false, 0, 0, 0, 3, 30,
				0);
		check(duration, time);

		time = Factory.CONCRETE.createTime(8, 55, 23, 2, 0);
		duration = Factory.CONCRETE.createDuration(true, 0, 0, 0, 2, 0, 0);
		check(duration, time);
	}

	public void testTimezoneFromDateTime() throws EvaluationException {
		ITerm dateTime = Factory.CONCRETE.createDateTime(1999, 5, 31, 20, 0,
				05, -4, -30);
		ITerm duration = Factory.CONCRETE.createDuration(false, 0, 0, 0, 4, 30,
				0);
		check(duration, dateTime);

		dateTime = Factory.CONCRETE.createDateTime(2000, 06, 12, 13, 20, 00, 0,
				0);
		duration = Factory.CONCRETE.createDuration(true, 0, 0, 0, 0, 0, 0);
		check(duration, dateTime);
	}

	public void testimezoneFromDate() throws EvaluationException {
		ITerm date = Factory.CONCRETE.createDate(1999, 5, 31, -5, 0);
		ITerm duration = Factory.CONCRETE.createDuration(false, 0, 0, 0, 5, 0,
				0);
		check(duration, date);

		date = Factory.CONCRETE.createDate(2000, 6, 12);
		duration = Factory.CONCRETE.createDuration(true, 0, 0, 0, 0, 0, 0);
		check(duration, date);
	}

	private void check(ITerm expected, ITerm time) throws EvaluationException {
		TimezonePartBuiltin builtin = new TimezonePartBuiltin(time, Y);

		ITuple arguments = Factory.BASIC.createTuple(X, Y);
		ITuple expectedTuple = Factory.BASIC.createTuple(expected);
		ITuple actual = builtin.evaluate(arguments);

		assertEquals(expectedTuple, actual);
	}
}
