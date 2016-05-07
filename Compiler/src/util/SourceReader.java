package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SourceReader {

	private File sourceFile;
	
	
	public SourceReader(String fileName) {
		String filePath = System.getProperty("user.dir");
		filePath += "\\" + fileName;
		sourceFile = new File(filePath);
	}
	
	public boolean validSourceFile() {
		if (sourceFile == null) {
			System.err.println("The file should not be null");
			return false;
		}
		if (!sourceFile.exists()) {
			System.err.println("The referenced file does not exitst: " + sourceFile);
			return false;
		}
		if (!sourceFile.isFile()) {
			System.err.println("The given argument is not a file: " + sourceFile);
			return false;
		}
		if (!sourceFile.canRead()) {
			System.err.println("The file cannot be read.");
			return false;
		}
		return true;
	}
	
	public String[] readContent() {
		if (validSourceFile()) {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(sourceFile));
				
				List<String> lines = new ArrayList<String>();
				String line = reader.readLine();
				while (line != null) {
					lines.add(line);
					line = reader.readLine();
				}
				
				reader.close();
				
				return lines.toArray(new String[0]);
			} catch (IOException e) {
				System.err.println("There was a problem while the file has been read.");
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
