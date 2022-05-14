package edu.n5.exercise_1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListCommand {

	File path;

	public ListCommand(String path) {
		this.path = new File(path);
	}

	public void run() {

		if (path.exists() && path.isDirectory()) {
			File[] fileList = path.listFiles();
			showList(fileList, 0);
		} else {
			System.out.println("Directori no trobat.");
		}
	}

	private void showList(File[] fileList, int level) {
		String type = "";

		if (fileList!=null && level<100) {
			
			for (File file : fileList) {

				for (int i = 0; i < level; i++) {
					System.out.print(" ");
				}

				if (file.isDirectory()) {
					type = "D";
				} else if (file.isFile()) {
					type = "F";
				}

				System.out.println(file.getName() + " " + type + " " + convertLastModified(file.lastModified()));

				if (file.isDirectory()) {
					File[] fileList2 = file.listFiles();
					showList(fileList2, level + 4);
				}
			}
		} 
	}

	private static String convertLastModified(long rawData) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(rawData));
	}
}
