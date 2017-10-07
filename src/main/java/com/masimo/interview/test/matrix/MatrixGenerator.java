package com.masimo.interview.test.matrix;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The generator retrieves the input data and computes the matrix
 *
 */
public class MatrixGenerator {

	private String filePath;
	
	public MatrixGenerator(String filePath) {
		this.filePath = filePath;
	}
	
	public List<Float> getValuesFromStream(Stream<String> stream) {
		List<Float> values = new ArrayList<>(100);
		try
		{
			values = stream.map(Float::parseFloat).collect(Collectors.toList());
		} catch (NumberFormatException e){
			System.err.println("File contains non-numeric entries. Please check " + filePath);
		}
		return values;
	}

	public Matrix makeMatrix(Stream<String> stream, int c) {
		List<Float> values = getValuesFromStream(stream);
		int size = c + 1;
		Matrix m = new Matrix(size);
		for(int k = 0; k <= c; k++) {
			for(int j = 0; j <= k; j++){
				float sum = 0;
				for(int i = c; i < values.size(); i++){
					sum += values.get(i - k) * values.get(i - j);
				}
				m.setValue(k, j, sum);
				m.setValue(j, k, sum);
			}
		}
		return m;
	}

}
