package thesis.scxmlidl.utils;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void createFolder(String name) {

		File theDir = new File(name);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
//			System.out.println("creating directory: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
//				System.out.println("DIR created");
			}
		}
	}

	public void createFile(String name) {

		try {
			System.setOut(new PrintStream(new File("Generated Source/" + name)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> listFilesForFolder(final File folder) {
		ArrayList<String> webIDL = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				Path currentRelativePath = Paths.get("");
				String s = folder.getAbsolutePath();
//				System.out.println("currently looking"+folder.getAbsolutePath());
//				System.out.println(s);
//				System.out.println("1" + s + "/" + fileEntry.getName());
				webIDL.add(s+"/"+fileEntry.getName());
			}
		}
		return webIDL;
	}
}
