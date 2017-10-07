package com.masimo.interview.test.matrix;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * The CommandLine object handles the interface.
 *
 */
public class CommandLine {

	public static void main(String[] args) {
		Console console = System.console();
		if(console == null) {
			System.err.println("No console available");
			System.exit(1);
		}
		
		String cValue = console.readLine("Enter c value: ");
		int c = Integer.parseInt(cValue);
		
		if (c < 1) {
			System.err.println("c value must be positive");
			System.exit(2);
		}
		
		String filePath = console.readLine("Enter file path: ");
		MatrixGenerator generator = new MatrixGenerator(filePath);
		;
		try(Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.US_ASCII)) {
			Matrix matrix = generator.makeMatrix(stream, c);
			System.out.println(matrix.toString());
		} catch (IOException e) {
			System.out.println("ERROR: Unable to open " + filePath);
		}
		
	}

}
