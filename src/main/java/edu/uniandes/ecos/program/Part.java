package edu.uniandes.ecos.program;

/**
 * @author AndrésGarcía
 *
 */
public class Part {

	/**
	 * atributos
	 */
	String name;
	int size;
	int methods;
	
	
	
	/**
	 * @param name
	 * @param size
	 * @param methods
	 */
	public Part(String name, int size, int methods) {
		super();
		this.name = name;
		this.size = size;
		this.methods = methods;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	/**
	 * @return the methods
	 */
	public int getMethods() {
		return methods;
	}
	/**
	 * @param methods the methods to set
	 */
	public void setMethods(int methods) {
		this.methods = methods;
	}
	
	
	
}
