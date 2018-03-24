package org.jfree.data.test;
 
import static org.junit.Assert.*;
 
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
 
public class RangeTest {
    Range range;
     
    @Before
    public void init() throws Exception {
        System.out.println("Setting up");
        range = new Range(-5, 5);
         
    }
     
    @After
    public void destroy() {
        System.out.println("Destroying...");
        range = null;
    }
     
    /////////////////////// Testing intersects() method using BVT ///////////////////////////
    
    @Test
    public void intersectsTestNOM() { // Normal (-1, 1)     
        int lower = -1;
        int upper = 1;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertTrue(flag);
    }
     
    @Test
    public void intersectsTestALB() {       // Above Lower Bound (-4,-3)
        int lower = -4;
        int upper = -3;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertTrue(flag);
    }
     
    @Test
        public void intersectsTestLB() {    // Lower Bound (-5,-4)  
        int lower = -5;
        int upper = -4;
        
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertTrue(flag);
    }
     
    @Test
    public void intersectsTestBLB() { // Below Lower Bound (-7,-6)      
        int lower = -7;
        int upper = -6;

        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertFalse(flag);
    }
     
    @Test
    public void intersectsTestBUB() {   // Below Upper Bound (3,4)  
        int lower = 3;
        int upper = 4;

        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertTrue(flag);
    }
     
    @Test
    public void intersectsTestUB() {    // Upper Bound (4,5)
        int lower = 4;
        int upper = 5;

        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
        System.out.println("Flag : "+flag);
        Assert.assertTrue(flag);
    }
     
    @Test
    public void intersectsTestAUB() {   // Above Upper Bound (6,7)  
        int lower = 6;
        int upper = 7;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertFalse(flag);
    }
    
    @Test
    public void intersectsTestM152() { //Line 152 - Conditional boundary mutation killed
    	int lower = -5;
        int upper = 6;
             
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertTrue(flag);
    }
    
    @Test
    public void intersectsTestM153() { //Line 153 - Conditional boundary mutation killed
    	int lower = -6;
        int upper = -5;
             
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertTrue(flag);
    }
    
    
    //////////End of intersects() method testing//////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
    ////////// Testing contains() method using BVT/////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void containsTestNOM() { // Normal testing value = 0     
        int value = 0;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void containsTestALB() { // Above lower bound value = -4     
        int value = -4;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void containsTestLB() {  // lower bound value = -5   
        int value = -5;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void containsTestBLB() { // below bound value = -6   
        int value = -6;
        boolean expected = false;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return false",expected, flag);
    }
     
    @Test
    public void containsTestBUB() { // below upper bound value = 4  
        int value = 4;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
    @Test
    public void containsTestUB() {  // upper bound value = 5    
        int value = 5;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void containsTestAUB() { // above upper bound value = 6  
        int value = 6;
        boolean expected = false;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.contains(value);
         
        Assert.assertEquals("Expecting it to return false",expected, flag);
    }
     
 
     
    /////////End of contains() method testing/////////////////////////////////////////////////////////////////////////////////////////////////////
 
    //////////Testing constrain() method using BVT/////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void constrainsTestNOM() {   // Normal value = 0     
        double value = 0;
        double expected = 0;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return 0",expected, retValue, 0.001);
    }
     
    @Test
    public void constrainsTestALB() {   // Above Lower Bound value = -4     
        double value = -4;
        double expected = -4;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return -4",expected, retValue, 0.001);
    }
     
    @Test
    public void constrainsTestLB() {    //  Lower Bound value = -5  
        double value = -5;
        double expected = -5;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return -5",expected, retValue, 0.001);
    }
     
    @Test
    public void constrainsTestBLB() {   // Below Lower Bound value = -6     
        double value = -6;
        double expected = -5;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return -5",expected, retValue, 0.001);
    }
     
    @Test
    public void constrainsTestBUB() {   // Below Upper Bound value = 4  
        double value = 4;
        double expected = 4;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return 4",expected, retValue, 0.001);
    }
     
    @Test
    public void constrainsTestUB() {    // Upper Bound value = 5    
        double value = 5;
        double expected = 5;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return 5",expected, retValue, 0.001);
    }
     
    @Test
    public void constrainsTestAUB() {   // Above Upper Bound value = 6  
        double value = 6;
        double expected = 5;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.constrain(value);
         
        Assert.assertEquals("Expecting it to return 5",expected, retValue, 0.001);
    }
     
     
    //////////End of constrain() method testing//////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    //////////Testing getLowerBound() method using ECT/////////////////////////////////////////////////////////////////////////////////////////////////
 
    @Test
    public void getLowerBoundTestLrgNeg() { // Lower bound having a very large negative number  
         
        double lowerBound = -1000000000;
        range = new Range(lowerBound, -10); 
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.getLowerBound();
         
        Assert.assertEquals("Expecting it to return -1000000000",lowerBound, retValue, 0.001);
    }
     
    @Test
    public void getLowerBoundTestAtZero() { // Lower bound being at 0   
         
        double lowerBound = 0;
        range = new Range(lowerBound, 10);  
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.getLowerBound();
         
        Assert.assertEquals("Expecting it to return 0",lowerBound, retValue, 0.001);
    }
     
    @Test
    public void getLowerBoundTestAtZeroZero() { // Lower bound being at 0 and higher bound at 0     
         
        double lowerBound = 0;
        double higherBound = 0;
        range = new Range(lowerBound,higherBound);  
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.getLowerBound();
         
        Assert.assertEquals("Expecting it to return 0",lowerBound, retValue, 0.001);
    }
     
    @Test
    public void getLowerBoundTestPstvLrgNum() { // Lower bound being a very large positive number   
         
        double lowerBound = 1000000000;
        double higherBound = 1000000001;
        range = new Range(lowerBound,higherBound);  
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        double retValue = range.getLowerBound();
         
        Assert.assertEquals("Expecting it to return 1000000000",lowerBound, retValue, 0.001);
    }
     
    //////////End of getLowerBound() method testing//////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    //////////Testing getLength() method using ECT/////////////////////////////////////////////////////////////////////////////////////////////////
 
    @Test
    public void getlengthTestNN() { //Negative to Negative range
        range = new Range(-8, -4);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 4;
         
        assertEquals("Expecting it to return 4", expectedVal, value, 0.001);
         
    }
     
    @Test
    public void getlengthTestNZ() { //Negative to Zero range
        range = new Range(-8, 0);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 8;
         
        assertEquals("Expecting it to return 8", expectedVal, value, 0.001);
         
    }
     
    @Test
    public void getlengthTestNP() { //Negative to Positive range
        range = new Range(-8, 8);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 16;
         
        assertEquals("Expecting it to return 16", expectedVal, value, 0.001);
         
    }
     
    @Test
    public void getlengthTestZZ() { //Zero to Zero range
        range = new Range(0, 0);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 0;
         
        assertEquals("Expecting it to return 0", expectedVal, value, 0.001);
         
    }
     
    @Test
    public void getlengthTestZP() { //Zero to Positive range
        range = new Range(0, 8);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 8;
         
        assertEquals("Expecting it to return 8", expectedVal, value, 0.001);
         
    }
     
    @Test
    public void getlengthTestPP() { //Positive to Positive range
        range = new Range(4, 8);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 4;
         
        assertEquals("Expecting it to return 4", expectedVal, value, 0.001);
         
    }
 
    @Test
    public void getlengthTestBigRange() { //Final test on a big range
        range = new Range(-1000000, 1000000);
         
        Assert.assertNotNull(range);
         
        double value = range.getLength();
        double expectedVal = 2000000;
         
        assertEquals("Expecting it to return 4", expectedVal, value, 0.001);
         
    }
    //////////End of getLowerBound() method testing//////////////////////////////////////////////////////////////////////////////////////////////////////////

    // ************ NEW TESTS ********************
    //////////Testing getUpperBound() method using ECT/////////////////////////////////////////////////////////////////////////////////////////////////
    
	@Test
	public void getUpperBoundTestLrg() { // upper bound having a very large number  
	   
	  double upperBound = 1000000000;
	  range = new Range( -10, upperBound); 
	   
	  Assert.assertNotNull(range); // confirm the object reference is not null
	   
	  double retValue = range.getUpperBound();
	   
	  Assert.assertEquals("Expecting it to return 1000000000",upperBound, retValue, 0.001);
	}
	
	@Test
	public void getUpperBoundTestAtZero() { // upper bound being at 0   
	   
	  double upperBound = 0;
	  range = new Range( -10, upperBound);  
	   
	  Assert.assertNotNull(range); // confirm the object reference is not null
	   
	  double retValue = range.getUpperBound();
	   
	  Assert.assertEquals("Expecting it to return 0",upperBound, retValue, 0.001);
	}
	
	@Test
	public void getUpperBoundTestAtZeroZero() { // lower bound being at 0 and higher bound at 0     
	   
	  double lowerBound = 0;
	  double higherBound = 0;
	  range = new Range(lowerBound,higherBound);  
	   
	  Assert.assertNotNull(range); // confirm the object reference is not null
	   
	  double retValue = range.getLowerBound();
	   
	  Assert.assertEquals("Expecting it to return 0",lowerBound, retValue, 0.001);
	}
	
	@Test
	public void getUpperBoundTestNegLrgNum() { // upper bound being a very large negative number   
	   
	  double lowerBound = -1000000002;
	  double higherBound = -1000000001;
	  range = new Range(lowerBound,higherBound);  
	   
	  Assert.assertNotNull(range); // confirm the object reference is not null
	   
	  double retValue = range.getUpperBound();
	   
	  Assert.assertEquals("Expecting it to return 1000000000",higherBound, retValue, 0.001);
	}
	
	//////////End of getUpperBound() method testing//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void toStringTest() { // Testing to string
		String expected = "Range[-5.0,5.0]";
		String actual = range.toString();
		Assert.assertEquals("Expected to get Range[-5.0,5.0]", expected, actual);
	}
	
	@Test
	public void getCentralValueTestNOM() {
		double expected = 0;
		double actual = range.getCentralValue();
		Assert.assertEquals("Expected to get 0", expected, actual, 0.01d);
	}
	
	// Testing the constructor for illegal values
	@Test
	public void illegalRangeTest() {
		String errorMsg = "Range(double, double): require lower (5.0) <= upper (-5.0).";
		try {
			Range range = new Range(5, -5);
		}catch(Exception e) {
			Assert.assertEquals(errorMsg, e.getMessage());
		}
		
	}
	
	///// Testing Equals/////////////
	
	@Test
	public void notEqualsTest() {
		String s = ""; // make a dummy obj
		boolean actual = range.equals(s);
		Assert.assertTrue("not false", !(actual));
	}
	@Test
	public void notEqualsLBTest() {
		Range r = new Range(-6, 5);
		boolean actual = range.equals(r);
		Assert.assertTrue("not false", !(actual));
	}
	@Test
	public void equalsUBTest() {
		Range r = new Range(-5, 5);
		boolean actual = range.equals(r);
		Assert.assertTrue(actual);
	}
	
	@Test
	public void equalsUBNotEqualsLBTest() {
		Range r = new Range(-6, 5);
		boolean actual = range.equals(r);
		Assert.assertTrue("not false", !(actual));
	}
	@Test
	public void equalsLBNotEqualsUBTest() {
		Range r = new Range(-5, 6);
		boolean actual = range.equals(r);
		Assert.assertTrue(!actual);
	}
	/////////////////////////////////////////////////////////
	
	// Expand tests/////////////
	@Test
	public void expandNullTest() {
		Range r = null;
		String error = "Null 'range' argument.";
		try {
			range.expand(r, 0, 0);
		}catch(Exception e) {
			Assert.assertEquals(error, e.getMessage());
		}
	}
	@Test
	public void expandNormalTest() {
		Range expected = new Range(45, 55);
		Range actual = range.expand(range, -5, 5);
		
		Assert.assertEquals(expected, actual);
	}
	
	/////////////////////////////////////////////////////////
	
	// Combine tests /////////////
	
	@Test
	public void combineNullXTest() { // Testing scenario where the first argument is null
		Range rangeX = null;
		Range rangeY = new Range(-10, 1);
		Range expected = rangeY;
		Range actual = Range.combine(rangeX, rangeY);
		
		Assert.assertEquals("Expected rangeY", expected, actual);
	}
	
	@Test
	public void combineNullYTest() { // Testing scenario where the second argument is null
		Range rangeX = new Range(-10, 1);
		Range rangeY = null;
		Range expected = rangeX;
		Range actual = Range.combine(rangeX, rangeY);
		
		Assert.assertEquals("Expected rangeX", expected, actual);
	}
	
	@Test
	public void combineTest() { // Testing scenario where both arguments are not null
		Range rangeX = new Range(-10, 1);
		Range rangeY = new Range(0, 10);
		Range expected  = new Range(-10, 10);
		Range actual = Range.combine(rangeX, rangeY);
		
		Assert.assertEquals("Expected Range(-10, 10)", expected, actual);
	}
	
	@Test
	public void combineTestM208_210() { //Lines 208 and 209 - Remove/Replace call mutations killed
		Range rangeX = new Range(0, 10);
		Range rangeY = new Range(-10, 1);
		Range expected  = new Range(-10, 10);
		Range actual = Range.combine(rangeX, rangeY);
		
		Assert.assertEquals("Expected Range(-10, 10)", expected, actual);
	}
	
	
	////////////////////////////////////////////////////////
	
	// expandToInclude tests /////////////
	
	@Test
	public void expandToIncludeNullObjTest() { // Testing scenario where object is null
		Range r = null;
		double value = 10;
		Range expected = new Range(10, 10);
		Range actual = Range.expandToInclude(r, value);
		
		Assert.assertEquals("Expected Range (10, 10)", expected, actual);
	}
	
	@Test
	public void expandToIncludeBLBTest() { // Testing scenario where value sets new lower bound
		Range r = new Range(0, 10);
		double value = -10;
		Range expected = new Range(-10, 10);
		Range actual = Range.expandToInclude(r, value);
		
		Assert.assertEquals("Expected Range (-10, 10)", expected, actual);
	}
	
	@Test
	public void expandToIncludeAUBTest() { // Testing scenario where value sets new upper bound
		Range r = new Range(0, 5);
		double value = 10;
		Range expected = new Range(0, 10);
		Range actual = Range.expandToInclude(r, value);
		
		Assert.assertEquals("Expected Range (0, 10)", expected, actual);
	}
	
	@Test
	public void expandToIncludeSubsetTest() { // Testing scenario where value is within the range of object
		Range r = new Range(0, 10);
		double value = 5;
		Range expected = new Range(0, 10);
		Range actual = Range.expandToInclude(r, value);
		
		Assert.assertEquals("Expected Range (0, 10)", expected, actual);
	}
	
	@Test
	public void expandToIncludeSubsetTestM229() { //Line 229 - Remove call mutant killed
		Range r = new Range(5, 10);
		double value = 4;
		Range expected = new Range(4, 10);
		Range actual = Range.expandToInclude(r, value);
		
		Assert.assertEquals("Expected Range (4, 10)", expected, actual);
	}
	
	@Test
	public void expandToIncludeSubsetTestM233() { //Line 233 - Remove call mutant killed
		Range r = new Range(5, 10);
		double value = 11;
		Range expected = new Range(5, 11);
		Range actual = Range.expandToInclude(r, value);
		
		Assert.assertEquals("Expected Range (4, 10)", expected, actual);
	}
	
	//////////////////////////////////////////////////////////
	
	// shift tests /////////////
	
	@Test
	public void shiftZeroCrossingTest() { // Testing scenario where a range can cross 0
		Range base = new Range(-5, -1);
		double delta = 10;
		boolean allowZeroCrossing = true;
		Range expected = new Range(5, 9);
		Range actual = Range.shift(base, delta, allowZeroCrossing);
	
		Assert.assertEquals("Expected Range(5, 9)", expected, actual);
	}
	
	@Test
	public void shiftNoZeroCrossingTest() { // Testing a scenario where a range can not cross 0
		Range base = new Range(-5, -1);
		double delta = 10;
		Range expected = new Range(0, 0);
		Range actual = Range.shift(base, delta);
		
		Assert.assertEquals("Expected Range(0, 0)", expected, actual);
	}
	
	@Test
	public void shiftNegativeTest() { // Testing a scenario where the shift delta is negative
		Range base = new Range(0, 5);
		double delta = 10;
		Range expected = new Range(10, 15);
		Range actual = Range.shift(base, delta);
		
		Assert.assertEquals("Expected Range(10, 15)", expected, actual);
	}
	
	@Test
	public void shiftWithNoZeroCrossingTestM322() { //Line 322 - sub 0.0 with 1.0 killed
		Range base = new Range(0.1, 5);
		double delta = 0.5;
		Range expected = new Range(0.6, 5.5);
		Range actual = Range.shift(base, delta, false);
		
		Assert.assertEquals("Expected Range(0.6, 5.5)", expected, actual);
	}
	
	@Test
	public void shiftWithNoZeroCrossingTestM325() { //Line 325 - remove/raplace call mutants Killed
		Range base = new Range(-5, 5);
		double delta = 1;
		Range expected = new Range(-4, 6);
		Range actual = Range.shift(base, delta, false);
		
		Assert.assertEquals("Expected Range(-4, 6)", expected, actual);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void hasCodeTestM362_366() {// Hash method was not tested before and 1 test was enough to take care of all its mutants 
		
		Assert.assertNotNull(range);
		
		int expected = 39321600;
		int actual = range.hashCode();
		
		Assert.assertEquals("Expected hash: 39321600", expected, actual);
	}

}