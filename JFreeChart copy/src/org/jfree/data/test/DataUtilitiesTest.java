package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import org.jmock.*;


public class DataUtilitiesTest {
	@BeforeClass 
	public static void setUpBeforeClass()
			throws Exception {
			}

	/*calculateColumnTotal(Values2D data, int column) 
	 * Returns the total of the values in one column of
	 *  the supplied data table.*/
@Test
public void calculateColumnTotalForTwoValues() {
	/*Parameters:
data - the table of values (null not permitted).
column - the column index (zero-based).
Returns:
The total of the values in the specified column.
	 * */
	// setup
	Mockery mockingContext = new Mockery();
	final Values2D values = mockingContext.mock(Values2D.class);
	mockingContext.checking(new Expectations() {
	{
	one(values).getRowCount();
	will(returnValue(2));
	one(values).getValue(0, 0);
	will(returnValue(7.5));
	one(values).getValue(1, 0);
	will(returnValue(2.5));
	}
	});
	// exercise 
	double result = DataUtilities.calculateColumnTotal(values, 0);
	// verify
	assertEquals(result, 10.0, .000000001d);
	// tear-down: NONE in this test method
}


@Test
/*returns double
 * calculateRowTotal(Values2D data, int row)
 * Returns the total of the values in one row 
 * of the supplied data table.
 */
public void calculateRowTotalForTwoValues() {
	// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			/*values:
			 * {1,0   2.0
			 *  3.0   4.0}*/
		{
		one(values).getColumnCount();
		will(returnValue(2));
		one(values).getValue(0, 0);
		will(returnValue(1.0));
		one(values).getValue(0, 1);
		will(returnValue(2.0));
		one(values).getValue(1, 0);
		will(returnValue(3.0));
		one(values).getValue(1, 1);
		will(returnValue(4.0));
		}
		});
		// exercise 
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
		assertEquals("the expected result is",result, 3.0, .000000001d);
		// tear-down: NONE in this test method
}

@Test
/*returns Number[]
 * 	createNumberArray(double[] data)
 * Constructs an array of Number objects 
 * from an array of double primitives.
 */
public void createNumberArray() {
	/*public static java.lang.Number[] createNumberArray(double[] data)
Constructs an array of Number objects from an array of double primitives.
Parameters:
data - the data (null not permitted).
Returns:
An array of Double.
	 * */
	// setup
		//Mockery mockingContext = new Mockery();
		double[] values = new double []{1.0, 1.0, 1.0};
		// exercise 
		Number[] expected = new Number[3];
		double data = 1.0;
		for (int i = 0; i < values.length; i++) {
			expected[i] = data;
			}
		Number [] actual = DataUtilities.createNumberArray(values);
		// verify
		boolean result = actual.equals(values);
		assertTrue(result);
}

@Test
/*returns Number[]
 * createNumberArray2D(double[][] data)
 * Constructs an array of arrays of Number objects 
 * from a corresponding structure containing double primitives.
 */
public void createNumberArray2D() {
	/*public static java.lang.Number[][] createNumberArray2D(double[][] data)
	Constructs an array of arrays of Number objects from a corresponding structure containing double primitives.
	Parameters:
	data - the data (null not permitted).
	Returns:
	An array of Double.*/
	double[] []values = new double [][]{
		{ 1.0, 1.0 },
		{ 1.0, 1.0 },
	};
	// exercise 
	Number[][] expected = new Number[2][2];
	double data = 1.0;
	 for (int i = 0; i < 1; i++) {
		 for (int j = 0; j < 1; j++) {
			 expected[i][j] = data;
			 }
		 }
	Number [][] actual = DataUtilities.createNumberArray2D(values);
	// verify
	boolean result = actual.equals(values);
	assertTrue(result);
}


@Test
/*returns KeyedValues
 * 	getCumulativePercentages(KeyedValues data) 
 * Returns a KeyedValues instance that contains 
 *  the cumulative percentage values for the data in 
 *  another KeyedValues instance.
 * */
public void getCumulativePercentage() {
	/*Returns a KeyedValues instance that contains 
	 * the cumulative percentage values for the data 
	 * in another KeyedValues instance.
	 * The percentages are values between 0.0 and 1.0 (where 1.0 = 100%).

Parameters:
data - the data (null not permitted).
Returns:
The cumulative percentages.*/
	Mockery mockingContext = new Mockery();
	final KeyedValues dataKV = mockingContext.mock(KeyedValues.class);
	mockingContext.checking(new Expectations() {
	{
		
		/*dataKV is a 3 item list such that:
		 * {[ 1.0 , 4.0 ] ,
		 * [ 2.0 , 16 .0] , 
		 * [ 3.0,   20.0]}*/
		one(dataKV).getItemCount();
		will(returnValue(3));
		
		Number a = 4.0;
		Number b = 16.0;
		Number c = 20.0;
		one(dataKV).getValue(1);
		will(returnValue(a));
		one(dataKV).getValue(2);
		will(returnValue(b));
		one(dataKV).getValue(3);
		will(returnValue(c));
	}
	});
	
	/*
	 * so expected return is: 
	 *  {[ 1.0 , 0.1 ] ,[ 2.0 , 0.4 ] , [ 3.0, 1.0]}
	*/
	
	HashMap expected = new HashMap(); 
	expected.put(1.0, 0.1);
	expected.put(2.0, 0.4);
	expected.put(3.0, 1.0);
	
	
	HashMap actual = (HashMap) DataUtilities.getCumulativePercentages(dataKV); 
	// exercise 
	assertEquals("the expected result is" ,expected, actual);
	
}


@After
public void tearDown() throws Exception {
}
	
@AfterClass
public static void tearDownAfterClass() throws Exception {
}

}
