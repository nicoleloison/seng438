package org.jfree.data.test;
 
import static org.junit.Assert.*;
 
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void intersectsTestALB() {       // Above Lower Bound (-4,-3)
        int lower = -4;
        int upper = -3;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
        public void intersectsTestLB() {    // Lower Bound (-5,-4)  
        int lower = -5;
        int upper = -4;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void intersectsTestBLB() { // Below Lower Bound (-7,-6)      
        int lower = -7;
        int upper = -6;
        boolean expected = false;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return false",expected, flag);
    }
     
    @Test
    public void intersectsTestBUB() {   // Below Upper Bound (3,4)  
        int lower = 3;
        int upper = 4;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void intersectsTestUB() {    // Upper Bound (4,5)
        int lower = 4;
        int upper = 5;
        boolean expected = true;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return true",expected, flag);
    }
     
    @Test
    public void intersectsTestAUB() {   // Above Upper Bound (6,7)  
        int lower = 6;
        int upper = 7;
        boolean expected = false;
         
        Assert.assertNotNull(range); // confirm the object reference is not null
         
        boolean flag = range.intersects(lower, upper);
         
        Assert.assertEquals("Expecting it to return false",expected, flag);
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
}