package com.masimo.interview.test.matrix;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/**
 * A matrix stores the computed values and pretty prints its contents
 *
 */
public class Matrix {

	private float[][] computedArray;
	private int size = 1;
	
	public Matrix(int size){
		this.size = size;
		computedArray = new float[size][size];		
	}
	
	public Matrix() {
		computedArray = new float[size][size];
	}
	
	public float getValue(int i, int j) {
		return computedArray[i][j];
	}
	
	public void setValue(int i, int j, float f) {
		computedArray[i][j] = f;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Formatter formatter = new Formatter(builder, Locale.US);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				formatter.format("%.6f\t", computedArray[i][j]);
			}
			formatter.format("%n");
		}
		String out = formatter.toString();
		formatter.close();
		return out;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(computedArray);
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(computedArray, other.computedArray))
			return false;
		if (size != other.size)
			return false;
		return true;
	}


}
