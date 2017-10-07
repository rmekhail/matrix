package com.masimo.interview.test.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple MatrixGenerator.
 */
public class MatrixGeneratorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatrixGeneratorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MatrixGeneratorTest.class );
    }
    
    public void testParseInvalid() {
    	Random rnd = new Random();
    	int size = rnd.nextInt(50) + 1;
    	int badIndex = rnd.nextInt(size);
    	ArrayList<String> input = new ArrayList<>(size);
    	List<Float> expected = new ArrayList<>(size);
    	for(int i = 0; i < size - 1; i++) {
    		if(i == badIndex) {
    			input.add("bad data");
    		} else {
    			input.add(String.valueOf(rnd.nextFloat()));
    		}
    		
    	}
    	
    	MatrixGenerator matrix = new MatrixGenerator("");
    	List<Float> actual = matrix.getValuesFromStream(input.stream());
        assertEquals("The lists do not match", expected, actual );
    }
}
