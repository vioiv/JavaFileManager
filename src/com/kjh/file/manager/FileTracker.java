package com.kjh.file.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTracker {

	public void copyFilesByYearMon(File sourceLocation) throws IOException {
		if(sourceLocation.isDirectory()){
			File[] files = sourceLocation.listFiles();
			FileTracker fileTracker = new FileTracker();
			
			for(File file:files) {
				fileTracker.copyFilesByYearMon(file);
			}
		}else {
			long longModified = sourceLocation.lastModified();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			Date date = new Date(longModified);
			String dateModified = simpleDateFormat.format(date);
			
			String defalutTargetDirectory = "c:/Temp";
			String pathname = defalutTargetDirectory+"/"+dateModified+"/"+sourceLocation.getName();
			File targetFile = new File(pathname);
			Files.copy(sourceLocation.toPath(), targetFile.toPath());
			System.out.println("Source -> "+sourceLocation.getAbsolutePath());
			System.out.println("Target -> "+targetFile.getAbsolutePath());
		}
	}

}
