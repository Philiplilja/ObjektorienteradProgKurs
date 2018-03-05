import java.util.ArrayList;


	public class Cart {
		private ArrayList<Item> shoppingCart = new ArrayList<Item>();
		private ArrayList<CartListener> cartListeners = new ArrayList<CartListener>();
		
		public Cart(){
		}
		
		//adding items to shopping cart
		public void addItem(Item e){
			shoppingCart.add(e);
			for(CartListener cl : cartListeners){
				cl.onAddItem(e);
			}
		}

		//clearing the shopping cart
		public void empty() {
			shoppingCart.clear();
			for(CartListener cl : cartListeners){
				cl.onClear();
			}
		}
		
		public int countItem(){
			return shoppingCart.size();
		}
		
		//counting the total cost
		public int totalCost(){	
			int sum = 0;
			for(int i = 0; i < shoppingCart.size(); i++){
				sum += shoppingCart.get(i).getValue();
			}
			return sum;
		}
		
		//going thru the cart for item names
		public ArrayList<Item> totalCart(){
			String a = "";
			for(Item i : shoppingCart){
				a += i.getName();
			}
			return shoppingCart;
		}
	
		
		public void addListener(CartListener cartlistener){
			cartListeners.add(cartlistener);
		}
}
