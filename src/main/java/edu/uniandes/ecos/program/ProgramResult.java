package edu.uniandes.ecos.program;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AndrésGarcía
 *
 */
public class ProgramResult {

	List<Part> parts = new ArrayList<Part>();
	int size;
	
	/**
	 * @param parts
	 * @param size
	 */
	public ProgramResult(List<Part> parts, int size) {
		super();
		this.parts = parts;
		this.size = size;
	}

	/**
	 * @return the parts
	 */
	public List<Part> getParts() {
		return parts;
	}

	/**
	 * @param parts the parts to set
	 */
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
