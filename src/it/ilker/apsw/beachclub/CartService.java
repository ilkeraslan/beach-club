package it.ilker.apsw.beachclub;

import java.util.ArrayList;
import java.util.List;

import it.ilker.apsw.beachclub.controllers.Database;
import it.ilker.apsw.beachclub.models.CartItem;
import it.ilker.apsw.beachclub.models.Client;
import it.ilker.apsw.beachclub.models.Query;

public class CartService {
	
	private static List<CartItem> cartItems = new ArrayList<CartItem>();
	
	static {
		String sql = "select * from cart order by id";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		System.out.println(result.toString());
		
		constructQueryResult(result);
	}

	/*
	 * Helper method to construct the list from the query result
	 */
	private static void constructQueryResult(List<List<String>> result) {
		for(int i=1; i<result.size(); i++) {
			// Check if client has existing debt
			if(result.get(i).get(2) != null) {
				insertItem(new CartItem(
						result.get(i).get(0),
						result.get(i).get(1),
						Integer.parseInt(result.get(i).get(2))
					)
				);
			} else {
				// Insert a CartItem without debt
				insertItem(new CartItem(
						result.get(i).get(0),
						result.get(i).get(1)
					)
				);
			}
		}
	}
	
	private static void refreshCartItems() {
		String sql = "select * from cart order by id";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		cartItems = new ArrayList<CartItem>();
		
		constructQueryResult(result);
	}
	
	private static void insertItem(CartItem cartItem) {
		if(!cartItems.contains(cartItem)) {
			cartItems.add(cartItem);
		}
	}

	public static List<CartItem> getCartItems() {
		return cartItems;
	}
	
	public static CartItem getCartItem(Client client) {
		refreshCartItems();
		for(int i=0; i<cartItems.size(); i++) {
			if(cartItems.get(i).getclientID().equals(client.getId())) {
				return cartItems.get(i);
			}
		}
		return null;
	}
	
	public static void addToCart(CartItem cartItem) {
		if(!cartItems.contains(cartItem)) {
			try {
				String sql = "insert into cart (user_id, debt) values " + 
						"('" + cartItem.getclientID() + "', '" + cartItem.getDebt() + "')";
				Query query = new Query(sql);
				Database.execute(query);
				
				System.out.println(sql);
				
				if(query.getStatus() == Database.NORESULT) {
					cartItems.add(cartItem);
					System.out.println("Added to cart.");
				} else {
					System.out.println("Insertion in cart failed.");
				}
			} catch(Exception exception) {
				System.out.println("Insertion in cart failed: " + exception.getLocalizedMessage());
			}
		}
	}
	
	public static void removeFromLine(CartItem cartItem) {
		if(cartItems.contains(cartItem)) {
			try {
				String sql = "delete from cart where user_id='" + cartItem.getclientID() + "'";
				Query query = new Query(sql);
				Database.execute(query);
				
				System.out.println(sql);
				
				if(query.getStatus() == Database.NORESULT) {
					cartItems.remove(cartItem);
					System.out.println("Deleted from cart.");
				} else {
					System.out.println("Deletion from cart failed.");
				}
			} catch(Exception exception) {
				System.out.println("Deletion from cart failed: " + exception.getLocalizedMessage());
			}
		}
	}
}
