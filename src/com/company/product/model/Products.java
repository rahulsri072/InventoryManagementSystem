/**
 * 
 */
package com.company.product.model;

/**
 * @author rahulsrivastava
 *
 */
public class Products {
	private Locations location;
	private int level;
	private String name;
	public Products(Locations location,int level, String name )
	{
		this.location=location;
		this.level=level;
		this.name=name;
	}


	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void removeProduct(int amountToPick)
	{
		this.level=level- amountToPick;
	}
	public void addProduct(int amountToRestock)
	{
		this.level=level- amountToRestock;
	}

	public Locations getlocation() {
		return location;
	}
	public void setlocation(Locations location1) {
		this.location = location1;
	}

	public int getlevel() {
		return level;
	}
	public void setlevel(int level) {
		this.level = level;
	}
}
