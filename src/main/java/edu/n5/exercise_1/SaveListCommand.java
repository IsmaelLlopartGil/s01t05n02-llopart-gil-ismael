package edu.n5.exercise_1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveListCommand {

	File file;

	public SaveListCommand(String path) {
		this.file = new File(path);
	}

	public void run() {

		if (file.exists() && file.isDirectory()) {
			File[] fileList = file.listFiles();
			saveList(fileList, 0);
		} else {
			System.out.println("Directori no trobat.");
		}
	}

	private void saveList(File[] fileList, int level) {
		String type = "";
		PropertiesHandler propertiesHandler=new PropertiesHandler();
		DiskWriter writer = new DiskWriter(propertiesHandler.getProperty("whrite_file"));
		
		if (fileList!=null) {
			
			for (File file2 : fileList) {

				for (int i = 0; i < level; i++) {
					writer.addString(" ");
				}

				if (file.isDirectory()) {
					type = "D";
				} else if (file.isFile()) {
					type = "F";
				}

				writer.addLine(file2.getName() + " " + type + " " + convertLastModified(file2.lastModified()));

				if (file.isDirectory()) {
					File[] fileList2 = file2.listFiles();
					saveList(fileList2, level + 4);
				}
			}
		} 
	}

	private static String convertLastModified(long rawData) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(rawData));
	}
}
