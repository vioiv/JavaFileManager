package com.kjh.file.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTracker {

	public void copyFilesByYearMon(File defaultDirectory) throws IOException {
		if(defaultDirectory.isDirectory()){
			FileTracker fileTracker = new FileTracker();
			fileTracker.copyFilesByYearMon(defaultDirectory);
		}else {
			long longModified = defaultDirectory.lastModified();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			Date date = new Date(longModified);
			String dateModified = simpleDateFormat.format(date);
			
			String defalutTargetDirectory = "c:/Temp";
			String pathname = defalutTargetDirectory+"/"+dateModified+"/"+defaultDirectory.getName();
			File targetFile = new File(pathname);
			Files.copy(defaultDirectory.toPath(), targetFile.toPath());
		}
	}

}
