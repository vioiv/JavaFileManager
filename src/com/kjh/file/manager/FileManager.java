package com.kjh.file.manager;

import java.io.File;
import java.io.IOException;

public class FileManager {

	public static void main(String[] args) throws IOException {
		String defaultDirectoryPath = "c:/";
		File defaultDirectory = new File(defaultDirectoryPath); 
		
		FileTracker fileTracker = new FileTracker();
		fileTracker.copyFilesByYearMon(defaultDirectory);
	}

	
	
	

}
