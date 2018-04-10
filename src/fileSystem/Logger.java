package fileSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	private File logFile;
	
	public Logger(String path) {
		logFile = new File(path);
		System.out.println("Logger writing to File: " + logFile.getAbsolutePath());
	}
	
	public void log(String entry) {
		try(FileWriter fw = new FileWriter(logFile)) {
			fw.write(entry);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
