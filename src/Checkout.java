public class Checkout {
    private static final double SHIPPING_FEES = 30;
 public void checkout(Customer customer,Cart cart) {
    if (cart.isEmpty()){
        throw new IllegalArgumentException("Cart is empty");
    }
    for(CartItem cartItem: cart.getCartItems()){
        if (cartItem.product.isExpired())
            throw new IllegalStateException(cartItem.product.getName() + " is expired");
        if(cartItem.quantity>cartItem.product.getQuantity()){
            throw new IllegalStateException("Not enough quantity for " + cartItem.product.getName());
        }
    }
    double subTotal=cart.getSubTotal();
    double paidAmount= subTotal + SHIPPING_FEES ;
    if (paidAmount>customer.getBalance())
        throw new IllegalStateException("The balance is insufficient.");
    ShippingService shippingService = new ShippingService();
    shippingService.ship(cart.getShippables());

    customer.reduceBalance(paidAmount);
    for (CartItem cartItem: cart.getCartItems()){
        cartItem.product.reduceQuantity(cartItem.quantity);
    }
    System.out.println("** Checkout receipt ** ");

     for (CartItem cartItem: cart.getCartItems()){
         System.out.printf("%dx %-12s %.0f\n",cartItem.quantity,cartItem.product.getName(),cartItem.getTotalForItem());
     }
     System.out.println("----------------------");
     System.out.printf("Subtotal         %.0f\n", subTotal);
     System.out.printf("Shipping         %.0f\n", SHIPPING_FEES);
     System.out.printf("Amount           %.0f\n", paidAmount);
     System.out.printf("Balance left     %.0f\n", customer.getBalance());


 }
}
