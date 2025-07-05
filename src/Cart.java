import java.util.*;
public class Cart {

   List<CartItem> CartItems= new ArrayList<>();
   public void addItem(Product product,int quantity) {
       if (product.isExpired()) {
           throw new IllegalArgumentException(product.getName() + " is expired.");
       }
       if(quantity<= product.getQuantity()) {
           CartItems.add(new CartItem(product,quantity));
       }
       else {
           throw new IllegalArgumentException("Not enough quantity for " + product.getName());
       }
   }

   public double getSubTotal() {
       double SubTotal=0;
       for(CartItem item:CartItems) {
           SubTotal+=item.getTotalForItem();
       }
       return SubTotal;
   }
   public boolean isEmpty() {
       return CartItems.isEmpty();
   }

    public List<CartItem> getCartItems() {
        return CartItems;
    }

    public List<Shippable> getShippables() {
       List<Shippable> shippables = new ArrayList<>();
       for(CartItem item:CartItems) {
           if(item.product.isShippable()){
               if(item.product instanceof Shippable){
                   for (int i = 0; i < item.quantity; i++) {
                       Shippable shippable = (Shippable) item.product;
                       shippables.add(shippable);
                   }
               }
           }
       }
       return shippables;
    }

}
