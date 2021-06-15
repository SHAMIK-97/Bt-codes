package com.testing.automation.Controller;

import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class FileConvertion {
	
	public String fileEncoder(File file) {
		
		byte[] bytes=null;
		try {
			bytes = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Base64.getEncoder().encodeToString(bytes);
	}

}
