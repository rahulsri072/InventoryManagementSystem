package com.company.product.api;
import com.company.product.model.*;

/**
 * @author rahulsrivastava
 *
 */

/**
 * Implementation of this interface and access to shared data must be thread-safe.
 */
public interface InventoryManagementSystem {
/**
* Deduct 'amountToPick' of the given 'productId' from inventory.
* @param productId the Id of the product to pick
* @param amountToPick the quantity of the product to pick
* @return TODO: to be implemented
*/
PickingResult pickProduct(String productId,int amountToPick);
/** 
 * add 'amountToRestock' of the given productId to inventory.
 * @param productId the ID of the product to restock
 * @param amountToRestock the quantity of the product to restock
 * @return TODO: to be implemented
 */
RestockingResult restProduct(String productId,int amountToRestock);
}
