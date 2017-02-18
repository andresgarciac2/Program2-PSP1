package edu.uniandes.ecos.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.uniandes.ecos.program.Part;
import edu.uniandes.ecos.program.ProgramResult;
import edu.uniandes.ecos.program.size.calculator.ProgramSizeCalculator;

public class Reader {

	List<Part> parts = new ArrayList<Part>();
	ProgramSizeCalculator calculator = new ProgramSizeCalculator();
	
	public void fileReader(String path,String name) {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String sCurrentLine;

			String allFile = "";
			int methods = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				if(calculator.isMethod(sCurrentLine))methods++;
				sCurrentLine = sCurrentLine.replaceAll("\\s+", "");
				allFile += sCurrentLine + "\n";
				
			}
			parts.add(calculator.calculatePartSize(allFile, name,methods));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
				if (fr != null)fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				fileReader(fileEntry.getAbsolutePath(),fileEntry.getName());
			}
		}
	}
	
	public ProgramResult getResults(){
		return calculator.calculateProgramSize(parts);
	}
	
}
