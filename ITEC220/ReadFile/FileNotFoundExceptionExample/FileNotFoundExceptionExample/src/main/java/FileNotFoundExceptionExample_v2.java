package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileNotFoundExceptionExample_v2 {
	
	private static final String filename = "InformationSystems.dat";
	
	public static void main(String[] args) throws InterruptedException {
		BufferedWriter wr = null;
		try {
			// Open the file for writing, without removing its current content.
			wr = new BufferedWriter(new FileWriter(new File(filename), true));
			
			// Write a sample string to the end of the file.
			wr.write("A sample string to be written at the end of the file!\n");
			
			TimeUnit.SECONDS.sleep(10);
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
			ex.printStackTrace();
		}
		finally {
			// Close the file.
			try {
				wr.close();
			}
			catch (IOException ex) {
				System.err.println("An IOException was caught!");
				ex.printStackTrace();
			}
		}
	}
}
