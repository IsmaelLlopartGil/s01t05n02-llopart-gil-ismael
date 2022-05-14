package edu.n5.exercise_1;

import java.io.*;

public class DiskWriter {

	private String fileName;

	public DiskWriter(String fileName) {
		this.fileName = fileName;
	}

	public void addLine(String line) {

		try (FileWriter fileWriter = new FileWriter(fileName, true)) {
			fileWriter.write(line + "\r");
		} catch (IOException e) {
			System.out.println("Error: " + e);
			;
		}
	}
	
	public void addString(String string) {

		try (FileWriter fileWriter = new FileWriter(fileName, true)) {
			fileWriter.write(string);
		} catch (IOException e) {
			System.out.println("Error: " + e);
			;
		}
	}
	
}
