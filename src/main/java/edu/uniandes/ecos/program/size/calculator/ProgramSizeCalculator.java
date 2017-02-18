package edu.uniandes.ecos.program.size.calculator;

import java.util.List;

import edu.uniandes.ecos.program.Part;
import edu.uniandes.ecos.program.ProgramResult;

public class ProgramSizeCalculator {
	
	public ProgramResult calculateProgramSize(List<Part> parts){
		int totalSize = 0;
		for(Part p : parts){
			totalSize += p.getSize();
		}
		return new ProgramResult(parts, totalSize);
	}
	
	public Part calculatePartSize(String code,String name,int methods){
		
		code = code.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)", "");
		String[] lines = code.split("\n");
		code = "";
		for(String s : lines){
			if(!s.equals(""))
				code += s + "\n";
			
		}
		lines = code.split("\n");
		return new Part(name,lines.length,methods);
		
	}
	
	public boolean isMethod(String line){
		return line.matches("\\s+(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
	}
	
}
