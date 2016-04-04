/**
 * 
 */
package com.company.product.app;

import java.util.Scanner;

import com.company.product.db.Inventory;
import com.company.product.model.Locations;
import com.company.product.model.PickingResult;
import com.company.product.model.Products;
import com.company.product.model.RestockingResult;

/**
 * @author rahulsrivastava
 *
 */
public class IMS {

	/**
	 * @param args
	 */
	static Inventory inventory = new Inventory();
	static int choice = 0;

	public static Inventory warehouse() // Storing Products in different
										// locations in a single Warehouse.
	{
		Locations L1 = new Locations("Location1");
		Locations L2 = new Locations("Location2");
		Locations L3 = new Locations("Location3");

		Products p1 = new Products(L1, 0, "Product1");
		Products p2 = new Products(L1, 1, "Product2");
		Products p3 = new Products(L1, 2, "Product3");
		Products p4 = new Products(L2, 0, "Product4");
		Products p5 = new Products(L2, 1, "Product5");
		Products p6 = new Products(L2, 2, "Product6");
		Products p7 = new Products(L2, 2, "Product7");
		Products p8 = new Products(L3, 0, "Product8");
		Products p9 = new Products(L3, 1, "Product9");
		Products p10 = new Products(L3, 2, "Product10");

		inventory.restockingProducts(p1);
		inventory.restockingLocations(L1);

		inventory.restockingProducts(p2);
		inventory.restockingLocations(L1);

		inventory.restockingProducts(p3);
		inventory.restockingLocations(L1);

		inventory.restockingProducts(p4);
		inventory.restockingLocations(L2);

		inventory.restockingProducts(p5);
		inventory.restockingLocations(L2);

		inventory.restockingProducts(p6);
		inventory.restockingLocations(L2);

		inventory.restockingProducts(p7);
		inventory.restockingLocations(L2);

		inventory.restockingProducts(p8);
		inventory.restockingLocations(L3);

		inventory.restockingProducts(p9);
		inventory.restockingLocations(L3);

		inventory.restockingProducts(p10);
		inventory.restockingLocations(L3);

		return inventory;
	}

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			inventory = warehouse();

			while (choice != 4) {
				System.out.println("Please enter your choice");
				System.out.println("1:I want to see product in inventory");
				System.out.println("2:I want to pick products from inventory");
				System.out.println("3:I want to restock");
				System.out.println("4:I want to exit");
				choice = Integer.parseInt(in.nextLine());
				inventory = selectedbyUser(choice);
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter valid input");

		}
	}

	public static String isExists(Inventory in) {
		System.out.println("Please enter the productId which you want: \n");
		String pid = IMS.in.nextLine();
		return (in.getProduct().containsKey(pid)) ? pid : null;
	}

	public static int checkStock(String productId, Inventory in) {
		Products pro = in.getProduct().get(productId);
		System.out.println("Please enter no. of products : \n");
		int count = Integer.parseInt(IMS.in.nextLine());

		return (count <= pro.getlevel()) ? count : -1;

	}

	public static int fillInventory() {

		System.out.println("Enter how many of the items you want to restock: \n");
		String restockCount = IMS.in.nextLine();
		return (restockCount == null) ? Integer.parseInt(restockCount) : -1;

	}

	public static Inventory selectedbyUser(int choice) {
		int amountToPick;
		int restockInventory;
		String productId;

		try {
			switch (choice) {

			case 1:
				productId = isExists(inventory);
				if (productId == null)
					System.out.println("Product is not available in inventory, please try again.");
				else
					inventory.displayProducts(productId);
				break;
			case 2:
				productId = isExists(inventory);
				if (productId == null)
					System.out.println("Product not available in inventory, please try again.");
				else {
					amountToPick = checkStock(productId, inventory);
					if (amountToPick == -1)
						System.out.println("Sorry,Given product is not in that much of amount. \n");
					else {
						PickingResult pickingResult = inventory.pickProduct(productId, amountToPick);

						System.out.println("Total no. of " + pickingResult.getProduct().getname() + " is "
								+ pickingResult.getProduct().getlevel());

						pickingResult.getProduct().getlocation().getname();
					}
				}
				break;
			case 3: {
				productId = isExists(inventory);
				if (productId == null)
					System.out.println(
							"Given productId is not existing in Inventory, so you can't restock.Please try Again\n");
				else {
					restockInventory = fillInventory();

					RestockingResult restockingResult = inventory.restProduct(productId, restockInventory);
					System.out.println("The total no of" + restockingResult.getProduct().getname() + "is "
							+ restockingResult.getProduct().getlevel() + " which is stored at"
							+ restockingResult.getProduct().getlocation().getname());

				}

			}
				break;
			case 4:
				System.out.println("EXIT");
				System.exit(0);
			}

		} catch (Exception e) {
			System.out.println("Wrong input,Please try again.");

		}
		System.out.println("Wrong input,Please try again.");
		return inventory;
	}
}
