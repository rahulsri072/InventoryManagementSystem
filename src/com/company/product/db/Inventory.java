/**
 * 
 */
package com.company.product.db;


import java.util.concurrent.ConcurrentHashMap;


import com.company.product.api.InventoryManagementSystem;
import com.company.product.model.Locations;
import com.company.product.model.PickingResult;
import com.company.product.model.Products;
import com.company.product.model.RestockingResult;

/**
 * @author rahulsrivastava
 *
 */
public class Inventory implements InventoryManagementSystem {
	ConcurrentHashMap<String,Products> map;
	ConcurrentHashMap<String,Locations> map1;
	public Inventory(){
		map=new ConcurrentHashMap<String,Products>();
		map1=new ConcurrentHashMap<String,Locations>();
	}
	public Inventory restockingProducts(Products product)
	{
		map.put(product.getname(), product);
		return this;
	}
	public Inventory restockingLocations(Locations location)
	{
		map1.put(location.getname(),location);
		return this;
	}

	@Override
	public PickingResult pickProduct(String productId, int amountToPick) {

		Products product =map.get(productId);
		product.removeProduct(amountToPick);
		PickingResult pr = new PickingResult(product);
		return pr;
	}

	@Override
	public RestockingResult restProduct(String productId, int amountToRestock) {
		Products product = map.get(productId);
		product.addProduct(amountToRestock);
		RestockingResult rr = new RestockingResult(product);
		return rr;
	}
	public  ConcurrentHashMap<String, Products>getProduct()
	{
		return this.map;
	}

	public ConcurrentHashMap<String, Locations>getLocation()
	{
		return this.map1;
	}
	public void displayProducts(String productName)
	{
		Products product=map.get(productName);
		System.out.println("Total no. of "+product.getname()+ " is " + product.getlevel()+" stored at "+product.getlocation().getname() );

	}

}
